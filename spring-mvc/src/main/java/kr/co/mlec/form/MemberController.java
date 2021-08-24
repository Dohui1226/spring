package kr.co.mlec.form;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/form")
//spring-mvc/밑에 form이라는 uri가 들어오면 무조건 memberController가 담당하겠다
public class MemberController { 
	
	//그중에 joinForm.do는 joinForm()이 담당한다.
	//form.joinForm.do
	@RequestMapping("/joinForm.do") 
	public String joinForm() {
		return "form/joinForm";
	}
	
	@RequestMapping("/join.do") 
	public String join(MemberVO member, Model model) { 
	//모델객체를 가져와서 객체를 등록시킬수도 있다.
	
	model.addAttribute("member",model);
	 
	 return "form/memberInfo"; //이건 에러날ㄷ걸?ㅇㅏ닌가
	 }
	
	
	
	/*
	@RequestMapping("/join.do") 
	public ModelAndView join(MemberVO member) { 
	//네번째방법 반환타입 모델엔뷰 
	 
	ModelAndView mav = new ModelAndView();
	mav.setViewName("form/memberInfo");//포워드시킬 주소??
	mav.addObject("member",member);
	 
	 
	 
	 return mav;
	 }
	
	*/
	
	
	
	
	/*
	 * @RequestMapping("/join.do") public String join(@ModelAttribute("member")
	 * MemberVO member) { //세번쨰 방법 만약 가져올 변수가 많아질경우는? -> ModelAttribute -> 생략가능
	 * //ModelAttribute를 통해 원하는 이름으로 등록가능.(member) //알아서 request영역에 등록시켜준다. ->
	 * MemverVO로 등록됨.. MemberVO로 값 불러와야함
	 * 
	 * 
	 * 
	 * return "form/memberInfo"; }
	 */
	
	
	/*
	@RequestMapping("/join.do")
	public String join(@RequestParam("id") String id,@RequestParam("password") String password,
			@RequestParam("name") String name, HttpServletRequest request) { 
	//두번쨰 방법
	//애초에 디스패처서블릿의 request를 받아오니까 이미 request로 id를 추출한것을 받아서 id 넘기는것-> RequestParam
	
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		
		
		request.setAttribute("member", member);
		
		return "form/memberInfo";
	}
	*/
	
	/*@RequestMapping("/join.do")
	public String join(HttpServletRequest request) {
	//첫번째 방법 request 매개변수로 호출 가능(날라오는 파라미터 내가 정할 수 있음)
		
		//인코딩 필터로 utf-8안써도 됨
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		
		//이미 request을 알고 있으니까 모델엔뷰에 안넣어도됨.
		request.setAttribute("member", member);
		
		return "form/memberInfo";
	}*/
	
}
