package kr.ac.kopo.stock;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.stock.service.StockService;
import kr.ac.kopo.vo.StockBuySellVO;
import kr.ac.kopo.vo.StockCodeVO;
import kr.ac.kopo.vo.StockTodayVO;
import kr.ac.kopo.vo.WaggleJoinVO;
@Controller
public class StockController {
	

	@Autowired
	private StockService stockservice;
	
	
	/* 모든종목조회 */
	@GetMapping("/stocklist")
	public String stocklist(Model model) {
		System.out.println("종목조회");
		
		List<StockTodayVO> list = stockservice.stocktoday();
	
		
		model.addAttribute("stocklist", list);
		return "stock/stocklist";
	}
	
	/* 매수매도페이지 */
	@GetMapping("/stock/buysell/{code}")
	public ModelAndView buysell(@PathVariable("code") String code, StockCodeVO stockcode, StockTodayVO stocktoday) {
		stockcode.setStock_code(code);
		stocktoday.setStock_code(code);
		System.out.println(code);
		stockcode = stockservice.companyinfo(stockcode);
		stocktoday = stockservice.stockonetoday(stocktoday);
		ModelAndView mav = new ModelAndView("stock/buysell");
		System.out.println(stockcode);
		System.out.println(stocktoday);
		
		mav.addObject("stockcode", stockcode);
		mav.addObject("stocktoday", stocktoday);
		return mav;
	}
	
	/*메수하기*/
	@PostMapping("/stock/buy/{code}")
	public ModelAndView stockbuy(@PathVariable("code") String code,HttpSession session, StockBuySellVO buysell) {
		WaggleJoinVO waggle = (WaggleJoinVO) session.getAttribute("waggleVO");
		buysell.setMember_account(waggle.getMember_account());
		buysell.setStock_code(code);
		
		
		stockservice.stockbuy(buysell);
		ModelAndView mav = new ModelAndView("stock/buysell");
	

		return mav;
	}
	
	/* 매도하기 */
	@PostMapping("/stock/sell/{code}")
	public ModelAndView stocksell(@PathVariable("code") String code,HttpSession session, StockBuySellVO buysell) {
		System.out.println("매도");
		WaggleJoinVO waggle = (WaggleJoinVO) session.getAttribute("waggleVO");
		buysell.setMember_account(waggle.getMember_account());
		buysell.setStock_code(code);
		
		System.out.println(buysell);
		stockservice.stocksell(buysell);
		ModelAndView mav = new ModelAndView("stock/buysell");
		System.out.println("매도2");
		

		return mav;
	}
	
	
	
	
	
	
	/* 기업보고서 */

	@GetMapping("/stock/report/{code}")
	public String report(@PathVariable("code") String code) {
		System.out.println("리포트");
	
		return "stock/report/"+code;
	}

}
