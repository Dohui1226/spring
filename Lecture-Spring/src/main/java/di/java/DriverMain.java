package di.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DriverMain {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);//컨피그 파일은 환경설정에 관한것.
		//컨피그 파일을 읽고 환경설정을 해주겠다.
		
		Car car = context.getBean("car", Car.class);
		car.prnTireBrand();
	}
}
