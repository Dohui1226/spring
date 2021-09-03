package kr.ac.kopo.waggle.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.WaggleJoinVO;

@Repository
public class WaggleDAOImpl implements WaggleDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	/* 가입하기 */
	public void join(WaggleJoinVO waggle) {
		sqlSessionTemplate.insert("waggle.WaggleDAO.join", waggle);
				
	}
	
	/* 가입여부 확인하기 */
	public int joincheck(MemberVO member) {
		int jcheck = sqlSessionTemplate.selectOne("waggle.WaggleDAO.joincheck", member);
		return jcheck;
	}
	
	/* 하트갯수 조회하기 */
	public int heartselect(WaggleJoinVO waggle) {
		int heart = sqlSessionTemplate.selectOne("waggle.WaggleDAO.heartselect", waggle);
		return heart;
	}
	
	/* 와글정보 가져오기 */
	public WaggleJoinVO waggle(MemberVO member) {
		WaggleJoinVO waggleVO =
				sqlSessionTemplate.selectOne("waggle.WaggleDAO.waggle", member);	
		return waggleVO;
	}
	
}
