package kr.ac.kopo.account.dao;

import java.util.List;

import kr.ac.kopo.vo.AccountVO;
import kr.ac.kopo.vo.MemberVO;

public interface AccountDAO {

	 List<AccountVO> myaccount(MemberVO member);

}
