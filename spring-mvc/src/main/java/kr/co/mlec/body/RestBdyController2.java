package kr.co.mlec.body;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.mlec.form.MemberVO;

@RestController
//메소드가 메세지기반으로됨 restcontroller
//responsebody(자바로 만든 객체값을 클라이언트가 인식할수 있도록 json으로 바꿔줌) 대신으로 사용
//requestbody (제이슨 형태로 날라오는 객체를 자바형태로 바꿔줄 수있음 당연히 파라미터쪽에 붙음..)
@RequestMapping("/ajax")
public class RestBdyController2 {
	@RequestMapping("/restBody.do")
	public String resStringBody() {
		//만약 String반환하면 return에  주소라고 인식된다. 리턴은 주소를 써야함
		//만약 responseBody를 쓰면 return 포워드 시키지말고 바로 응답하라는것				
		return "OK, 성공";
	}
	
	@RequestMapping("restBody.json")
	public Map<String,String> resJonsBody(){
		Map<String, String> result = new HashMap<String,String>();
		
		result.put("id","hong");
		result.put("name", "홍길동");
		result.put("addr", "서울");
		
		return result;
	}
	
	@RequestMapping("/restVOBody.json")

	public MemberVO resJsonVOBody() {
		MemberVO vo =  new MemberVO();
		vo.setId("hong");
		vo.setName("홍길동");
		vo.setPassword("1234");
		
		return vo;
	}
	
	@RequestMapping("/restStringListBody.json")

	public List<String> resJsonStringListBody(){
		List<String> list = new ArrayList<String>();
		for(int i =1; i<=4; i++) { //리스펀스바디가 제이슨형태로 변환시켜줌.
			list.add(String.valueOf(i));
		}
		return list;
	}
		
	@RequestMapping("/restVOListBody.json")

	public List<MemberVO> resVOListBody(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		for(int i = 0; i <4; i++) {
			MemberVO vo =  new MemberVO();
			vo.setId("hong");
			vo.setName("홍길동");
			vo.setPassword("1234");
			list.add(vo);
			
		}
		return list;
	}

}
