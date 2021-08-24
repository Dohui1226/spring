package aop.test;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class MyAspect {
	
	@Before("execution(* aop.test.*.setAge(..))")
	public void checkAudlt(JoinPoint jointPoint) {//결합된 부분을 알아햐함
		/*
		 * System.out.println("jointPoint.getTarget()");//aop가 적용된 대상 객체를 반환한다. 프록시가 벗겨진 상태의 객체이다.
		 * System.out.println("jointPoint.getSignature()"); //signature 객체 반환(객체가 선언하는 모든 연산은 연산의 이름, 매개변수로 받아들이는 객체들을 연산의 시그니처라고함)
		 * System.out.println("jointPoint.getThis()"); //aop 프록시 객체 반환
		 * System.out.println(Arrays.toString(joinPoint.getArgs())));
		 * 
		 */	
		System.out.println("checkAdult");
		Object[] args = jointPoint.getArgs();//jointPoint에 전달된 인자를 배열로 반환한다.
		
		//if((int)args[0])<20){ //setage는 	0이고 오브젝트형이다.. int로 형변환하여 비교한다.
		int age = Integer.parseInt(args[0].toString());
		if(age < 20) {
			System.out.println("미성년입니다.checkadult");}
		else {
			System.out.println("성년입니다.");}
		}

		@Around("execution(* aop.test.*.setAge(..))")//셋에이지 안찍힘 setAge 호출하는 것을 아예 막음.. setAge 대신 chechkAdult2실행하라는 의미.. checkAdult2는 나오는디.
		public void checkAdult2(ProceedingJoinPoint joinPoint)  throws Throwable{//셋에이지 메소드 실행하려고 할때는 프로시드라는 메소드 사용한ㄷ.
			
			System.out.println("checkAdult2");
			joinPoint.proceed(); //프로시드는 위치에 따라 before와 after가 됨.
			Object[] args = joinPoint.getArgs();
			int age = Integer.parseInt(args[0].toString());
			if(age <20) {
				System.out.println("미성년입니다.checkadult2");
			}
			else {
				System.out.println("성년입니다.");
			}
			
		}
		
		
			//두개의 인자가 들어와야함 네임이콜 벨류로,, 한개는 디폴트로여기고
		@AfterThrowing(pointcut="execution(* aop.test.*.setAge(..))",throwing="ex")
		public void error(JoinPoint joinPoint, Throwable ex) {
			System.out.println("예외처리"+ex.toString());
		}



}
