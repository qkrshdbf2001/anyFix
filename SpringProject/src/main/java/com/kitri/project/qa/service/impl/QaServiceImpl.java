package com.kitri.project.qa.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.kitri.project.qa.service.QaService;
import com.kitri.project.qa.web.Qa;

@Service("qaService")
public class QaServiceImpl implements QaService{
	@Resource(name = "sqlSession")
	private SqlSession sqlSession;
	private QaMapper qaMapper;
	
	@Override
	public ArrayList<Qa> selectQaList() {
		qaMapper = sqlSession.getMapper(QaMapper.class);
		return qaMapper.selectQaList();
	}
	
	@Override
	public Qa selectQa(int q_num) {
		qaMapper = sqlSession.getMapper(QaMapper.class);
		return qaMapper.selectQa(q_num);
	}
	
	@Override
	public void insertQa(Qa q) {
		qaMapper = sqlSession.getMapper(QaMapper.class);
		qaMapper.insertQa(q);
	}

	@Override
	public void updateQa(Qa q) {
		qaMapper = sqlSession.getMapper(QaMapper.class);
		qaMapper.updateQa(q);
	}

	@Override
	public void deleteQa(int q_num) {
		qaMapper = sqlSession.getMapper(QaMapper.class);
		qaMapper.deleteQa(q_num);
	}
}
