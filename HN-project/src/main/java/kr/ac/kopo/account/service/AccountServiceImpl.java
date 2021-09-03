package kr.ac.kopo.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.account.dao.AccountDAO;
import kr.ac.kopo.vo.AccountVO;
import kr.ac.kopo.vo.MemberVO;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDAO dao;
	
	/* 내 계좌 조회하기 */
	public List<AccountVO> myaccount(MemberVO member) {
		System.out.println("서비스1");
		List<AccountVO> list= dao.myaccount(member);
		System.out.println("서비스");
		return list;
	}
	
}
