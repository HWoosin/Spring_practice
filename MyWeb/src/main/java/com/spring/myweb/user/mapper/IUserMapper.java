package com.spring.myweb.user.mapper;

import org.apache.ibatis.annotations.Param;

import com.spring.myweb.command.UserVO;
import com.spring.myweb.util.PageVO;

public interface IUserMapper {

	//아이디 중복 확인
	int idCheck(String id);
	
	//회원가입
	void join(UserVO vo);
	
	//로그인
	/*
	 - MyBatis로 DB연동을 진행할 때, 파라미터 값이 2개 이상일 때 그냥 보내면 에러발생
	 1. @Param을 이용해서 이름을 붙여주는 방법. (xml 파일에서 해당 값을 지목할 수 있는 이름 붙이기)
	 2. Map으로 포장해서 보내는 방법
	 3. 클래스를 디자인해서 객체 하나만 매개값으로 보내는 방법 (VO)
	 
	 중 하나를 상황에 맞게 적절하게 선택하면 된당.
	 */
	String login(String id);
	
	//회원 정보 얻어오기
	UserVO getInfo(@Param("userId")String id , @Param("paging")PageVO vo);
	
	//회원 정보 수정
	void updateUser(UserVO vo);
	
	
}
