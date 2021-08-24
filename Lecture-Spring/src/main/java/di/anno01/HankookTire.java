package di.anno01;

import org.springframework.stereotype.Component;

@Component
public class HankookTire implements Tire {

	public String getBrand() {
	
		return "한국타이어";
	}

}
