package ex;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Crawler4 {
	
	public static void main(String[] args) {
		
	
	String URL3="https://finance.naver.com/item/frgn.nhn?code=272550&page=2";
	Document doc3;

	int close;
	int diff;
	
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
		System.out.println(eles6.text());
		
		//날짜
		Elements eles7 = doc3.select("#content > div.section.inner_sub > table.type2 > tbody > tr:nth-child(4) > td.tc > span");
		System.out.println(eles7.text());
	}
		
	catch(Exception e) {
		e.printStackTrace();
	}
	
	}

}
