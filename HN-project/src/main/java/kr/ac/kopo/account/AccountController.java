package kr.ac.kopo.account;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.ac.kopo.account.service.AccountService;
import kr.ac.kopo.vo.AccountVO;
import kr.ac.kopo.vo.MemberVO;
@Controller
public class AccountController {
	
	@Autowired
	private AccountService service;
	
	@GetMapping("/myasset")
	public String myasset(HttpSession session, Model model) {
		System.out.println("내자산");		
		MemberVO userVO = (MemberVO)session.getAttribute("userVO");
		System.out.println(userVO);
		List<AccountVO> accountlist = service.myaccount(userVO);
		
		model.addAttribute("accountlist",model);
		
		return "account/myasset";
	}
	

}
