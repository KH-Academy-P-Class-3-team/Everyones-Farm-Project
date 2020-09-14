package com.kh.farmapp.farmpersonalpage.farmdiary.model.service;


import java.util.Map;

import common.dto.FarmDiary;
import common.dto.Farmer;

public interface FarmDiaryService  {
	
	//게시글 목록 조회
	public Map<String, Object> selectFarmDiaryList(int currentPage, int cntPerPage, String farmerNo);

	//게시물 상세 조회
	public FarmDiary selectFarmDiaryDetail(int dailyNo);
	
	//글쓰기
	public void writeFarmDiary(Map<String, Object> commandMap);
	
<<<<<<< HEAD
=======
	//게시글 조회수 증가 메소드
	public int updateFarmDiaryHits(int hits);
	
	//파일업로드
//	public int insertFarmdiaryFile(FarmDiary farmdiary, List<MultipartFile> files, String root) throws Exception;

>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
	//삭제
	public int deleteFarmDiary();
	
	//수정
<<<<<<< HEAD
	public int modifyFarmDiary();
=======
	public int modifyFarmDiary(Map<String, Object> commandMap);

	/**
	 * farmerNo 로 farmNo 조회
	 *  
	 * @param farmerNo - 농업인 사용자 번호
	 * @return int - 조회 결과 반환
	 */
	public int selectFarmNoByFarmerNo(String farmerNo);

>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
}
