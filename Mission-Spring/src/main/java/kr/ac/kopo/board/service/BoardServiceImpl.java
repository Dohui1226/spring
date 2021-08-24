package kr.ac.kopo.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.comment.vo.CommentVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	public List<BoardVO> selectAllBoard() {
		List<BoardVO> boardList =boardDAO.searchAll();
		return boardList;
		
	}
	
	public BoardVO selectOneBoard(int no) {
		BoardVO board = boardDAO.selectByNo(no);
		return board;
		
	}
	
	public void InsertOneBoard(BoardVO board) {
		boardDAO.insertBoard(board);
	}

	public void addComment(CommentVO comment) {
		boardDAO.addComment(comment);
		
	}
	
	public List<CommentVO> selectAllCommet(int no) {
		List<CommentVO> list = boardDAO.selectAllComment(no);
		return list;
	}
}
