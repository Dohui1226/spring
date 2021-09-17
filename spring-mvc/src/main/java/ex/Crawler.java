package ex;

import java.math.BigDecimal;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	
	//태그명 : 태그이름으로 접근 
	//select("div") : div 태그 모두 선택
	//.이름 : 태그의 속성 이름이 class인 것중에서 속성의 값이 #뒤의 값과 같은것
	//select("#a") : 태그의 id="a"인 모든 태그를 선택
	// a b : a태그의 자식 태그중에서 b태그를 모두 선택(a 태그의 자손 태그까지 모두)
	//a>b : a 태그의 자식 태그 중에서 b태그를 모두 선택(a 태그의 바로 밑에 있는 자식만)

	//현재가 -적정가격/ 적정가격
	//50000-10000/10000
	public static void main(String[] args) {
		String code1="A";
		String code2="267980";
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
		Document doc1;
		
		String URL2="http://comp.fnguide.com/SVO2/ASP/SVD_Main.asp?pGB=1&gicode="+code+
				"&cID=&MenuYn=Y&ReportGB=&NewMenuID=101&stkGb=701";
		Document doc2;
		
		String URL3="https://asp01.fnguide.com/SVO2/asp/SVD_Main.asp?pGB=1&gicode="
				+ code+"&cID=&MenuYn=Y&ReportGB=&NewMenuID=101&stkGb=701";
		Document doc3;
		Document doc4;
	
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
	
		double value = totalvalue/stock;
		System.out.println("적정가격: "+value);
			
			
			//추가적인 주가범위
			//초과이익이 연 10% 감소했을때
		//	double extraprofit = equity*(roe-rate1);//초과이익

			//초과이익이 지속되지 않고 연10% 감소하는 경우 W=0.9 기업 가ㅣ치
		//	double w1=0.9;
		//	double w2=0.8;
		//	double extravalue1 = equity+(extraprofit*w1)/(1+rate1-w1);
		//	double extravalue2 = equity+(extraprofit *w2)/(1+rate1-w2);
			
		//	System.out.println(extravalue1/stock+"적정가격");
		//	System.out.println(extravalue2/stock+"매수가격");
	
	}

}


