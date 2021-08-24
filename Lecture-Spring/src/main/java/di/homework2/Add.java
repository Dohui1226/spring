package di.homework2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller("o")
public class Add implements Operator {
	@Value("10")
	int num1;
	@Value("3")
	int num2;
	
	public Add(int num1, int num2) {
		System.out.println("add생성");
	}
	
	public String getMul(int num1, int num2) {

		return num1+" X "+num2+" = "+num1*num2;
	}

	public String getSub(int num1, int num2) {

		return num1+" - "+num2+" = "+(num1-num2);
	}


	public String getDiv(int num1, int num2) {

		return num1+" / "+num2+" = "+(num1/num2);

	}
	public String getAdd(int num1, int num2) {
		return num1+" + "+num2+" = "+(num1+num2);

	}


	

}
