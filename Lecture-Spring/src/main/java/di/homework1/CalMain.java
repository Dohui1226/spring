package di.homework1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import di.anno03.Car;

public class CalMain {
	public static void main(String[] args) {
		
	
	ApplicationContext context = new GenericXmlApplicationContext("di.homework1.xml");
	
	Calculator calculator = context.getBean("calculator", Calculator.class);
	calculator.getValue(10, 3);
	
	//기본 틀
	//Operator operator = new Add(10,3);
	//Calculator calculator = new Calculator(operator);
	//calculator.getValue(10, 3);

	
	}
}
