package kr.ac.kopo.member.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;

//이 어노테이션은 모델이나 공유영역에 객체를 올린것중에 userVO 이름을 가지고 있는것은 세션영역에올려 로그아웃이안돼..-
//> invalidate대신 SessionStatus
@SessionAttributes({"userVO"})
@Controller
public class MemberController {
	@Autowired
	private MemberService service;
	
	@GetMapping("/login")
	public String loginForm() {
		return "login/login";
	}
	
	@PostMapping("/login")
	public String login(MemberVO member, Model model, HttpSession session) {
		MemberVO userVO = service.login(member);
		
		
		if(userVO ==null) {//로그인 실패
			String msg="아이디 또는 패스워드가 잘못되었습니다.";
			model.addAttribute("msg",msg); //공유영역에 등록
			return "login/login";
		}
		//로그인 성공
		model.addAttribute("userVO", userVO);//이렇게 하면 request. 영역에 공유됨..
		//로그인인터셉터를 거쳤는지 확인
				String dest = (String)session.getAttribute("dest");
				if(dest != null) {//거쳤음!
					
					session.removeAttribute(dest);
					return "redirect:" + dest;
				}
		
		
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		System.out.println(status.isComplete());//false이면 세션이 끊기지 않음
		
		status.setComplete(); //세션 끝내줘
		
		System.out.println(status.isComplete());//트루이면 세션이 끊김
		return "redirect:/";
	}
	
	
	
	
}
