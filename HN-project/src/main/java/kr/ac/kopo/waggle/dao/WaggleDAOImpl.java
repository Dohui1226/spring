package kr.ac.kopo.waggle.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.vo.AddHeartVO;
import kr.ac.kopo.vo.CouponVO;
import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.RankListVO;
import kr.ac.kopo.vo.StockWeightVO;
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
	
	
	public void addHeart(AddHeartVO heartVO) {
		sqlSessionTemplate.insert("waggle.WaggleDAO.addheart",heartVO);
		
	}
	
	
	public void change(CouponVO couponvo) {
		sqlSessionTemplate.insert("waggle.WaggleDAO.change",couponvo);
		
	}
	
	/* 쿠폰조회하기 */
	public List<CouponVO> selectcoupon(int no) {
		List<CouponVO> list = sqlSessionTemplate.selectList("waggle.WaggleDAO.selectcoupon",no);
		return list;
	}
	
	/* 와글 랭킹 리스트 뽑기 */
	public List<RankListVO> wagglerank() {
		List<RankListVO> list =sqlSessionTemplate.selectList("waggle.WaggleDAO.wagglerank");
		return list;
	}
	
	
	public WaggleJoinVO selectaccount(WaggleJoinVO waggle) {
		waggle =sqlSessionTemplate.selectOne("waggle.WaggleDAO.selectaccount",waggle);
		
		return waggle;
	}
	
	public List<StockWeightVO> stockweigth(WaggleJoinVO waggle) {
		List<StockWeightVO> list =sqlSessionTemplate.selectList("waggle.WaggleDAO.stockweight",waggle);
			return list;
		}
}
