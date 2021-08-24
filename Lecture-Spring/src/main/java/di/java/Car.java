package di.java;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
	
	
	@Autowired
	@Qualifier("hankook")
	//퀄리파이어를 지정해준다. 빈이 두개일때 오류나니까 이거 지정해주면 안남
	private Tire tire;
	
	
	
	public Car() {
		System.out.println("Car()...");
	}
	
	public Car(Tire tire) {
		this.tire=tire;
		System.out.println("Car(Tire)...");
	}
	
	public void setTire(Tire tire) {
		this.tire=tire;
		System.out.println("Car(Tire)...");
	}


	
	public void prnTireBrand() {
		System.out.println("장착된 타이어:"+tire.getBrand());
	}

}
