package com.kh.farmapp.farmpersonalpage.farmQnA.model.service;

import java.util.Map;

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
	
	//QnA 답변 글쓰기
	public void writeFarmQnAanswer(Map<String, Object> commandMap);
	
	//farmerNo를 통한 farmNo 조회
	public int selectFarmNoByFarmerNo(String farmerNo);

}
