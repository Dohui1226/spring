package kr.ac.kopo.waggle.dao;

import java.util.List;

import kr.ac.kopo.vo.AddHeartVO;
import kr.ac.kopo.vo.CouponVO;
import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.WaggleJoinVO;

public interface WaggleDAO {

	void join(WaggleJoinVO waggle); //서비스 가입
	int joincheck(MemberVO member); //서비스 가입 여부
	int heartselect(WaggleJoinVO waggle); //하트 조회
	WaggleJoinVO waggle(MemberVO member); //와글 멤버 정보 등록
	void addHeart(AddHeartVO heartVO);
	void change(CouponVO couponvo); //쿠폰교환하기
	List<CouponVO> selectcoupon(int no);

}
