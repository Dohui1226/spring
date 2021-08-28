package kr.ac.kopo.stock;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class StockController {
	
	@GetMapping("/mystock")
	public String mystock() {
		System.out.println("내자산");
		return "stock/mystock";
	}
	
	

	@GetMapping("/stocklist")
	public String stocklist() {
		System.out.println("종목조회");
		return "stock/stocklist";
	}

}
