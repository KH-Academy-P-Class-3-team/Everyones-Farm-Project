package com.kh.farmapp.farmpersonalpage.farmQnA.model.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import common.dto.FarmDiary;
import common.util.Paging;


public interface FarmQnADao {

	//게시글 삽입
	public int insertFarmQnA(Map<String, Object> commandMap);

	//게시글 목록 메소드
	public List<FarmDiary> selectFarmQnAList(Paging paging);

	//게시글 숫자
	public int contentCnt();

	//게시글 상세 조회 메소드
	public Map<String, Object> selectFarmQnADetail(int farmQnaQuestionNo);

	//게시글 삭제 메소드
	public int deleteQnA(int farmQnaQuestionNo);
}
