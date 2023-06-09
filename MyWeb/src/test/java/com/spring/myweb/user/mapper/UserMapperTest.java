package com.spring.myweb.user.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.spring.myweb.command.UserVO;
import com.spring.myweb.util.PageVO;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/db-config.xml")
@Slf4j
public class UserMapperTest {
	@Autowired
	private IUserMapper mapper;
	
	@Test
	@DisplayName("회원가입 진행했을 때 회원가입 성공해야한다.")
	void registTest() {
		UserVO vo = new UserVO();
		vo.setUserId("abc1234");
		vo.setUserPw("aaa1111");
		vo.setUserName("홍길동");
		
		mapper.join(vo);
	}
	
	@Test
	@DisplayName("존재하는 회원 아이디 조회했을시 1이 리턴")
	void checkIdTest() {
		String id = "abc1234";
		
		int result = mapper.idCheck(id);
//		System.out.println(result);
		assertEquals(1, result);
	}
	
	@Test
	@DisplayName("존재하는 회원 아이디와 올바른 비밀번호를 입력했을 시"
			+ "회원의 정보가 리턴되어야 한다.")
	void loginTest() {
		String id = "abc1234";
		String pw = "aaa1111";
		/*
		Map<String, String> data = new HashMap<>();
		data.put("userId", "abc1234");
		data.put("userPw", "aaa1111");
		*/
		assertNotNull(mapper.login(id));
		
	}
	
	@Test
	@DisplayName("존재하지 않는 회원의 아이디를 입력하면 null이 올 것이다.")
	void getInfoTest() {
		String id = "abc1234";
		PageVO paging = new PageVO();
		UserVO vo = mapper.getInfo(id, paging);
		log.info(vo.toString());
//		assertNull(mapper.getInfo(id));
		
	}
	
	@Test
	@DisplayName("id를 제외한 회원의 정보를 수정할 수 있다.")
	void updateTest() {
		UserVO vo = new UserVO();
		vo.setUserId("abc1234");
		vo.setUserPw("aaa1111");
		vo.setUserName("홍수정");
		vo.setUserEmail1("abc1234");
		vo.setUserEmail2("naver.com");

		mapper.updateUser(vo);
		
//		assertEquals(mapper.getInfo("abc1234").getUserName(), vo.getUserName());
	}
	
	
}
