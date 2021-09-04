package kr.ac.kopo.account.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.vo.AccountVO;
import kr.ac.kopo.vo.MemberVO;

@Repository
public class AccountDAOImpl implements AccountDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<AccountVO> myaccount(MemberVO member){
		
		List<AccountVO> list = sqlSessionTemplate.selectList("account.AccountDAO.accountAll", member);
		
		return list;
		
	}

}
