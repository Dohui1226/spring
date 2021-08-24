package di.basic;

import di.xml01.Car;

public class DriverMain {

	public static void main(String[] args) {
		

		
		HankookTire han = new HankookTire();
		KumhoTire kum =new KumhoTire();
		
		//3.setter 주입방식
		Car car = new Car();
		car.setTire(han);
		car.prnTireBrand();
		
		
		/*
		 * //2. 생성자 주입방식 Car car = new Car(han); 
		 * //외부에 객체 생성 (의존 주입) 
		 * car.prnTireBrand();
		 */
		
		
		
		/*1. 개발자가 설정 -> 비추 
		 * Car car = new Car();
		 *  car.prnTireBrand();
		 */	
		
	}
	
	
}

