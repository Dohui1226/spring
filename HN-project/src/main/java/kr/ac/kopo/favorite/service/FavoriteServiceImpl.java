package kr.ac.kopo.favorite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.account.dao.AccountDAO;
import kr.ac.kopo.favorite.dao.FavoriteDAO;
import kr.ac.kopo.vo.AccountDailyVO;
import kr.ac.kopo.vo.FollowVO;
import kr.ac.kopo.vo.LikeCompanyVO;
import kr.ac.kopo.vo.Portfolio2VO;
import kr.ac.kopo.vo.PortfolioVO;
import kr.ac.kopo.vo.StockTodayVO;
import kr.ac.kopo.vo.WaggleJoinVO;

@Service
public class FavoriteServiceImpl implements FavoriteService {

	@Autowired
	private FavoriteDAO dao;
	
	
	public void insertlike(LikeCompanyVO lc) {
		dao.insertlike(lc);
		
	}
	
	public List<StockTodayVO> likecomapnylist(WaggleJoinVO waggle) {
		List<StockTodayVO> lc = dao.likecompanylist(waggle);
		return lc;
	}
	
	/* 팔로우하기 */
	
	public void insertlikeman(FollowVO fl) {
		dao.likeman(fl);
		
	}
	
	/* 포트폴리오 좋아요 관심함 */
	public void likeport(PortfolioVO pf) {
		dao.likeport(pf);
		
	}
	
	/* 내가찜한포트폴리오 */
	public List<PortfolioVO> selectport(PortfolioVO pf) {
		List<PortfolioVO> list = dao.selectport(pf);
		return list;
	}
	
	/* 누구의 포트폴리오인지 몇개의 종목인지 */
	
	public List<PortfolioVO> selectportname(PortfolioVO pf) {
		List<PortfolioVO> list = dao.selectportname(pf);
		return list;
	}
	
}
