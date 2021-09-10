package kr.ac.kopo.account.dao;

import java.util.List;

import kr.ac.kopo.vo.AccountDailyVO;
import kr.ac.kopo.vo.AccountVO;
import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.MyStockVO;
import kr.ac.kopo.vo.StockBuySellVO;
import kr.ac.kopo.vo.WaggleJoinVO;

public interface AccountDAO {

	 List<AccountVO> myaccount(MemberVO member);

	AccountDailyVO dailyaccount(WaggleJoinVO waggle); //계좌수익률 조회하기

	List<MyStockVO> mystocklist(WaggleJoinVO waggle);

	int maxbuy(StockBuySellVO buysell);

	int maxsell(StockBuySellVO buysell);
	
	

}
