package com.spring.db.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.db.model.BoardVO;

@Repository
public class BoardDAO implements IBoardDAO {

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public void insertArticle(BoardVO vo) {
		String sql = "Insert into jdbc_board (writer,title,content) values(?,?,?)";
		template.update(sql,vo.getWriter(),vo.getTitle(),vo.getContent());
	}

	@Override
	public List<BoardVO> getArticles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO getArticle(int bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delteArticle(int bno) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateArticle(BoardVO vo) {
		// TODO Auto-generated method stub

	}

}
