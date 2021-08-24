package di.java;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"di.java"})
//아래 다 주석처리해도 위에 컴포넌트스캔이면 가능.
@Configuration
public class Config {
	/*
	 * @Bean public Car car() { return new Car(); }
	 * 
	 * @Bean //빈클래스를 만드는것이 목적이므로 빈이라는 어노테이션을 사용한다.
	 * 
	 * @Qualifier("hankook") public HankookTire hankookTire() {//한국 타이어 함수를 리턴하는 한국
	 * 타이어 함수 return new HankookTire(); }
	 * 
	 * @Bean //한국타이어 금호타이어 둘다 빈넣으면 에러뜸.. 한개만해야함
	 * 
	 * @Qualifier("kumho") public KumhoTire kumgoTire() { return new KumhoTire(); }
	 */
}
