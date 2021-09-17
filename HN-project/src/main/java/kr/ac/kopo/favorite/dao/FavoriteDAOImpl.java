package kr.ac.kopo.favorite.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.vo.FollowVO;
import kr.ac.kopo.vo.LikeCompanyVO;
import kr.ac.kopo.vo.Portfolio2VO;
import kr.ac.kopo.vo.PortfolioVO;
import kr.ac.kopo.vo.StockTodayVO;
import kr.ac.kopo.vo.WaggleJoinVO;
@Repository
public class FavoriteDAOImpl implements FavoriteDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	/* 관심종목등록하기 */
	public void insertlike(LikeCompanyVO lc) {
		sqlSessionTemplate.insert("favorite.FavoriteDAO.insertlike",lc);
		
	}
	
	/* 관심종목리스트뽑기 */
	public List<StockTodayVO> likecompanylist(WaggleJoinVO waggle) {
		List<StockTodayVO> lc =sqlSessionTemplate.selectList("favorite.FavoriteDAO.companylist",waggle);
		return lc;
		
	}
	
	/* 팔로우하기 */	
	public void likeman(FollowVO fl) {
		sqlSessionTemplate.insert("favorite.FavoriteDAO.likeman",fl);
		
	}
	/* 포트폴리오 좋아요하기 */
	public void likeport(PortfolioVO pf) {
		sqlSessionTemplate.insert("favorite.FavoriteDAO.likeport",pf);
		
	}
	
	/* 내가찜한포트폴리오 */
	public List<PortfolioVO> selectport(PortfolioVO pf) {
		List<PortfolioVO> list= sqlSessionTemplate.selectList("favorite.FavoriteDAO.selectport",pf);
		return list;
	}
	
	/* 누구포트폴리오인지 몇개종목인지 */
	public List<PortfolioVO> selectportname(PortfolioVO pf){
		List<PortfolioVO> list= sqlSessionTemplate.selectList("favorite.FavoriteDAO.selectportname",pf);
		return list;
	}
	

}
