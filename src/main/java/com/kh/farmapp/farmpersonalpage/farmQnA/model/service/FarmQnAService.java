package com.kh.farmapp.farmpersonalpage.farmQnA.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

public interface FarmQnAService {
	
	//게시글 목록 조회
	public Map<String, Object> selectFarmQnAList(//현재 페이지
													int currentPage,
													//페이지당 노출할 게시굴 수
													int cntPerPage);

	//게시물 상세 조회
	public Map<String, Object> selectQnADetail(int farmQnaQuestionNo);

	//글쓰기
	public void writeFarmQnA(Map<String, Object> commandMap);
	
	//삭제
	public int deleteFarmQnA();
	
}
