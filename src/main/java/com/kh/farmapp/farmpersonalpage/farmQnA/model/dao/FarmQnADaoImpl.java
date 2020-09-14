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
	public List<FarmQnAQuestion> selectFarmQnAList(Map<String, Object> map) {
		return sqlSession.selectList("QnA.selectFarmQnAList", map);
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
	
	@Override
	public int modifyQnA(Map<String, Object> commandMap) {
		return sqlSession.update("QnA.modifyQnA", commandMap);
	}

	@Override
	public int selectFarmNoByFarmerNo2(String farmerNo) {
		return sqlSession.selectOne("QnA.selectFarmNoByFarmerNo2", farmerNo);
	}

	@Override
	public void answerInsert(FarmQnaAnswer farmqnaAnswer) {
		sqlSession.insert("QnA.answerInsert", farmqnaAnswer);
	}

	@Override
	public List<FarmQnaAnswer> selectAnserList(int farmQnaQuestionNo) {
		return sqlSession.selectList("QnA.selectAnswerList", farmQnaQuestionNo);
	}



}
