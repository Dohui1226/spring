package kr.ac.kopo.favorite;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.account.service.AccountService;
import kr.ac.kopo.favorite.service.FavoriteService;
import kr.ac.kopo.vo.AccountDailyVO;
import kr.ac.kopo.vo.FollowVO;
import kr.ac.kopo.vo.LikeCompanyVO;
import kr.ac.kopo.vo.MyStockVO;
import kr.ac.kopo.vo.Portfolio2VO;
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
	
	/* 관심종목페이지 */
	@GetMapping("/like/company")
	public String myfavorite(HttpSession session, Model model) {
		WaggleJoinVO waggle = (WaggleJoinVO)session.getAttribute("waggleVO");
		List<StockTodayVO> st = service.likecomapnylist(waggle);
	for(StockTodayVO a: st) {
		System.out.println(a);
	}
		model.addAttribute("companylist",st);
		return "like/company";
	}
	
	/*포트폴리오 등록*/
	@GetMapping("/like/port")
	public void myport(HttpSession session, Model model, @RequestParam(value="no") int no,PortfolioVO pf) {
		WaggleJoinVO waggle =(WaggleJoinVO)session.getAttribute("waggleVO");
		

		WaggleJoinVO waggle2 = wservice.selectaccount(no);
		List<StockWeightVO> valuelist = wservice.wagglerankInfo(waggle2);
		
		for(StockWeightVO a:valuelist) {
			pf.setMe(waggle.getNo());
			pf.setNo(no);
			pf.setStock_type(a.getStock_type());
			pf.setPercent(a.getValuerate());
			service.likeport(pf);
		}
			
	}

	/* 포트폴리오로 추천종목뽑기 */
	@ResponseBody
	@PostMapping("port/recom")
	public String portrecom(@RequestParam(value="day") String day,  @RequestParam(value="nickname") String nikname, PortfolioVO pf, HttpSession session) {
		
		WaggleJoinVO waggle = (WaggleJoinVO)session.getAttribute("waggleVO");
		pf.setMe(waggle.getNo());
		
		SimpleDateFormat format1 = new SimpleDateFormat("yy/MM/dd");
		String time1 = format1.format(day);
		pf.setRegdate(day);
		

		List<PortfolioVO> list = service.selectport(pf);
		
	
		return "";
	}

	/* 한개 포트폴리오 선택하기 */
	@ResponseBody
	@PostMapping("port/recom")
	public String selectport2(HttpSession session,PortfolioVO pf, Model model, @RequestParam(value="day") String day, @RequestParam(value="nickname") String nikname) {
		WaggleJoinVO waggle = (WaggleJoinVO)session.getAttribute("waggleVO");
		pf.setMe(waggle.getNo());
		pf.setRegdate(day);
		pf.setNickname(nikname);
		
		
		
		
		
		
		
		
		
		
		return null;
	}
	
	
	/* 날짜별 저장한 포트폴리오보기 */	
	@PostMapping("/like/port/select")
	public String selectport2(HttpSession session,PortfolioVO pf, @RequestParam(value="day",required=false) String day, Model model) {
		WaggleJoinVO waggle = (WaggleJoinVO)session.getAttribute("waggleVO");
		pf.setMe(waggle.getNo());	
		pf.setRegdate(day);
		System.out.println("컨트롤러");
		Map<String,Map<String,Object>> portmap = new HashMap<String, Map<String,Object>>();		
		List<PortfolioVO> list = service.selectport(pf);	
		List<PortfolioVO> list2 = service.selectportname(pf);
		System.out.println("컨트롤러2");
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
						System.out.println(port);
										
				}				
				portmap.put(nickname,port);	
				
			}
		
		}
				
		//Map<String, Object> map = new HashMap<String, Object>();		
		//map.put("map",portmap);
		model.addAttribute("port",portmap);
		System.out.println("공유영역");
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
						System.out.println(port);
										
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
	public void insertfollow(HttpSession session,@PathVariable("no") int no, FollowVO fl) {
		System.out.println("관심유저등록");
		WaggleJoinVO waggle =(WaggleJoinVO)session.getAttribute("waggleVO");
		fl.setMe(waggle.getNickname());
		
		WaggleJoinVO waggle2 = wservice.selectaccount(no);
		fl.setLikeman(waggle2.getNickname());
		
		service.insertlikeman(fl);
		
	}

	/* 기업관심등록 */
	@ResponseBody
	@GetMapping("/like/{code}")
	public void insertlike(HttpSession session, @PathVariable("code") String code,LikeCompanyVO lc) {
		WaggleJoinVO waggle = (WaggleJoinVO)session.getAttribute("waggleVO");
		System.out.println(code);
		lc.setNo(waggle.getNo());
		lc.setStock_code(code);
		service.insertlike(lc);
		
		
	}
}
