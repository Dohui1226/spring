package kr.ac.kopo.waggle.servie;

import java.util.List;

import kr.ac.kopo.vo.AddHeartVO;
import kr.ac.kopo.vo.CouponVO;
import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.RankListVO;
import kr.ac.kopo.vo.StockWeightVO;
import kr.ac.kopo.vo.WaggleJoinVO;

public interface WaggleService {
	
	void join(WaggleJoinVO waggle);//서비스 가입
	boolean joincheck(MemberVO member); //서비스 가입 여부
	int heartselect(WaggleJoinVO waggle);//하트 조회하기
	WaggleJoinVO waggle(MemberVO member); //와글정보 정보가져오기 
	void addHeart(AddHeartVO heart);//하트 결제하기
	void change(CouponVO couponvo); //쿠폰 교환하기
	List<CouponVO> selectcoupon(int no); //내 쿠폰 조회하기
	List<RankListVO> wagglerank();//랭킹리스트 뽑기
	List<StockWeightVO> wagglerankInfo(WaggleJoinVO waggle);
	public WaggleJoinVO selectaccount(int no); //회원번호로 가져오기
	
}
