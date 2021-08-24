package di.anno01;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {
	
	
	//@Autowired 
	private Tire tire;
	//멤버변수에 auto를 하면 tire객체를 만들때 알아서.. 기본생성자가? 주입이된다.
	
	public Car() {
		System.out.println("Car()...");
	}
	
	
	@Autowired
	public Car(Tire tire) {
		this.tire=tire;
		System.out.println("Car(Tire)...");
	}
	//@Autowired
	public void setTire(Tire tire) {//세터주입은 기본생성자 호출후 만들어지기 때문에 기본생성자 있어야함.
		this.tire=tire;
		System.out.println("Car(Tsire)...");
	}


	
	public void prnTireBrand() {
	
		System.out.println("장착된 타이어:"+tire.getBrand());
	}

}
