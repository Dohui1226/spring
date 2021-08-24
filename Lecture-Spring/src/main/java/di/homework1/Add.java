package di.homework1;

public class Add implements Operator {
	int num1;
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
