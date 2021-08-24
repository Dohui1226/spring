package kr.ac.kopo.board.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.comment.vo.CommentVO;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	@RequestMapping("/board")
	public ModelAndView selectAll() {
		List<BoardVO> boardList = service.selectAllBoard();
		System.out.println("전체게시글 조회..");
		
		ModelAndView mav = new ModelAndView("board/list");
		mav.addObject("list", boardList);
		
		return mav;
	}
	//htt[://localhost:9999/Mission-spring/board/detail?no=21
	//@RequestMapping("/board/detail")
	//public void selectByNo(HttpServletRequest request) {
	//	int no = Integer.parseInt(request.getParameter("no"));
	//	System.out.println("no:" +no);
	//	System.out.println("상세게시글 조회...");
	//}
	
	@RequestMapping("/board/detail")
	public void selectByNo(@RequestParam("no") int no) {
		
		System.out.println("no:" +no);
	}
	
	
	//http://localhost:9999/Mission-Spring/board/12
	//getpost둘다..
	@RequestMapping("/board/{no}")
	//{}안에 무엇인가 값이 들어올것임 날라오는 숫자를 밑에 함수에 대입 패스에서 변수가져오는거임..
	public ModelAndView selectByNo2(@PathVariable("no") int no) {

		BoardVO board = service.selectOneBoard(no);
		List<CommentVO> commetList = service.selectAllCommet(no);
		
		ModelAndView mav = new ModelAndView("board/detail");
		mav.addObject("board", board);
		mav.addObject("clist",commetList);
		return mav;
	}
	/*
	 * //새글등록폼 get방식만 //GetMapping 4.3버전이후 //@RequestMapping(value="/board/write",
	 * method=RequestMethod.GET)
	 * 
	 * @GetMapping("/board/write") public String writeForm() {
	 * 
	 * return "board/write"; } //리턴값이 보이드면 디스패쳐서블릿이 /board/write가 리턴되었다고 생각한다..??
	 * uri와 똑같은 jsp를 포워드 시킴 //GetMapping 4.3버전이후
	 * 
	 * @RequestMapping(value="/board/write", method=RequestMethod.POST)
	 * 
	 * @PostMapping("/board/write") 
	 * //RequestParam@("title") String title 대신에 그냥
	 * BoardVO board 하면 알아서 board객체 매핑 ,boardVO등록
	 * public void wirte(BoardVO board) {
	 * System.out.println("post /board/write"); System.out.println(board);
	 * 
	 * }
	 */
	
	//객체가 필요함
	@GetMapping("/board/write")
	public String writeForm(Model model) {
	
		model.addAttribute("boardVO", new BoardVO()); 
		//공유영역에 객체 하나 등록
		return "board/write";
	}
	
	
	@PostMapping("/board/write")
	public String wirte(@Valid BoardVO board, Errors error) {
		
		System.out.println(error.hasErrors());//에러가 있니 없ㅈ\니
		if(error.hasErrors()) {
			//request.setAttribute("board",board); //이렇게 등록안해도됨 boardVO 가져오니까 자동 등록
			return "board/write";
			
		}
		//에러가 없으면
		service.InsertOneBoard(board);
		return "redirect:/board";
	}
	
	//게시글 댓글 등록하기
	@PostMapping("/board/{no}/addComment")
    @ResponseBody
    public String addComment(@PathVariable("no") int no, CommentVO comment) {      
		comment.setBoardNo(no);
		service.addComment(comment);      
        return "redirect:/board/"+no;
    }
		
	
}


