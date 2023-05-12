package com.spring.db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.db.model.ScoreVO;
import com.spring.db.service.IScoreService;

@Controller
@RequestMapping("/score")
public class ScoreController {

	@Autowired
	private IScoreService service;
	
	//점수 등록 화면을 열어주는 처리를 하는 메서드
	@GetMapping("/register")
	public String register() {
		System.out.println("/score/register: GET");
		return "score/write-form";
	}
	
	//점수 등록 요청을 처리할 메서드
	@PostMapping("/register")
	public String register(ScoreVO vo) {
		System.out.println("/score/register: POST");
		System.out.println("vo: " +vo);
		return "/score/write-result";
	}
}
