package kr.ac.kopo.favorite.service;

import java.util.List;

import kr.ac.kopo.vo.FollowVO;
import kr.ac.kopo.vo.LikeCompanyVO;
import kr.ac.kopo.vo.Portfolio2VO;
import kr.ac.kopo.vo.PortfolioVO;
import kr.ac.kopo.vo.StockTodayVO;
import kr.ac.kopo.vo.WaggleJoinVO;

public interface FavoriteService {
	
	
	/* 관심등록하기 */
	void insertlike(LikeCompanyVO lc);
	
	/* 관심종목리스트 */
	List<StockTodayVO> likecomapnylist(WaggleJoinVO waggle);

	/* 팔로우하기 */
	void insertlikeman(FollowVO fl);
	
	/* 포트폴리오좋아요하기 */
	void likeport(PortfolioVO pf);

	/* 내가찜한포르톺리오보기 */
	List<PortfolioVO> selectport(PortfolioVO pf);
	
	List<PortfolioVO> selectportname(PortfolioVO pf);
}
