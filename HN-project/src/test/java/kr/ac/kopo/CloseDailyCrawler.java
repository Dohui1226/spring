package kr.ac.kopo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.stock.dao.StockDAO;
import kr.ac.kopo.vo.StockCodeVO;

public class CloseDailyCrawler {
	
	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(locations= {"classpath:config/spring/spring-mvc.xml"})
	public class ValueCrawler{

		@Autowired
		private SqlSessionTemplate sqlSessionTemplate;
		
		@Autowired
		private StockDAO mapper;
		
		@Test
		public void inserclose() throws Exception{
			System.out.println(11);
			String[] aa = mapper.selectcode();
			for(int i=0; i<aa.length;i++) {
			
			String closedate="";
		
			String code1="A";
			String code2=aa[i];
			String code=code1+code2;
			String URL = "https://asp01.fnguide.com/SVO2/asp/SVD_Main.asp?pGB=1&gicode="
					+ code+"&cID=&MenuYn=Y&ReportGB=&NewMenuID=101&stkGb=701";
			String URL2="https://finance.naver.com/item/sise.nhn?code="+code2;
			Document doc;
			Document doc2;
			int diff=0;
			try {
				doc = Jsoup.connect(URL).get();
				Elements elem = doc.select("#svdMainGrid1 > table > tbody > tr.rwf > td:nth-child(2)");
				String[] str = elem.text().split("/ ");

				
				int close =Integer.parseInt(str[0].replaceAll(",", ""));	
				
				try {
					diff =Integer.parseInt(str[1].replaceAll("\\+", ""));	
				}
				catch(Exception e){
					diff =Integer.parseInt(str[1]);
				}
				
				
				System.out.println(close);//종가
				System.out.println(diff);//전일비
				
				doc2 = Jsoup.connect(URL2).get();
				Elements elem2 = doc2.select("#time > em");
			
				String[] date = elem2.text().split(" ");
				System.out.println(date[0]);
				
			}
				
			catch(Exception e) {
				e.printStackTrace();
			}
			
			Thread.sleep(5000); 
		
		
		//sqlSessionTemplate.insert("stock.StockDAO.inserclose");
			}
		}	
	}
	
}
