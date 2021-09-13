package ex;

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

	
	public static void main(String[] args) {
		String code1="A";
		String code2="083450";
		String code=code1+code2;
		
		String URL1="https://www.kisrating.com/ratingsStatistics/statics_spread.do";
		Document doc1;
		
		//회사채 크롤링
		try {
			doc1 = Jsoup.connect(URL1).get();
			
			Elements eles = doc1.select("#con_tab1 > div.table_ty1 > table > tbody > tr:nth-child(11) > td:nth-child(9)");
			
			String[] rate = eles.text().split(" ");
			System.out.println("회사채 수익률:"+rate[0]);
			
			
			}
			
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		//위닉스 보통주, 우선주, 자기주식수
		String URL2="http://comp.fnguide.com/SVO2/ASP/SVD_Main.asp?pGB=1&gicode="+code+
				"&cID=&MenuYn=Y&ReportGB=&NewMenuID=101&stkGb=701";
		Document doc2;
		
		
		try {
			doc2 = Jsoup.connect(URL2).get();
			
			Elements eles1 = doc2.select(".us_table_ty1 > tbody> tr:nth-child(7)> td.r"); //보통주+우선주
			String[] issue = eles1.text().split("/ ");
		
			
				
			
			int stock1 =Integer.parseInt(issue[0].replaceAll(",", ""));			
			System.out.println("발행주식수:"+stock1);
			
			
			
			Elements eles2 = doc2.select(".us_table_ty1 > tbody>tr:nth-child(5)>td.r");
			String[] myissue=eles2.text().split(" ");
		
			int stock3 =Integer.parseInt(myissue[9].replaceAll(",", ""));
			System.out.println("자기주식수:"+stock3);
			
			int stock = stock1-stock3;		
			System.out.println("유통주식수"+stock);
			
			}
			
		catch(Exception e) {
			e.printStackTrace();
		}
	
		
		
		
		String URL3="https://finance.naver.com/item/coinfo.nhn?code="+code;
		Document doc3;  

		try {
			doc3 = Jsoup.connect(URL3).get();
		
			Elements eles3 = doc3.select(".gHead01>tbody>tr:nth-child(11)>td.num"); 
			
			
			System.out.println(eles3);
			String[] issue3 = eles3.text().split(" ");
			System.out.println(eles3.text());
		
			//(issue3[0].replaceAll(",", ""));
			System.out.println(issue3[0]);
			//System.out.println("발행주식수:"+equti);
		
			
			
		//	String[] issue1 =issue[1].split(" ");
		//	System.out.println(issue1[0]);
			/*
			 * if (!issue[1].equals("0")) { int
			 * stock2=Integer.parseInt(issue[1].replaceAll(",", ""));
			 * System.out.println("우선주:"+stock2); }
			 */
		
			
			
	
			}
			
		catch(Exception e) {
			e.printStackTrace();
		}
		

				
	}
}

