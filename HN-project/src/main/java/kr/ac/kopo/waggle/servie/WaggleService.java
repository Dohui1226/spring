package kr.ac.kopo.waggle.servie;

import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.WaggleJoinVO;

public interface WaggleService {
	
	void join(WaggleJoinVO waggle);//서비스 가입
	boolean joincheck(MemberVO member); //서비스 가입 여부
	int heartselect(WaggleJoinVO waggle);//하트 조회하기
	WaggleJoinVO waggle(MemberVO member); //와글정보 정보가져오기 
}
