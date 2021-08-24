package basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		//1.
		//ApplicationContext context = new ClassPathXmlApplicationContext("beanContainer.xml"); 
		//클래스 패스(scr/main/resources)를 기준으로 xml을 읽어오겠다. applicationcontext는 실행되는 순간 객체가 생성됨.
		//파일을 읽어서 컨테이너에 집어넣는다
		
		//2.
		//ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/beanContainer.xml");
		//파일 위치? 를 기준으로 xml을 읽어오겠다.
		
	
		//3.
		ApplicationContext context = new GenericXmlApplicationContext("beanContainer.xml");
		//요즘에 많이 쓰이는 것으로 1,2 둘다 쓸수있음
		
		
		Hello obj=(Hello)context.getBean("hello");
		//id가 hello인 컨테이너를 이용해서 객체를 가져오는 함수, 리턴타입을 모르기 때문에 object형 명시적 형변환 필요!
		//System.out.println(obj); //주소값이 나옴
		
		
		//Hello obj2=(Hello)context.getBean("hello");
		//System.out.println(obj2); //주소값이 동일하게 나옴 
		
		obj.prnMsg();
		
		Hello obj2 = context.getBean("hello2",Hello.class); 
		//이렇게 뒤에 타입을 써주면 리턴타입이 hello.class로 바뀐다. 
		obj2.prnMsg();
		
		/*
		 * Hello obj = new Hello(); obj.prnMsg();
		 */
		
	}

}
