package kr.co.mlec.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
		@RequestMapping("/hello/hello.do")
		//get방식이건 post방식이건 하나의 메소드로.
		public ModelAndView hello() {
			ModelAndView mav = new ModelAndView("hello/hello"); 
			//생성자 뒤에 매개변수는 forward시킬 주소를 의미
			//spring-mvc.xml의 속성 view-resolvers로 prefix="/WEB-INF/jsp/" suffix=".jsp"로 인해
			///WEB-INF/jsp/hello/heollo.jsp 로 포워드 된다.
			mav.addObject("msg","hi 스프링MVC");
			//모델엔뷰 : 디스패처 서블릿이 알아서 공유영역에 등록시킴
			//공유영역에 등록시킬때 addObject를 사용한다.
			
			return mav;
		}
	

}
