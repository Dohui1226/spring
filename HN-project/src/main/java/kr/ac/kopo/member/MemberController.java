package kr.ac.kopo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MemberController {
	
	
	@GetMapping("/login")
	public String loginForm() {
		System.out.println("로그인");
		return "login/login";
	}

}
