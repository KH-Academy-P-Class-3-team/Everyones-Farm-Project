package com.kh.farmapp.farmpersonalpage.farmQnA.model.service;

import java.util.List;
import java.util.Map;

import common.dto.FarmQnaAnswer;

public interface FarmQnAService {

	//게시글 목록 조회
	public Map<String, Object> selectFarmQnAList(int currentPage, int cntPerPage, String farmerNo);

	//게시물 상세 조회
	public Map<String, Object> selectQnADetail(int farmQnaQuestionNo);

	//글쓰기
	public void writeFarmQnA(Map<String, Object> commandMap);

	//삭제
	public int deleteQnA(int farmQnaQuestionNo);

	//수정
	public int modifyQnA(Map<String, Object> commandMap);
	
	//farmerNo를 통한 farmNo 조회
	public int selectFarmNoByFarmerNo2(String farmerNo);
	
	//QnA 답변 작성
	public void writeAnswer(FarmQnaAnswer farmqnaAnswer);
	
	//farmQnaQuestionNo번호로 Qna 답변 리스트 조회
	public List<FarmQnaAnswer> selectAnswerList(int farmQnaQuestionNo);

}
