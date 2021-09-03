package kr.ac.kopo.stock;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class StockController {
	
	/* 종목조회 */
	@GetMapping("/stocklist")
	public String stocklist() {
		System.out.println("종목조회");
		return "stock/stocklist";
	}
	
	/* 매수매도 */
	@GetMapping("/stock/buysell")
	public String buysell() {
		System.out.println("매수매도");
		return "stock/buysell";
	}
	
	
	/* 기업보고서 */
	@GetMapping("/stock/report")
	public String report() {
		System.out.println("리포트");
		return "stock/report";
	}

}
