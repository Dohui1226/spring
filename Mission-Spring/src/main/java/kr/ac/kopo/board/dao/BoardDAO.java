package kr.ac.kopo.board.dao;

import java.util.List;

import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.comment.vo.CommentVO;

public interface BoardDAO {
	/**
	 * 전체 게시글 조회
	 * @return DB에서 조회된 BoardVO List
	 */
	List<BoardVO> searchAll();
	BoardVO selectByNo(int no);
	void insertBoard(BoardVO board);
	void addComment(CommentVO comment);
	List<CommentVO> selectAllComment(int no);
}
