package com.spring.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.basic.model.UserVO;

@Controller
@RequestMapping("/response")
public class ResponseController {
	
	@GetMapping("/res-ex01")
	public void resEx01() {}
	
	/*
	 1. Model 객체를 사용하여 응답할 화면에 데이터를 전송하기
	
	@GetMapping("/test")
	public void test(int age, Model model) {
		model.addAttribute("age", age);
		model.addAttribute("nick", "멍멍이");
	}
	*/
	
	//2. @ModelAttribute를 사용한 화면에 데이터 전송 처리
	//@RequestParam + model.addAttribute처럼 동작
	@GetMapping("/test")
	public void test(@ModelAttribute("age") int age, Model model) {
//		model.addAttribute("age", age); 할필요없이 모델에 넣어짐
		model.addAttribute("nick","멍멍이");
	}
	
	@GetMapping("/test2")
	public void test2(@ModelAttribute("info") UserVO vo) {
		System.out.println("메서드 내의 콘솔 출력:" + vo);
	}
	
}
