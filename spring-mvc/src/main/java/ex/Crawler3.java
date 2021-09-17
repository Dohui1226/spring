package ex;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

class Crawler3 {
	
	public static void getClose() throws Exception{
		String code1="A";
		String code2="004000";
		String code=code1+code2;
		String URL = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query="+code2;
		
		Document doc;
		Document doc2;
		Document doc3;
		Document doc4;
		Document doc5;
		int close=0;
		String stockname;
		int stockdiff=0;
		int diff=0;
		String date;
		
		try {
			//종가
			doc = Jsoup.connect(URL).get();
			Elements elem = doc.select("#_cs_root > div.ar_spot > div > h3 > a > span.spt_con.up > strong");
			String str = elem.text();
			close =Integer.parseInt(str.replaceAll(",", ""));
			
			
			//종목명
			doc2 = Jsoup.connect(URL).get();
			Elements elem2 = doc2.select("#_cs_root > div.ar_spot > div > h3 > a > span.stk_nm");
			stockname = elem2.text();
		
			
			//전일증감
			doc3 = Jsoup.connect(URL).get();
			Elements elem3 = doc3.select("#_cs_root > div.ar_spot > div > h3 > a > span.spt_con.up > span.n_ch > em:nth-child(3)");			
			stockdiff =Integer.parseInt(elem3.text());
			
			
			//증감률
			doc4=Jsoup.connect(URL).get();
			Elements elem4 = doc4.select("#_cs_root > div.ar_spot > div > h3 > a > span.spt_con.up > span.n_ch > em:nth-child(4)");		
			String str4 = elem4.text().replaceAll("\\(", "");;
		
			
			String str5 =Character.toString(str4.charAt(0));
			
			if(str5.equals("-")) {
				stockdiff=-stockdiff;
			}
			
			//날짜뽑기
			
			doc5=Jsoup.connect(URL).get();
			Elements elem5=doc5.select("#_cs_root > div.ar_cont > div.cont_grp > p > em");				
			String[] str6 = elem5.text().split(" ");		
			date = str6[0].substring(0, str6[0].length()-1);
			System.out.println("날짜"+date);
		}
			
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
			
			
		
	}
	
	
		
			
}
		
	


