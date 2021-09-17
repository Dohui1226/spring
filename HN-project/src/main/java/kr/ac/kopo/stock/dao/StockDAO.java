package kr.ac.kopo.stock.dao;

import java.util.List;

import kr.ac.kopo.vo.StockBuySellVO;
import kr.ac.kopo.vo.StockCodeVO;
import kr.ac.kopo.vo.StockTodayVO;

public interface StockDAO {
	
	
	public List<StockTodayVO> stocktoday(); //종목리스트

	public StockCodeVO companyinfo(StockCodeVO stockcode); //종목타입, 분류 가져오는 함수 

	public StockTodayVO stockonetoday(StockTodayVO stocktoday);

	public void stockbuy(StockBuySellVO buysell); //매수
	
	public void stocksell(StockBuySellVO buysell); //매도
	
	public String[] selectcode();

}
