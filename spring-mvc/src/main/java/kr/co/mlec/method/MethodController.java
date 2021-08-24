package kr.co.mlec.method;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value="/method/method.do")
@Controller
public class MethodController {
	
	//form 뺴고는 전부 get방식
	//method를 통해 get방식과 post방식을 분리할 수 있음. 이 방식을사용하면 같은 URL을 사용하는 장점이 있음
	//리턴타입스트링은 모델엔뷰, string, void 가능하다. String은 (포워드 시킬 jsp주소만 날라감.)/ void는 요청URL자체가 리턴이됨
	
	//@RequestMapping(value="/method/method.do", method=RequestMethod.GET) 클래스의 requestmapping 안쓸때
	@RequestMapping(method=RequestMethod.GET)
	public String callGet() {
		
		return "method/methodForm";
	}
	
	//post방식만 처리
	@RequestMapping(method=RequestMethod.POST)
	public String callPost() {
		
		return "method/methodProcess";
	}
}
