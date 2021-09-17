package kr.ac.kopo;

import java.util.Arrays;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.stock.dao.StockDAO;
import kr.ac.kopo.vo.MyStockVO;
import kr.ac.kopo.vo.StockCodeVO;
import kr.ac.kopo.vo.StockTodayVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:config/spring/spring-mvc.xml"})
public class ValueCrawler{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	private StockDAO mapper;
	
	@Ignore
	@Test
	public void insertvalue() throws Exception{
	

	String[] aa = mapper.selectcode();
	for(int i=0; i<aa.length;i++) {
		
	//System.out.println(Arrays.toString(aa));
	
	
	String code1="A";
	String code2=aa[i];
	String code=code1+code2;//회사코드
	double roe; //최종roe
	double roe1 = 0 ; //3년전 roe
	double roe2=0; //2년전 roe
	double roe3=0; //최근 roe
	double equity=0; //자기자본
	double rate1=0; //회사채이율
	double stock=0; //유통주식수
	int stock3=0;
	
	String URL1="https://www.kisrating.com/ratingsStatistics/statics_spread.do";
	Document doc1=null;
	
	String URL2="http://comp.fnguide.com/SVO2/ASP/SVD_Main.asp?pGB=1&gicode="+code+
			"&cID=&MenuYn=Y&ReportGB=&NewMenuID=101&stkGb=701";
	Document doc2=null;
	
	String URL3="https://asp01.fnguide.com/SVO2/asp/SVD_Main.asp?pGB=1&gicode="
			+ code+"&cID=&MenuYn=Y&ReportGB=&NewMenuID=101&stkGb=701";
	Document doc3=null;
	Document doc4=null;

	//회사채 크롤링
	try {
		doc1 = Jsoup.connect(URL1).get();
		
		Elements eles = doc1.select("#con_tab1 > div.table_ty1 > table > tbody > tr:nth-child(11) > td:nth-child(9)");
		
		String[] rate = eles.text().split(" ");
		rate1 =Double.parseDouble(rate[0].replaceAll("\\.", ""))/10000;
			
		
		doc2 = Jsoup.connect(URL2).get();			
		Elements eles1 = doc2.select(".us_table_ty1 > tbody> tr:nth-child(7)> td.r"); 
		String[] issue = eles1.text().split("/ ");
		
		
		int stock1 =Integer.parseInt(issue[0].replaceAll(",", ""));			
	
		Elements eles2 = doc2.select(".us_table_ty1 > tbody>tr:nth-child(5)>td.r");
		String[] myissue=eles2.text().split(" ");
		
		try{
			stock3 =Integer.parseInt(myissue[9].replaceAll(",", ""));
		}
		catch(Exception e){
			stock3=0;
		}
		stock = stock1-stock3;		
	
		doc3 = Jsoup.connect(URL3).get();
		Elements eles3 = doc3.select("#highlight_D_Y > table > tbody > tr:nth-child(10) > td:nth-child(6)");
		
	
		equity =Double.parseDouble(eles3.text().replaceAll(",",""))*100000000;

		doc4 = Jsoup.connect(URL3).get();
		Elements eles4 =doc4.select("#highlight_D_Y > table > tbody > tr:nth-child(18) > td.r");
		String [] roearr = eles4.text().split(" ");
		
		roe1 =Double.parseDouble(roearr[2].replaceAll("\\.", ""))/100;
		roe2 =Double.parseDouble(roearr[3].replaceAll("\\.", ""))/100;
		roe3 =Double.parseDouble(roearr[4].replaceAll("\\.", ""))/100;
		
	}
		
	catch(Exception e) {
		e.printStackTrace();
	}
	
	if (roe1<roe2 && roe2<roe3)
		roe=roe3/100;
	else if(roe1>roe2 && roe2>roe3)	{
		roe=roe3/100;
	}
	else {
		roe =(roe1+(roe2*2)+(roe3*3))/6/100;		
	}

	double totalvalue = (equity +(equity*(roe-rate1))/rate1);

	int value = (int) (totalvalue/stock);
	System.out.println("적정가격: "+value);
	StockCodeVO stc = new StockCodeVO();	
		
	stc.setValue(value);
	stc.setStock_code(code2);
	
	System.out.println(stc);
	
	Thread.sleep(5000); 
	
	//sqlSessionTemplate.insert("stock.StockDAO.insertvalue",stc);
	}
	}
	@Test
	public void inserclose() throws Exception{
		
		

	String[] aa = mapper.selectcode();
	for(int i=0; i<aa.length;i++) {
		
		String code=aa[i];
		String URL3="https://finance.naver.com/item/frgn.nhn?code="+code+"&page=2";
		Document doc3;
	
		int close=0;
		int diff=0;
		String stockname=null;
		String closedate = null;
		
		
		try {
		
			doc3 = Jsoup.connect(URL3).get();
			Elements eles3 = doc3.select("#content > div.section.inner_sub > table.type2 > tbody > tr:nth-child(4) > td:nth-child(2) > span");
			
		
			try{
				
				close = Integer.parseInt(eles3.text().replaceAll(",",""));
			}catch(Exception e) {
				close=Integer.parseInt(eles3.text());
			}
			
			System.out.println(close);//종가
			
			//전일비 
			Elements eles4 = doc3.select("#content > div.section.inner_sub > table.type2 > tbody > tr:nth-child(4) > td:nth-child(3) > span");
		
			
			try{
				
				diff= Integer.parseInt(eles4.text().replaceAll(",",""));
			}catch(Exception e) {
				diff=Integer.parseInt(eles4.text());
			}
			
	
			//증감할 전일비
			
			Elements eles5 = doc3.select("#content > div.section.inner_sub > table.type2 > tbody > tr:nth-child(4) > td:nth-child(4) > span");

			String alpha = Character.toString(eles5.text().charAt(0));
			if(alpha.equals("-")) {
				diff=-diff;
			}
			System.out.println(diff);
			//종목명
			Elements eles6 = doc3.select("#middle > div.h_company > div.wrap_company > h2 > a");
		
			stockname=eles6.text();
			System.out.println(stockname);
			
			//날짜
			Elements eles7 = doc3.select("#content > div.section.inner_sub > table.type2 > tbody > tr:nth-child(4) > td.tc > span");
			closedate = eles7.text();
			System.out.println(closedate);
		}
			
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		Thread.sleep(5000); 
		StockTodayVO st =new StockTodayVO();
		st.setClose_date(closedate);
		st.setStock_code(aa[i]);
		st.setStock_close(close);
		st.setStock_diff(diff);
		st.setStock_name(stockname);
	
		
		//sqlSessionTemplate.insert("stock.StockDAO.insertclose,st);
		}
		
	}
}

