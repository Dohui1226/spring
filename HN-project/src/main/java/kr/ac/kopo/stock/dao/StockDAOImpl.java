package kr.ac.kopo.stock.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.vo.StockBuySellVO;
import kr.ac.kopo.vo.StockCodeVO;
import kr.ac.kopo.vo.StockTodayVO;


@Repository
public class StockDAOImpl implements StockDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	public List<StockTodayVO> stocktoday() {
		List<StockTodayVO> list = sqlSessionTemplate.selectList("stock.StockDAO.stocktoday");
		return list;
	}
	public StockCodeVO companyinfo(StockCodeVO stockcode) {
			stockcode = sqlSessionTemplate.selectOne("stock.StockDAO.companyinfo",stockcode);
			
			return stockcode;
		}
	
	
	public StockTodayVO stockonetoday(StockTodayVO stocktoday) {
		stocktoday = sqlSessionTemplate.selectOne("stock.StockDAO.stockonetoday",stocktoday);
		return stocktoday;
	}
	
	public void stockbuy(StockBuySellVO buysell) {
		sqlSessionTemplate.selectOne("stock.StockDAO.stockbuy",buysell);
		
	}
	
	public void stocksell(StockBuySellVO buysell) {
		sqlSessionTemplate.selectOne("stock.StockDAO.stocksell",buysell);
		System.out.println("dao");
	}
}
