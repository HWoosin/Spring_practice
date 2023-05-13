package com.spring.db.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.db.model.BoardVO;

/*
 create table jdbc_board(
   board_no int primary key auto_increment,
    writer varchar(30) not null,
    title varchar(100) not null,
    content varchar(2000),
    reg_date datetime default current_timestamp
);
 */
@Repository
public class BoardDAO implements IBoardDAO {
	
	class BoardStack implements RowMapper<BoardVO>{
		@Override
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			BoardVO vo = new BoardVO(
					rs.getInt("board_no"),
					rs.getString("writer"),
					rs.getString("title"),
					rs.getString("content"),
					null
					);
			return vo;
		}
	}

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public void insertArticle(BoardVO vo) {
		String sql = "Insert into jdbc_board (writer,title,content) values(?,?,?)";
		template.update(sql,vo.getWriter(),vo.getTitle(),vo.getContent());
	}

	@Override
	public List<BoardVO> getArticles() {
		String sql = "Select * from jdbc_board order by board_no desc";
		List<BoardVO> allBoardList = template.query(sql, new BoardStack());
		return allBoardList;
	}

	@Override
	public BoardVO getArticle(int bno) {
		String sql = "Select * from jdbc_board where board_no = ?";
		return template.queryForObject(sql, new BoardStack(), bno);
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
