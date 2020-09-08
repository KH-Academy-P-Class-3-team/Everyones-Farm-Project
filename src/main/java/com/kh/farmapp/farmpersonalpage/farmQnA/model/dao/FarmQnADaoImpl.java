package com.kh.farmapp.farmpersonalpage.farmQnA.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.dto.FarmDiary;
import common.dto.FarmQnAQuestion;
import common.dto.FarmQnaAnswer;
import common.dto.Farmer;
import common.dto.UserTB;
import common.util.Paging;

@Repository
public class FarmQnADaoImpl implements FarmQnADao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertFarmQnA(Map<String, Object> commandMap) {
		return sqlSession.insert("QnA.insertFarmQnA", commandMap);
	}

	@Override
	public List<FarmDiary> selectFarmQnAList(Paging paging) {
		return sqlSession.selectList("QnA.selectFarmQnAList", paging);
	}
	
	@Override
	public int contentCnt() {
		int cnt = sqlSession.selectOne("QnA.selectContentCnt");
		return cnt;
	}
	
	@Override
	public Map<String, Object> selectFarmQnADetail(int farmQnaQuestionNo) {
		return sqlSession.selectOne("QnA.selectFarmQnADetail", farmQnaQuestionNo);
	}
	
	@Override
	public int deleteQnA(int farmQnaQuestionNo) {
		return sqlSession.delete("QnA.deleteQnA", farmQnaQuestionNo);
	}



}
