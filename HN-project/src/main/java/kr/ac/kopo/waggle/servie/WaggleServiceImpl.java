package kr.ac.kopo.waggle.servie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.vo.AccountVO;
import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.WaggleJoinVO;
import kr.ac.kopo.waggle.dao.WaggleDAO;

@Service
public class WaggleServiceImpl implements WaggleService{
	@Autowired
	private WaggleDAO waggleDAO;
	
	
	/*가입*/
	public void join(WaggleJoinVO waggle) {
		waggleDAO.join(waggle);
		
	}
	
	
	/*가입 여부확인*/
	public boolean joincheck(MemberVO member) {
		boolean bool = false;
		int jcheck = waggleDAO.joincheck(member);
		
		if(jcheck == 1) 
			bool=true;
		return bool;
	}
	
	
	/* 하트조회하기 */
	public int heartselect(WaggleJoinVO waggle) {
		
		int heart = waggleDAO.heartselect(waggle);
		return heart;
	}
	
	
	/* 와글정보 등록하기 */
	public WaggleJoinVO waggle(MemberVO member) {
		
		WaggleJoinVO waggleVO = waggleDAO.waggle(member);
		return waggleVO;
	}

	
	/* 하트 일회성 충전*/
//	public void addheart(WaggleJoinVO waggle, AccountVO account, int heart, int money) {
		//충전을 하면 account 계좌 잔액이 마이너스가 되고, waggle 하트가 증가된다.
//		
//	}
//	
	

}
