package kr.ac.kopo.account.service;

import java.util.List;

import kr.ac.kopo.vo.AccountVO;
import kr.ac.kopo.vo.MemberVO;


public interface AccountService {
	

	List<AccountVO> myaccount(MemberVO member); //내계좌 조회하기

}
