package kr.ac.kopo.board.service;

import java.util.List;

import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.comment.vo.CommentVO;
//서비스는 여러개의 dao를 호출할수 있다.
public interface BoardService {
	
	List<BoardVO> selectAllBoard();
	BoardVO selectOneBoard(int no);
	void InsertOneBoard(BoardVO board);
	void addComment(CommentVO comment);
	List<CommentVO> selectAllCommet(int no);
}
