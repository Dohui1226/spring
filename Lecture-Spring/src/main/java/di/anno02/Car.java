package di.anno02;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {
	
	
	//@Resource 멤버변수; 셋터만 가능
	private Tire tire;
	
	
	
	public Car() {
		System.out.println("Car()...");
	}
	//@Resource
	public void setTire(Tire tire) {
		this.tire=tire;
		System.out.println("Car(Tire)...");
	}


	
	public void prnTireBrand() {
	
		System.out.println("장착된 타이어:"+tire.getBrand());
	}

}
