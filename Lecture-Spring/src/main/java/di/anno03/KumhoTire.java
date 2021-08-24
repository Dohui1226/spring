package di.anno03;

import org.springframework.stereotype.Component;

@Component("tire")
public class KumhoTire implements Tire {

	public String getBrand() {
		
		return "금호타이어";
	}

}
