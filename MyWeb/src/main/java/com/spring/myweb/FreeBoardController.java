package com.spring.myweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.myweb.command.FreeBoardVO;
import com.spring.myweb.freeboard.service.IFreeBoardService;

@Controller
@RequestMapping("/freeboard")
public class FreeBoardController {

	@Autowired
	private IFreeBoardService service;
	
	//목록 화면
	@GetMapping("/freeList")
	public void freeList(Model model) {
		model.addAttribute("boardList", service.getList());
	}
	//글 쓰기 페이지 열어주는 메서드
	@GetMapping("/regist")
	public String regist() {
		return "freeboard/freeRegist";
	}
	
	//글 등록 처리
	@PostMapping("/regist")
	public String regist(FreeBoardVO vo) {
		service.regist(vo);
		return "redirect:/freeboard/freeList";
	}
	
	//글 상세보기
	@GetMapping("/content")
	public void content(int bno, Model model) {
		model.addAttribute("boardcontent",service.getContent(bno));
		
	}
	
	//글 수정
	@PostMapping("/modify")
	public String modify(FreeBoardVO vo) {
		service.update(vo);
		return "redirect:/freeboard/content?bno="+vo.getBno();
	}
	
	//글 삭제
	@PostMapping("/delete")
	public String delete(int bno) {
		service.delete(bno);
		return "redirect:/freeboard/freeList";
	}
}













