package com.spring.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//자동으로 스프링 컨테이너에 해당 클래스의 빈을 등록하느 아노테이션.
//빈을 등록해 놔야 HandlerMapping이 이 클래스의 객체를 검색할 수 있다.
@Controller
public class RequestController {

	public RequestController() {
		System.out.println("RequestCon 생성!");
	}
	
	@RequestMapping("/request/test")
	public String testCall() {
		System.out.println("/request/text 요청이 들어옴!");
		return "test";
	}
	/*
	 만약 사용자가 /request/req 요청을 보내 왔을 때
	 views 폴더 아래에 request 폴더 안에 존재하는 
	 req-ex01.jsp 파일로 응답을 줄 수 있게 메서드를 작성해보기
	 */
	@RequestMapping("/request/req")
	public String req1() {
		System.out.println("/request/req");
		return "request/req-ex01";
	}
	
	
	//Post방식과 GET방식을 구별시키기
//	@RequestMapping(value = "/request/basic01", method = RequestMethod.GET)
	@GetMapping("/request/basic01")
	public String req() {
		System.out.println("/request/basic01 (get)요청이 들어옴");
		return "request/req-ex01";
	}
	
//	@RequestMapping(value = "/request/basic01", method = RequestMethod.POST)
	@PostMapping("/request/basic01")
	public String basic() {
		System.out.println("/request/basic01 (post)요청이 들어옴!");
		return "request/req-ex01";
	}
}









