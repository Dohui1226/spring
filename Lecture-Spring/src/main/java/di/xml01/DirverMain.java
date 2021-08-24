package di.xml01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DirverMain {
	
	public static void main(String[] args) {
		
	ApplicationContext context = new GenericXmlApplicationContext("di-xml01.xml");
	
	/*
	 * 방법 2 xml 설정에서 이미 의존주입이 완료..
	 * Car car = (Car)context.getBean("car2");
	 *
	 */
	
	
	
	/*방법1
	 * Car car = (Car)context.getBean("car");
	 * //직접 객체를 만드는 것이아니라 얻어오는 것임...
	 *  Tire tire= (Tire)context.getBean("tire"); 
	 *  car.setTire(tire); 
	 *  car.prnTireBrand();
	 */
	
	/*
	 * Car car = new Car(); 
	 * Tire tire = new HankookTire(); //외부에서 타이어를 만듬
	 * car.setTire(tire);
	 *  car.prnTireBrand();
	 */ 
		
	}

}
