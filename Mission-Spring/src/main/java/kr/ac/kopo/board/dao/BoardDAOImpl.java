package kr.ac.kopo.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.comment.vo.CommentVO;

/**
 * 
 * @author HP
 *
 */
@Repository
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	public List<BoardVO> searchAll() {
		List<BoardVO> list = sqlSessionTemplate.selectList("board.BoardDAO.selectAll");
		return list;
	}
	
	public BoardVO selectByNo(int no) {
		BoardVO board = sqlSessionTemplate.selectOne("board.BoardDAO.selectByNo", no);
		return board;
	}
	
	public void insertBoard(BoardVO board) {
		sqlSessionTemplate.insert("board.BoardDAO.newBoard", board);
		
	}
	
	public void addComment(CommentVO comment) {
		sqlSessionTemplate.insert("board.BoardDAO.newComment", comment);
		
	}
	
	public List<CommentVO> selectAllComment(int no) {
		List<CommentVO> list  = sqlSessionTemplate.selectList("board.BoardDAO.selectComment",no);
		System.out.println("dao");
		return list;
	}
	
}
