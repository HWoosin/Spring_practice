package com.spring.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.db.model.BoardVO;
import com.spring.db.repository.IBoardDAO;
import com.spring.db.repository.IBoardMapper;

@Service
public class BoardService implements IBoardService {
	
//	@Autowired
//	private IBoardDAO dao;
	
	@Autowired
	private IBoardMapper mapper;

	@Override
	public void insertArticle(BoardVO vo) {
		System.out.println("service 한 vo 값:" + vo);
//		dao.insertArticle(vo);
		mapper.insertArticle(vo);
	}

	@Override
	public List<BoardVO> getArticles() {
		System.out.println("게시물 가져옴");		
//		return dao.getArticles();
		return mapper.getArticles();
	}

	@Override
	public BoardVO getArticle(int bno) {
		System.out.println("게시물 상세보기");
//		return dao.getArticle(bno); 
		return mapper.getArticle(bno);
	}

	@Override
	public void deleteArticle(int bno) {
		System.out.println("게시물 지우기");
//		dao.deleteArticle(bno);
		mapper.deleteArticle(bno);
	}

	@Override
	public void updateArticle(BoardVO vo) {
//		dao.updateArticle(vo);
		mapper.updateArticle(vo);
	}

}
