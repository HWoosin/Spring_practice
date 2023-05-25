package com.spring.myweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.myweb.command.SnsBoardVO;
import com.spring.myweb.snsboard.service.ISnsBoardService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/snsboard")
@Slf4j
public class SnsBoardController {

	@Autowired
	private ISnsBoardService service;
	
	@GetMapping("/snsList")
	public ModelAndView snsList() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("snsboard/snsList");
		return mv;
	}
	
	@PostMapping("/upload")
	public String upload(MultipartFile file, SnsBoardVO vo) {
		service.insert(vo, file);
		return "success";
		
	}
}
