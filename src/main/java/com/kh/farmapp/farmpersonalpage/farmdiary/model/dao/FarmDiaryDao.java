package com.kh.farmapp.farmpersonalpage.farmdiary.model.dao;

import java.util.List;
import java.util.Map;

import common.dto.FarmDiary;
import common.dto.Farmer;
import common.util.Paging;


public interface FarmDiaryDao {
		
	// ** 나중에 상세 페이지 조회도 만들었으면 좋겠어요~~~
	
	//게시글 삽입 메소드
	public int insertFarmDiary(Map<String, Object> commandMap);
	
	//게시글 조회수 증가 메소드
<<<<<<< HEAD
//	public void updateHit(FarmDiary hit);
		
	//게시글 목록 메소드
	public List<FarmDiary> selectFarmDiaryList(Paging paging);
=======
	public int updateFarmDiaryHits(int hits);

	//게시글 목록 메소드
	public List<FarmDiary> selectFarmDiaryList(Map<String, Object> map);
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
	
	//게시글 상세 조회 메소드
	public FarmDiary selectFarmDiaryDetail(int dailyNo);
	
	//게시글 숫자
	public int contentCnt();
	
	//게시글 삭제 메소드
<<<<<<< HEAD
	public int deleteFarmDiary();
=======
	public int deleteFarmDiary(int farmDiaryNo);

	//게시글 수정 메소드
	public int modifyFarmDiary(Map<String, Object> commandMap);

	/**
	 * farmerNo 로 farmNo 조회
	 * 
	 * @param farmerNo - 농업인 사용자 번호
	 * @return int - 조회 결과 반환
	 */
	public int selectFarmNoByFarmerNo(String farmerNo);
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
	
	//게시글 수정 메소드
	public int modifyFarmDiary();

	
}
