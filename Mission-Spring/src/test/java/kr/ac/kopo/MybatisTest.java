package kr.ac.kopo;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.member.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
//JUNIT실행하려고 하고(내가만든게 잘 실행되고 있는지 테스트하기위함)
@ContextConfiguration(locations= {"classpath:config/spring/spring-mvc.xml"})
//실행하면서 저 파일을 읽어오려고함
public class MybatisTest {
	@Autowired
	//객체가 올바르게 만들어져있다면 주입이 가능하다.
	private DataSource dataSource;
	@Autowired
	private SqlSessionFactory sqlFactory;
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	@Test
	public void 로그인테스트() throws Exception{
		MemberVO member = new MemberVO();
		member.setId("dohwi1226");
		member.setPassword("eg1226");
		MemberVO userVO = sessionTemplate.selectOne("member.MemberDAO.login", member);
	
		assertNotNull(userVO);
	}
	
	
	@Ignore
	//테스트 안하겠다
	@Test
	//이 메소드만 실행할때 쓰는 어노테이션
	public void DataSource생성테스트() throws Exception{
		//System.out.println("dataSource:" +dataSource);
		assertNotNull(dataSource);
		//널이아니면 성공한것 널이면 주입안되어있다..널이면 빨간색 낫널이면 초록색
	
			
		}
	@Ignore
	@Test
	public void mybatis연동테스트() throws Exception{
		//assertNotNull(sqlFactory);
		assertNotNull(sessionTemplate);
	}
}
