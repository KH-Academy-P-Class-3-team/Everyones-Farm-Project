package com.kh.farmapp.farmpersonalpage.farmdiary.model.service;


import java.util.List;
import java.util.Map;

import javax.activation.CommandMap;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import common.dto.FarmDiary;

public interface FarmDiaryService  {
	
	//게시글 목록 조회
	public Map<String, Object> selectFarmDiaryList(//현재 페이지
													int currentPage,
													//페이지당 노출할 게시굴 수
													int cntPerPage);

	//게시물 상세 조회
	public Map<String, Object> selectFarmDiaryDetail(int farmDiaryNo);
	
	//글쓰기
	public void writeFarmDiary(Map<String, Object> commandMap);
	
	//파일업로드
//	public int insertFarmdiaryFile(FarmDiary farmdiary, List<MultipartFile> files, String root) throws Exception;

	//삭제
	public int deleteFarmDiary(int farmDiaryNo);
	
	//수정
	public int modifyFarmDiary(Map<String, Object> commandMap);

}
