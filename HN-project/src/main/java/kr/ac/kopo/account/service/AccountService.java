package kr.ac.kopo.account.service;

import java.util.List;

import kr.ac.kopo.vo.AccountDailyVO;
import kr.ac.kopo.vo.AccountVO;
import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.MyStockVO;
import kr.ac.kopo.vo.StockBuySellVO;
import kr.ac.kopo.vo.WaggleJoinVO;


public interface AccountService {
	

	List<AccountVO> myaccount(MemberVO member); //내계좌 조회하기

	AccountDailyVO dailyaccount(WaggleJoinVO waggle);//현금 주식 비중 가져오기

	List<MyStockVO> mystocklist(WaggleJoinVO waggle);// 보유 종목리스트

	int maxsell(StockBuySellVO buysell); //최대 몇개 살수 있는지

	int maxbuy(StockBuySellVO buysell);//최대 몇개 매도할 수 있는지

}
