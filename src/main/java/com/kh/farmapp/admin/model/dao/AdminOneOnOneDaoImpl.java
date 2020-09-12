package com.kh.farmapp.admin.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.dto.AnsweredOneonone;
import common.dto.Farmer;
import common.dto.QuestionOneonone;
import common.dto.UserTB;
import common.util.AdminPaging;

/**
 * AdminOneOnOneDao 를 상속 받는 클래스
 * AdminOneOnOneDao 구현 하는 클래스
 */
@Repository
public class AdminOneOnOneDaoImpl implements AdminOneOnOneDao{

	@Autowired
	SqlSessionTemplate session;
	
	// 일반 회원 일대일 문의 목록 조회
	@Override
	public List<Map<String, Object>> selectAllUserOneOnOneList(AdminPaging apaging) {
		return session.selectList("ADMINONEONONE.selectAllUserOneOnOneList", apaging);
	}

	// 농업인 회원 일대일 문의 목록 조회
	@Override
	public List<Map<String, Object>> selectAllFarmerOneOnOneList(AdminPaging apaging) {
		return session.selectList("ADMINONEONONE.selectAllFarmerOneOnOneList", apaging);
	}

	// 일반 회원의 문의 글 상세 조회
	@Override
	public Map<String, Object> selectUserOneOnOneByNo(QuestionOneonone qNo) {
		return session.selectOne("ADMINONEONONE.selectUserOneOnOneByNo", qNo);
	}

	@Override
	public List<Map<String, Object>> selectFarmerOneOnOneByNo(QuestionOneonone qNo) {
		
		// 클래스 다이어그램 용 객체
		QuestionOneonone q = new QuestionOneonone();
		AnsweredOneonone a = new AnsweredOneonone();
		Farmer farmer = new Farmer();
		
		return null;
	}

	// 답변 작성
	@Override
	public int insertAnswerToUser(AnsweredOneonone a) {
		return session.insert("ADMINONEONONE.insertAnswerToUser", a);
	}

	@Override
	public int insertAnswerToFarmer(AnsweredOneonone a) {
		
		return 0;
	}

	// 답변 수정
	@Override
	public int updateAnswer(AnsweredOneonone a) {
		return session.update("ADMINONEONONE.updateAnswertToUser", a);
	}

	@Override
	public int updateAnswerToFarmer(AnsweredOneonone a) {
		return 0;
	}

	// 일반 회원 문의 글 총 갯수 조회
	@Override
	public int selectCntAllUserOneOnOne(String search) {
		return session.selectOne("ADMINONEONONE.selectCntAllUserOneOnOne", search);
	}
	
	// 답변 조회
	@Override
	public Map<String, Object> selectAnswerOneOnOneByQuestionNo(QuestionOneonone q) {
		return session.selectOne("ADMINONEONONE.selectAnswerOneOnOneByQuestionNo", q);
	}

	// 답변 삭제
	@Override
	public int deleteAnswer(AnsweredOneonone deleteAnswer) {
		return session.delete("ADMINONEONONE.deleteAnswer", deleteAnswer);
	}
	
	// 답변 상태 업데이트
	@Override
	public int updateAnswerStateByQuestionNo(AnsweredOneonone answer) {
		return session.update("ADMINONEONONE.updateAnswerStateByQuestionNo", answer);
	}

	// 답변 상태 업데이트 - 답변 대기로
	@Override
	public int updateWaitAnswerByQuestionNo(AnsweredOneonone deleteAnswer) {
		return session.update("ADMINONEONONE.updateWaitAnswerByQuestionNo", deleteAnswer);
	}

	// 농업인 회원의 문의글 갯수 조회
	@Override
	public int selectCntAllFarmerOneOnOne(String search) {
		return session.selectOne("ADMINONEONONE.", search);
	}
	
}
