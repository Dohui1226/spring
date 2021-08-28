package kr.ac.kopo.waggle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainWaggle {
	
	@GetMapping("/waggle")
	public String wagglemain() {
		System.out.println("와글와글");
		return "waggle/wagglemain";
	}
	
	@GetMapping("/waggle/coupon")
	public String wagglecoupon() {
		System.out.println("쿠폰");
		return "waggle/coupon";
	}
}
