package di.anno03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DriverMain {

	public static void main(String[] args) {
		
		
		ApplicationContext context = new GenericXmlApplicationContext("di.ann03.xml");
		
		Car car = context.getBean("myCar", Car.class);
		car.prnTireBrand();//의존주입!
	}
	
	
}

