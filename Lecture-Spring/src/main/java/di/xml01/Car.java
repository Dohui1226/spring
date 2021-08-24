package di.xml01;

import di.basic.Tire;

public class Car {
	
	
	//의존관계 발생 : 다른객체의 멤버변수를 가지고 있음
	private Tire tire;
	/*
	 * public Car(Tire tire) { 
	 * this.tire = tire; }
	 * //2.프로그램에 실행전 미리 객체를 만들어 놓음 생성자를 통해서(생성자 의존 주입)
	 */
	
	
	
	public Car() {
		
	}
	
	public void setTire(Tire tire) {
		this.tire=tire;
	}
	//3 세터 주입
	
	
	
	
	/*
	 * public Car() {
	 * tire = new HankookTire(); 
	 * }
	 * 
	 * //1. 의존관계 직접 설정 한국, 금호 설정할 수 있음. 개발자가 필요한 시점에 객체를 만드는것 ->좋지않음../외부에서 객체를 만들고 싶음 
	 */
	
	public void prnTireBrand() {
	
		System.out.println("장착된 타이어:"+tire.getBrand());
	}

}
