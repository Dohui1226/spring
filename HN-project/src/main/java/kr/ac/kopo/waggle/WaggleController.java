package kr.ac.kopo.waggle;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.account.service.AccountService;
import kr.ac.kopo.vo.AccountVO;
import kr.ac.kopo.vo.AddHeartVO;
import kr.ac.kopo.vo.CouponVO;
import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.MyStockVO;
import kr.ac.kopo.vo.RankListVO;
import kr.ac.kopo.vo.StockWeightVO;
import kr.ac.kopo.vo.WaggleJoinVO;
import kr.ac.kopo.waggle.servie.WaggleService;

@SessionAttributes({"waggleVO"})
@Controller
public class WaggleController {
	@Autowired
	private WaggleService service;
	
	@Autowired
	private AccountService accountservice;
	
	/* 와글와글메인 */
	@GetMapping("/waggle")
	public String wagglemain() {
		System.out.println("와글메인");
		return "waggle/wagglemain";
	}
	
	
	/* 와글와글 쿠폰메인 */
	@GetMapping("/waggle/changecoupon")
	public String wagglecoupon(HttpSession session, Model model) {
		WaggleJoinVO waggleVO = (WaggleJoinVO) session.getAttribute("waggleVO");
	
		
		model.addAttribute("myheart",waggleVO.getHart());
		return "waggle/changecoupon";
	}
	
	/* 와글와글 가입화면 */
	@GetMapping("/waggle/join")
	public String wagglejoin(HttpSession session, Model model) {
		MemberVO userVO = (MemberVO)session.getAttribute("userVO");
		
		List<AccountVO> list = accountservice.myaccount(userVO);
		model.addAttribute("accountlist", list);
		return "waggle/join";
	}
	
	
	/* 와글와글 일회성 하트 충전 */
	@PostMapping("/waggle/addheart")
	public String addheart(HttpSession session,AddHeartVO heartvo) {

		WaggleJoinVO waggleVO = (WaggleJoinVO)session.getAttribute("waggleVO");
		
		heartvo.setAnum(waggleVO.getMember_account());
		heartvo.setNo(waggleVO.getNo());
	
		service.addHeart(heartvo);
		 
		return "waggle/comcoupon";
	}
	
	/* 와글와글 가입 데이터 넘기기 */
	@PostMapping("/waggle/join")
	public String wirte(@Valid WaggleJoinVO waggle, HttpSession session) {
		//아이디		
		MemberVO userVO = (MemberVO)session.getAttribute("userVO");//로그인정보가져오기

		waggle.setMember_id(userVO.getMember_id());
		service.join(waggle);//와글 가입
		
		if(service.joincheck(userVO)){//와글 가입이 되었다면		
			session.setAttribute("waggleVO", waggle); //와글정보 세션 등록
		}
		return "redirect:/waggle";
	}
	

	/* 와글와글 랭킹 개인정보 */
	
	@GetMapping("/waggle/rankInfo/{no}")
	public String wagglerankInfo(@PathVariable("no") int no, Model model) {
		WaggleJoinVO waggle = service.selectaccount(no);
		List<StockWeightVO> value = service.wagglerankInfo(waggle);
	
		for(StockWeightVO st :value) {
			System.out.println(st);
		};
		model.addAttribute("waggle", waggle);
		model.addAttribute("value", value);
		
		return "waggle/rankInfo";
	}

	/* 주식비중구하기 */
	@ResponseBody
	@PostMapping("/waggle/rankInfo/piechart")
	public Map<String, Object> piechart(@RequestParam(value="no") int no){
	
		WaggleJoinVO waggle = service.selectaccount(no);
		
		List<StockWeightVO> valuelist = service.wagglerankInfo(waggle);
	
	
		Map<String, Object> map = new HashMap<String, Object>();		
		map.put("valuelist",valuelist);
		return map;
		
	}
	
	/* 계좌번호로 수익률 매일 조회하기 */
	@ResponseBody
	@PostMapping("/waggle/rankInfo/linechart")
	public Map<String, Object> linechart(@RequestParam(value="no") int no){
		WaggleJoinVO waggle = service.selectaccount(no);
		
		List<StockWeightVO> ratelist = service.wagglerankInfo(waggle);
		Map<String, Object> map = new HashMap<String, Object>();		
		
		map.put("ratelist",ratelist);
		return map;
		
	}
	
	
	
	/* 와글와글 랭킹 순위 */
	@GetMapping("waggle/ranking")
	public String waggleranking(Model model) {
		System.out.println("와글와글 랭킹페이지");
		List<RankListVO> list = service.wagglerank();
		model.addAttribute("ranklist", list);
		return "waggle/ranking";
	}
	
	
	/* 쿠폰사기 */
	@PostMapping("/waggle/change")
	public String change(HttpSession session,CouponVO couponvo) {

		WaggleJoinVO waggleVO = (WaggleJoinVO)session.getAttribute("waggleVO");
		couponvo.setNo(waggleVO.getNo());
	
		service.change(couponvo);		 
		return "waggle/comcoupon";
	}
	
	/*쿠폰조회하기*/
	@GetMapping("/waggle/listcoupon")
	public String couponlist(Model modal,CouponVO couponvo, HttpSession session) {
		WaggleJoinVO waggleVO = (WaggleJoinVO) session.getAttribute("waggleVO");

		List<CouponVO> couponlist = service.selectcoupon(waggleVO.getNo());
		
		modal.addAttribute("mycoupon", couponlist);
	return "waggle/listcoupon";
	}
	
	
	/*쿠폰선물하기*/
	@GetMapping("/waggle/giftcoupon")
	public String giftcoupon() {
		System.out.println("쿠폰선물");
		return "waggle/giftcoupon";
	}
}
