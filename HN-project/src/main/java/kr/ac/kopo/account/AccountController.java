package kr.ac.kopo.account;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.account.service.AccountService;
import kr.ac.kopo.vo.AccountDailyVO;
import kr.ac.kopo.vo.MyStockVO;
import kr.ac.kopo.vo.StockBuySellVO;
import kr.ac.kopo.vo.WaggleJoinVO;
@Controller
public class AccountController {
	
	@Autowired
	private AccountService service;
	
	/* 내자산조회 */
	@GetMapping("/myasset")
	public String myasset(HttpSession session, Model model) {
		System.out.println("내자산");
		WaggleJoinVO waggle = (WaggleJoinVO)session.getAttribute("waggleVO");
		
		AccountDailyVO adailyVO = service.dailyaccount(waggle);
		List<MyStockVO> mystocklist = service.mystocklist(waggle);
	
		model.addAttribute("adaily",adailyVO);
		model.addAttribute("stocklist",mystocklist);
		for(MyStockVO list: mystocklist) {
			System.out.println(list);
		}
		return "account/myasset";
	}
	
	/* 보유종목 수량조회 */
	@ResponseBody
	@PostMapping("/myasset/mystock")
	public int maxsell (@RequestParam(value="stock_code") String stock_code,StockBuySellVO buysell, HttpSession session) {
		System.out.println("종목수량조회");
		
		WaggleJoinVO waggle = (WaggleJoinVO) session.getAttribute("waggleVO");
		buysell.setMember_account(waggle.getMember_account());
		System.out.println("code"+stock_code);
		buysell.setStock_code(stock_code);
		
		System.out.println(buysell);	
		int stocknum = service.maxsell(buysell);
		System.out.println(stocknum);
		return stocknum;
	}
	
	
	/*잔액조회*/
	@ResponseBody
	@PostMapping("/myasset/stock/cash")
		public int maxbuy(StockBuySellVO buysell,Model model, HttpSession session) {
			System.out.println("잔액조회");
			WaggleJoinVO waggle = (WaggleJoinVO) session.getAttribute("waggleVO");
			buysell.setMember_account(waggle.getMember_account());
		
			int balance = service.maxbuy(buysell);
		
			return balance;
		}
		
		
		
	}


