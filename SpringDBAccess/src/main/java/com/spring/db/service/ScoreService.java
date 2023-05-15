package com.spring.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.db.model.ScoreVO;
import com.spring.db.repository.IScoreDAO;
import com.spring.db.repository.IScoreMapper;

@Service
public class ScoreService implements IScoreService {

//	@Autowired
//	private IScoreDAO dao;
	@Autowired
	private IScoreMapper mapper;
	
	@Override
	public void insertScore(ScoreVO vo) {
		vo.calcData();
		System.out.println("service : " + vo);
//		dao.insertScore(vo);
		mapper.insertScore(vo);
	}

	@Override
	public List<ScoreVO> selectAllScores() {
//		return dao.selectAllScores();
		return mapper.selectAllScores();
	}

	@Override
	public void deleteScore(int num) {
//		dao.deleteScore(num);
		mapper.deleteScore(num);
	}

	@Override
	public ScoreVO selectOne(int num) {
//		return dao.selectOne(num);
		return mapper.selectOne(num);
	}

}
