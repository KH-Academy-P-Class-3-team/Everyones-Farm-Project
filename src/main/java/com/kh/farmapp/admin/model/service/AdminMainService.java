package com.kh.farmapp.admin.model.service;

import java.util.List;
import java.util.Map;

/**
 * 관리자 페이지 중 메인 페이지의 Service interface
 */
public interface AdminMainService {

	/**
	 * 최근 농업인 회원가입 신청을 한 농업인들의 목록 조회 요청 (최근 5명 정도까지만 보여준다.)
	 * @return List<Map<String, Object>> - 조회 결과 반환
	 */
	public List<Map<String, Object>> selectLatestFarmerApplicationList();
	
	/**
	 * 최근 1대1문의 목록 조회 요청
	 * 
	 * @return List<Map<String, Object>> - 조회 결과 반환
	 */
	public List<Map<String, Object>> selectLatestQuestionList();
}
