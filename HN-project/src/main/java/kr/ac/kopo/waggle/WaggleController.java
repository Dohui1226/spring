package kr.ac.kopo.waggle;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.ac.kopo.account.service.AccountService;
import kr.ac.kopo.vo.AccountVO;
import kr.ac.kopo.vo.AddHeartVO;
import kr.ac.kopo.vo.CouponVO;
import kr.ac.kopo.vo.MemberVO;
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
		 
		return "waggle/changecoupon";
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
	@GetMapping("/waggle/rankInfo")
	public String wagglerankInfo() {
		System.out.println("와글와글개인 랭킹정보");
		return "waggle/rankInfo";
	}
	
	
	/* 쿠폰교환하기 */
	@PostMapping("/waggle/change")
	public String change(HttpSession session,CouponVO couponvo) {

		WaggleJoinVO waggleVO = (WaggleJoinVO)session.getAttribute("waggleVO");
		couponvo.setNo(waggleVO.getNo());
	
		service.change(couponvo);		 
		return "waggle/changecoupon";
	}
	
	/*쿠폰조회하기*/
	@GetMapping("/waggle/couponlist")
	public String couponlist(Model modal, HttpSession session) {
		WaggleJoinVO waggleVO = (WaggleJoinVO) session.getAttribute("waggleVO");
	
		List<CouponVO> couponlist = service.selectcoupon(waggleVO.getNo());
		System.out.println("완료");
		modal.addAttribute("mycoupon", couponlist);
	return "waggle/couponlist";
	}
	
	
	
}
