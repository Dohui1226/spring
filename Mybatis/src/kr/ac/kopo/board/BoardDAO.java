package kr.ac.kopo.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.MyConfig;

public class BoardDAO {
	private SqlSession session;

	public BoardDAO() {
		session = new MyConfig().getInstance();
		System.out.println(session);
	}

	public void work() {
		//selectWhere();
		//selectNos();
		//selectNos2();
		selectNos3();
		// insert();
		// selectAll();
		// selectOne();
		// selectOne2();
		// selectOne3();
		//selectOne4();
	}

	private void selectWhere() {
	//	List<BoardVO> list = session.selectList("board.BoardDAO.selectWhere","파일");
		
		BoardVO vo = new BoardVO();
		//vo.setTitle("파일");
		vo.setWriter("hong");
		List<BoardVO> list = session.selectList("board.BoardDAO.selectWhere2",vo);
		for(BoardVO board : list) {
			System.out.println(board);
		}
	}
	private void selectNos() {

		
		  BoardVO board = new BoardVO();
		  board.setNos(new int[] {25,26,27});
		  List<BoardVO> list = session.selectList("board.BoardDAO.selectNos",board);
		  
		  for(BoardVO b : list) { System.out.println(b); }
		 
		 
	}
	private void selectNos2() {

		
		  List<Integer> nos = new ArrayList<>();
		  nos.add(1); 
		  nos.add(2); 
		  nos.add(25);
		  nos.add(26); 
		  List<BoardVO> list =
		  session.selectList("board.BoardDAO.selectNos2",nos);
		 
	}
	
	
	
	private void selectNos3() {

		  int[] nos = new int[] {25,26,2};
		  List<BoardVO> list =
		  session.selectList("board.BoardDAO.selectNos3",nos); 
		  for (BoardVO b : list) {
		  System.out.println(b); }
	}
	

	private void selectOne() {
		BoardVO board = new BoardVO();
		board.setNo(20);
		BoardVO result = session.selectOne("board.BoardDAO.selectOne", board); // 하나의 행만 가져온다.
		System.out.println(result);
	}


	private void selectOne4() {
		BoardVO board = new BoardVO();
		board.setNo(2);
		Map<String, Object> map = session.selectOne("board.BoardDAO.selectOne4", board); // 하나의 행만 가져온다.
		
		Set<String> keys = map.keySet();
		for(String key : keys) {
			System.out.println(key+ ":"+map.get(key));
		}
	}
	private void selectOne2() {

		BoardVO result = session.selectOne("board.BoardDAO.selectOne2", 20); // 하나의 행만 가져온다.
		System.out.println(result);
	}

	private void selectOne3() {

		BoardVO result = session.selectOne("board.BoardDAO.selectOne3", 20); // 하나의 행만 가져온다.
		System.out.println(result);
	}

	private void selectAll() {
		//		List<BoardVO> list = session.selectList("board.BoardDAO.selectAll"); //알아서 리스트로 리턴해줌..
		List<BoardVO> list = session.selectList("board.BoardDAO.selectAllMap"); // 알아서 리스트로 리턴해줌..
		for (BoardVO board : list) {
			System.out.println(board);
		}
		;
	}

	private void insert() {
		BoardVO board = new BoardVO();
		board.setTitle("객체로 삽입..board..");
		board.setWriter("홍순이");
		board.setContent("삽입되었니..");

		session.insert("board.BoardDAO.newBoard", board);
		session.commit();

		System.out.println("추가완료");
	}

}
