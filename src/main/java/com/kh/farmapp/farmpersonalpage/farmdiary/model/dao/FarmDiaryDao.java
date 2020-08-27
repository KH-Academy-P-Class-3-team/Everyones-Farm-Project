package com.kh.farmapp.farmpersonalpage.farmdiary.model.dao;

import java.util.List;
import java.util.Map;

import common.dto.FarmDiary;
import common.util.Paging;


public interface FarmDiaryDao {
		
	// ** 나중에 상세 페이지 조회도 만들었으면 좋겠어요~~~
	
	//게시글 삽입 메소드
	public int insertFarmDiary(Map<String, Object> commandMap);
	
	//게시글 조회수 증가 메소드
//	public void updateHit(FarmDiary hit);
		
	//게시글 목록 메소드
	public List<FarmDiary> selectFarmDiaryList(Paging paging);
	
	//게시글 상세 조회 메소드
	public Map<String, Object> selectFarmDiaryDetail(int farmDiaryNo);
	
	//게시글 숫자
	public int contentCnt();
	
	//게시글 삭제 메소드
	public int deleteFarmDiary();
	
	//게시글 수정 메소드
	public int modifyFarmDiary();



	
}
