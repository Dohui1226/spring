package di.java;

import org.springframework.stereotype.Component;

@Component("kumgo")
public class KumhoTire implements Tire {

	
	public KumhoTire() {
		System.out.println("KumhokTire()...");
	}
	
	public String getBrand() {
		
		return "금호타이어";
	}

	
}
