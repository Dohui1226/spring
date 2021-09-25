package kr.ac.kopo.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.stock.dao.StockDAO;
import kr.ac.kopo.vo.StockBuySellVO;
import kr.ac.kopo.vo.StockCodeVO;
import kr.ac.kopo.vo.StockTodayVO;

@Service
public class StockServiceImpl implements StockService {


	@Autowired
	private StockDAO stockdao;

	public List<StockTodayVO> stocktoday(){
		List<StockTodayVO> list = stockdao.stocktoday();
		return list;
	}
	
	public StockCodeVO companyinfo (StockCodeVO stockcode) {
		 stockcode = stockdao.companyinfo(stockcode);
		return stockcode;
	}
	
	public StockTodayVO stockonetoday(StockTodayVO stocktoday) {
		stocktoday = stockdao.stockonetoday(stocktoday);
		return stocktoday;
	}

	/* 매수 */
	public void stockbuy(StockBuySellVO buysell) {
		stockdao.stockbuy(buysell);
	}

	/* 매도 */		
	public void stocksell(StockBuySellVO buysell) {
		stockdao.stocksell(buysell);
	
	}
	
	public List<StockTodayVO> stockline(StockTodayVO st) {
		List<StockTodayVO> list =stockdao.stockline(st);
		return list;
	}
	
	public List<StockTodayVO> selectcodename() {
		List<StockTodayVO> list =stockdao.selectcodename();
		return list;
	}
	
	/* 랜덤주식 */
	public void randomstock(StockBuySellVO bs) {
		stockdao.randomstock(bs);
	}
}
