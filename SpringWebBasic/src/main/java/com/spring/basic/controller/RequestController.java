package com.spring.basic.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.basic.model.UserVO;

//자동으로 스프링 컨테이너에 해당 클래스의 빈을 등록하느 아노테이션.
//빈을 등록해 놔야 HandlerMapping이 이 클래스의 객체를 검색할 수 있다.
@Controller
@RequestMapping("/request") //컨트롤러 자체에 공통된 URI 맵핑
public class RequestController {

	public RequestController() {
		System.out.println("RequestCon 생성!");
	}
	
	@RequestMapping("/test")
	public String testCall() {
		System.out.println("/request/text 요청이 들어옴!");
		return "test";
	}
	/*
	 만약 사용자가 /request/req 요청을 보내 왔을 때
	 views 폴더 아래에 request 폴더 안에 존재하는 
	 req-ex01.jsp 파일로 응답을 줄 수 있게 메서드를 작성해보기
	 */
	@RequestMapping("/req")
	public String req1() {
		System.out.println("/request/req");
		return "request/req-ex01";
	}
	
	
	//Post방식과 GET방식을 구별시키기
//	@RequestMapping(value = "/request/basic01", method = RequestMethod.GET)
	@GetMapping("/basic01")
	public String req() {
		System.out.println("/request/basic01 (get)요청이 들어옴");
		return "request/req-ex01";
	}
	
//	@RequestMapping(value = "/request/basic01", method = RequestMethod.POST)
	@PostMapping("/basic01")
	public String basic() {
		System.out.println("/request/basic01 (post)요청이 들어옴!");
		return "request/req-ex01";
	}
	
	/////////////////////////////////////////////////////////////////////
	
	//컨트롤러 내의 메서드 타입을 void로 선언하면
	//요청이 들어온 URL값을 뷰 리졸버에게 전달
	@GetMapping("/join")
	public void register() {
		System.out.println("/request/join: GET");
	}
	
	//요청 URI 주소가 같더라도, 전송 방식에 따라 맵핑을 다르게 하기 때문에
	//같은 주소를 사용하는 것이 가능하다. (GET -> 화면처리, POST -> 입력값 처리)

	/*
	 # 스프링에서 요청과 함께 전달된 데이터를 처리하는 방식
	 
	 1. 전통적인 jsp/servlet 방식의 피라미터 읽기 처리 방법.
	 - HttpServletRequest 객체를 활용(jsp에서 사용하던 방식)
	  
	
	@PostMapping("/join")
	public void register(HttpServletRequest request) {
		System.out.println("/request/join: POST");
		
		System.out.println("ID: " + request.getParameter("userId"));
		System.out.println("Pw: " + request.getParameter("userPw"));
		System.out.println("HOBBY: " + Arrays.toString(request.getParameterValues("hobby")));
	}
	*/
	
	/*
	 2. @RequestParam 아노테이션을 이용한 요청 파라미터 처리.
	 @RequestParam("파라미터 변수명") 값을 받아서 처리할 변수
	 파라미터 변수명과 값을 받을 변수명을 동일하게 작성하면 @RequestParam 생략 가능.
	
	@PostMapping("/join")
	public void register(@RequestParam("userId") String id,
							@RequestParam("userPw") String pw,
							@RequestParam(value = "hobby", required = false, defaultValue = "no hobby person") List<String> hobbies) {//안들어올수도있다.
		System.out.println("/request/join: POST");

		System.out.println("ID: " + id);
		System.out.println("Pw: " + pw);
		System.out.println("HOBBY: " + hobbies);
		
	}
	 */
	
	/*
	 3. 커맨드 객체를 활용한 파라미터 처리
	 - 파라미터 데이터와 연동되는 VO 클래스가 필요.
	 */
	
	@PostMapping("/join")
	public void register(UserVO vo) {
			System.out.println(vo);
	}
}











