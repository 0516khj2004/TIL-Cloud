package myspring.user.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.user.dao.mapper.StudentMapper;
import myspring.user.service.UserService;
import myspring.user.vo.StudentVO;
import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring_beans.xml")
public class MyBatisTest {
	
	private static final Logger logger = LogManager.getLogger();
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	SqlSession sqlSession; 
	
	@Autowired
	UserService userService;
	
	@Autowired
	StudentMapper studentMapper;
	
	@Test //1:1인경우  StudentVo,DeptVo를 가져오는 메서드
	public void stuMapper() {
		List<StudentVO> selectStudentDeptById = studentMapper.selectStudentDeptById();
		for (StudentVO studentVO : selectStudentDeptById) {
			System.out.println(studentVO);
		}
	}
	
	@Test
	public void service() {
		//UserService -> UserDao -> SqlSession -> SqlSessionFactory -> DataSource
		UserVO user = userService.getUser("gildong");
		System.out.println(user);
	}
	
	@Test 
	@Ignore
	public void sql2() {
		List<UserVO> userlist = sqlSession.selectList("userNS.selectUserList");
		for (UserVO userVO : userlist) {
			System.out.println(userVO);
		}
	}
	
	
	@Test
	@Ignore
	public void sql3() {
// SqlSession -> SqlSessionFactory -> DataSource
		   UserVO  updateUser = new UserVO("java", "자바2","여2", "제주2");
		      int cnt = sqlSession.update("userNS.updateUser",updateUser);
		      logger.info(">>>>>>>업데이트된 수 :" +cnt);
		      
		      List<UserVO> seleList = sqlSession.selectList("userNS.selectUserList");
		      for (UserVO userVO : seleList) {
				logger.debug(">>" +userVO);
			}
	}
		
	@Test
	@Ignore
	public void sql() {
		//SqlSession의 selectOne()	
		UserVO user = sqlSession.selectOne("userNS.selectUserById" ,"gildong");
		System.out.println(user);
		
		UserVO insertUser = new UserVO("java", "자바", "남", "인천");
		int cnt = sqlSession.insert("insertUser", insertUser );
		System.out.println("등록된 건수: " + cnt);
		
	}
	
	
	@Test 
	@Ignore
	public void mybatis_spring() {
		System.out.println(sqlSessionFactory.getClass().getName());
		System.out.println(sqlSession.getClass().getName());
	}
	
	@Test
	@Ignore
	public void con() {
		try {
			Connection con = dataSource.getConnection();
			System.out.println(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
