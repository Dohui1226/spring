package aop.test;

import org.springframework.stereotype.Component;

@Component
public class Man implements Person {
	
	private int age;

	public void setAge(int age) throws Exception {
		
		if(age<0)
			throw new Exception("나이에 음수는 사용할 수 없습니다.");

		this.age = age;
		System.out.println(age);
	}
}
