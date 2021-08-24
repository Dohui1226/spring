package di.anno03;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myCar")
public class Car {
	
	
	@Autowired
	private Tire tire;
	
	
	
	public Car() {
		System.out.println("Car()...");
	}
	@Autowired
	//@Quilfier("kumhoTire") 에러남 왜???
	public Car(Tire tire) {
		this.tire=tire;
		System.out.println("Car(Tire)...");
	}
	//@Autowired
	//@Resource
	//@Quilfier("hankookTire") 검색 먼저함.
	public void setTire(Tire tire) {
		this.tire=tire;
		System.out.println("Car(Tire)...");
	}


	
	public void prnTireBrand() {
	
		System.out.println("장착된 타이어:"+tire.getBrand());
	}

}
