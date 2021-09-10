package kr.ac.kopo.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.account.dao.AccountDAO;
import kr.ac.kopo.vo.AccountDailyVO;
import kr.ac.kopo.vo.AccountVO;
import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.MyStockVO;
import kr.ac.kopo.vo.StockBuySellVO;
import kr.ac.kopo.vo.WaggleJoinVO;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDAO dao;
	
	/* 내 계좌 조회하기 */
	public List<AccountVO> myaccount(MemberVO member) {
		List<AccountVO> list= dao.myaccount(member);
		return list;
	}
	
	
	public AccountDailyVO dailyaccount(WaggleJoinVO waggle) {
		AccountDailyVO adailyvo = dao.dailyaccount(waggle);
		return adailyvo;
	}
	
	public List<MyStockVO> mystocklist(WaggleJoinVO waggle) {
		List<MyStockVO> list = dao.mystocklist(waggle);
		return list;
	}
	
	public int maxbuy(StockBuySellVO buysell) {
		int balance = dao.maxbuy(buysell);
		return balance;
	}
	
	public int maxsell(StockBuySellVO buysell) {
		System.out.println("서비스1");
		int stocknum = dao.maxsell(buysell);
		System.out.println("서비스2");
		return stocknum;
	}

}
