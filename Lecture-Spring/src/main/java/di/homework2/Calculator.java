package di.homework2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import di.anno03.Tire;
@Component("Calculator")
public class Calculator {
	
	@Autowired
	private Operator o;
	
	@Autowired
	public Calculator(Operator o) {
		this.o = o;
		System.out.println("calculator생성");
	}


	

	
	public void getValue(int num1, int num2) {
	
		System.out.println(o.getAdd(num1, num2));
		System.out.println(o.getMul(num1, num2));
		System.out.println(o.getDiv(num1, num2));
		System.out.println(o.getSub(num1, num2));
	}

}
