package kr.ac.kopo.favorite.dao;

import java.util.List;

import kr.ac.kopo.vo.FollowVO;
import kr.ac.kopo.vo.LikeCompanyVO;
import kr.ac.kopo.vo.Portfolio2VO;
import kr.ac.kopo.vo.PortfolioVO;
import kr.ac.kopo.vo.StockTodayVO;
import kr.ac.kopo.vo.WaggleJoinVO;

public interface FavoriteDAO {
	
	/* 관심등록하기 */
	void insertlike(LikeCompanyVO lc);

	/* 관심종목리스트뽑기 */
	List<StockTodayVO> likecompanylist(WaggleJoinVO waggle);

	/* 팔로우하기 */
	void likeman(FollowVO fl);
	
	/* 포트폴리오좋아요하기 */
	void likeport(PortfolioVO pf);

	/* 내가찜한 포트폴리오 */
	List<PortfolioVO> selectport(PortfolioVO pf);
	
	/* 누구의 포트폴리오인지 몇개종목인지 */
	List<PortfolioVO> selectportname(PortfolioVO pf);

}
