package kr.ac.kopo.favorite;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.account.service.AccountService;
import kr.ac.kopo.favorite.service.FavoriteService;
import kr.ac.kopo.vo.FollowVO;
import kr.ac.kopo.vo.LikeCompanyVO;
import kr.ac.kopo.vo.PortfolioVO;
import kr.ac.kopo.vo.StockBuySellVO;
import kr.ac.kopo.vo.StockTodayVO;
import kr.ac.kopo.vo.StockWeightVO;
import kr.ac.kopo.vo.WaggleJoinVO;
import kr.ac.kopo.waggle.servie.WaggleService;
@Controller
public class FavoriteController {


	@Autowired
	private FavoriteService service;
	
	@Autowired
	private WaggleService wservice;
	
	@Autowired AccountService aservice;
	
	
	/* 관심종목페이지 */
	@GetMapping("/like/company")
	public String myfavorite(HttpSession session, Model model) {
		WaggleJoinVO waggle = (WaggleJoinVO)session.getAttribute("waggleVO");
		List<StockTodayVO> st = service.likecomapnylist(waggle);
	
		model.addAttribute("companylist",st);
		return "like/company";
	}
	
	/*포트폴리오 등록*/
	@ResponseBody
	@GetMapping("/like/port")
	public int myport(HttpSession session, Model model, @RequestParam(value="no") int no,PortfolioVO pf) {
		WaggleJoinVO waggle =(WaggleJoinVO)session.getAttribute("waggleVO");
		//나의번호

		WaggleJoinVO waggle2 = wservice.selectaccount(no);
		//상대의 번호
		//포티폴리오 저장횟수 증가시키기
		service.increport(waggle2);
		List<StockWeightVO> valuelist = wservice.wagglerankInfo(waggle2);
		
		for(StockWeightVO a:valuelist) {
			pf.setMe(waggle.getNo());
			pf.setNo(no);
			pf.setStock_type(a.getStock_type());
			pf.setPercent(a.getValuerate());
			service.likeport(pf);
		}
		WaggleJoinVO waggle3 = wservice.selectaccount(no);
		return waggle3.getHit();
	}

	/* 포트폴리오로 추천종목뽑기 */
	
	@PostMapping("port/recom")
	public String portrecom(@RequestParam(value="day",required=false) String day,Model model,
			@RequestParam(value="nickname") String nickname, PortfolioVO pf, HttpSession session) {
		WaggleJoinVO waggle = (WaggleJoinVO)session.getAttribute("waggleVO");
	
		StockBuySellVO bs = new StockBuySellVO();
		bs.setMember_account(waggle.getMember_account());
		double balance =aservice.maxbuy(bs);
		model.addAttribute("balance",(int)balance);
		model.addAttribute("nickname",waggle.getNickname());
		
		pf.setMe(waggle.getNo());
		pf.setNickname(nickname);
		Map<String,Map<String,Object>> portmap = new HashMap<String, Map<String,Object>>();	
		
		if(day ==null) {
			Date time = new Date();
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			String time1 = format1.format(time);
			pf.setRegdate(time1);
		}
		else {
			pf.setRegdate(day);
		}
		
		//내가 선택한 포트폴리오
		List<PortfolioVO> list = service.selectport2(pf);
		PortfolioVO pf2 = new PortfolioVO();
		
		int rbalance=0;
		for(PortfolioVO a :list) {
			Map<String,Object> port =new HashMap<String,Object>();
		
			int tbalance = (int)(balance* a.getPercent());
			
			pf2.setStock_type(a.getStock_type());
			List<StockTodayVO> na =service.recc(pf2);	
			
			for(StockTodayVO k: na) {
				if(tbalance> k.getStock_close()) {
					int stocknum =tbalance/k.getStock_close();
					tbalance =tbalance-(stocknum*k.getStock_close());
					port.put(k.getStock_name(), stocknum);
				}
				else {
					
					continue;
				}
				
			}
			portmap.put(a.getStock_type(), port);
		}
		
		model.addAttribute("port2",portmap);
		System.out.println(portmap);
		return "/like/port3";
	}

	
	
	
	/* 날짜별 저장한 포트폴리오보기 */
	@PostMapping("/like/port/select")
	public String selectport2(HttpSession session,PortfolioVO pf, @RequestParam(value="day",required=false) String day, Model model) {
		WaggleJoinVO waggle = (WaggleJoinVO)session.getAttribute("waggleVO");
		pf.setMe(waggle.getNo());	
		pf.setRegdate(day);
		
		Map<String,Map<String,Object>> portmap = new HashMap<String, Map<String,Object>>();		
		List<PortfolioVO> list = service.selectport(pf);	
		List<PortfolioVO> list2 = service.selectportname(pf);
		
		String nickname="" ;
		String stock_type="";
		double percent=0;
		
	
		for(PortfolioVO b: list2) {
			Map<String,Object> port =new HashMap<String,Object>();
			nickname= b.getNickname();
				
			for(PortfolioVO a: list) {
					if(a.getNickname().equals(nickname)) {
						stock_type =a.getStock_type();
						percent = a.getPercent();
						port.put(stock_type,percent);
										
				}				
				portmap.put(nickname,port);	
			}		
		}	
		model.addAttribute("port",portmap);
		
		return "/like/port2";
	}
	
	
	
	@GetMapping("/like/port/select")
	public String selectport(HttpSession session,PortfolioVO pf, Model model) {
		WaggleJoinVO waggle = (WaggleJoinVO)session.getAttribute("waggleVO");
		pf.setMe(waggle.getNo());
		
	
		Date time = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String time1 = format1.format(time);
		pf.setRegdate(time1);
		
		Map<String,Map<String,Object>> portmap = new HashMap<String, Map<String,Object>>();	
		
	
		List<PortfolioVO> list = service.selectport(pf);		
		List<PortfolioVO> list2 = service.selectportname(pf);
		
		String nickname="" ;
		String stock_type="";
		double percent=0;
		
	
		for(PortfolioVO b: list2) {
			Map<String,Object> port =new HashMap<String,Object>();
			nickname= b.getNickname();

			for(PortfolioVO a: list) {
					if(a.getNickname().equals(nickname)) {
						stock_type =a.getStock_type();
						percent = a.getPercent();
						port.put(stock_type,percent);
															
				}				
				portmap.put(nickname,port);					
			}		
		}				
		model.addAttribute("port",portmap);
		return "/like/port";
	}
	
	
	/* 관심유저 */
	@GetMapping("/like/follow")
	public String myfollow(HttpSession session,Model model) {
		System.out.println("관심유저");
		return "like/follow";
	}
	
	/* 관심유저등록 */
	@ResponseBody
	@GetMapping("/like/follow/{no}")
	public int insertfollow(HttpSession session,@PathVariable("no") int no, FollowVO fl) {
	
		WaggleJoinVO waggle =(WaggleJoinVO)session.getAttribute("waggleVO");
		fl.setMe(waggle.getNickname());
		
		WaggleJoinVO waggle2 = wservice.selectaccount(no);
		fl.setLikeman(waggle2.getNickname());
		
		service.insertlikeman(fl);
		FollowVO f2 = new FollowVO();
		f2.setLikeman(waggle2.getNickname());
		List<FollowVO> list = service.selectfollow(f2);
		
		return list.size();
	}


	/* 관심유저등록 취소 */
	@ResponseBody
	@GetMapping("/like/followback/{no}")
	public int deletefollow(HttpSession session,@PathVariable("no") int no, FollowVO fl) {
	
		WaggleJoinVO waggle =(WaggleJoinVO)session.getAttribute("waggleVO");
		fl.setMe(waggle.getNickname());
		
		WaggleJoinVO waggle2 = wservice.selectaccount(no);
		fl.setLikeman(waggle2.getNickname());
		
		service.deletelikeman(fl);
		FollowVO f2 = new FollowVO();
		f2.setLikeman(waggle2.getNickname());
		List<FollowVO> list = service.selectfollow(f2);
		
		return list.size();
	}
	
	
	
	
	/* 기업관심등록 */
	@ResponseBody
	@GetMapping("/like/{code}")
	public void insertlike(HttpSession session, @PathVariable("code") String code,LikeCompanyVO lc) {
		WaggleJoinVO waggle = (WaggleJoinVO)session.getAttribute("waggleVO");
		lc.setNo(waggle.getNo());
		lc.setStock_code(code);
		service.insertlike(lc);
		
	}
	
	/* 관심등록취소 */
	@ResponseBody
	@GetMapping("/unlike/{code}")
	public void unlike(HttpSession session, @PathVariable("code") String code,LikeCompanyVO lc) {
		WaggleJoinVO waggle = (WaggleJoinVO)session.getAttribute("waggleVO");
		lc.setNo(waggle.getNo());
		lc.setStock_code(code);
		service.unlike(lc);
	}
}
