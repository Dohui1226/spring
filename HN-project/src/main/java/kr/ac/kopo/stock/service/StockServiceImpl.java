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
	
	public void stockbuy(StockBuySellVO buysell) {
		System.out.println("서비스");
		stockdao.stockbuy(buysell);
		}
			
	public void stocksell(StockBuySellVO buysell) {
		
		stockdao.stocksell(buysell);
		System.out.println("서비스!");
		}	

}
