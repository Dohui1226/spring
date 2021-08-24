package di.xml02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import di.anno01.Car;

public class DirverMain {
	
	public static void main(String[] args) {
		
	ApplicationContext context = new GenericXmlApplicationContext("di-xml02.xml");
	Car car = context.getBean("car", Car.class);
	car.prnTireBrand();
	
	
	/*
	 * Tire tire = new HankookTire();
	 *  Car car = new Car(tire); 
	 *  car.prnTireBrand();
	 */
	}

}
