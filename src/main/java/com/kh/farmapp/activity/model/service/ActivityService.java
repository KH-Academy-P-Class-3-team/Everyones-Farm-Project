package com.kh.farmapp.activity.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import common.dto.Application;
import common.dto.Farm;
import common.dto.FarmActivity;
import common.dto.FarmActivitySchedule;
import common.dto.Farmer;

public interface ActivityService {

	/**
	 * 활동 목록 조회
	 * @param currentPage, cntPerPage - 페이징 변수
	 * @param isHelp, filter, title - 검색 조건
	 * @return Map<String, Object> - 조회된 목록, 파일, 페이징 객체를 담은 Map
	 */
	public Map<String, Object> selectActivityList(int currentPage, int cntPerPage, int isHelp, String filter, String title);
	
	/**
	 * 활동 상세보기
	 * @param activityNo - 활동 번호
	 * @return Map<String, Object> - 활동, 파일을 담은 Map
	 */
	public Map<String, Object> selectActivityDetail(int activityNo);
	
	/**
	 * 활동 신청 제출
	 * @param application - 신청 정보 객체
	 * @return int - 신청 정보 삽입 결과
	 */
	public int insertApplication(Application application);

	/**
	 * 농장 체험 활동 등록
	 * @param farmActivity - 체험 활동 객체
	 * @return int - 체험 활동 정보 삽입 결과
	 */
	public int insertActivity(FarmActivity farmActivity, List<MultipartFile> files, String root, List<FarmActivitySchedule> scheduleList);

	/**
	 * 농부 번호로 농장 정보 조회
	 * @param farmer - 농부 객체
	 * @return Farm - 조회된 농장 정보
	 */
	public Farm selectFarmByFarmerNo(Farmer farmer);

	/**
	 * 농장 번호로 체험 활동 목록 조회
	 * @param farm - 농장 객체
	 * @return Map<String, Object> - 조회된 체험 활동, 파일 리스트
	 */
	public Map<String, Object> selectActivityListByFarmNo(Farm farm);

	
	/**
	 * 농장 전체 목록 조회
	 * @return List<Farm> - 조회된 농장 목록
	 */
	public List<Farm> selectFarmList();

	
	/**
	 * 활동 번호로 체험 활동 조회
	 * @param activityNo - 활동 번호
	 * @return FarmActivity - 조회된 체험 활동 객체
	 */
	public FarmActivity selectActivityByActivityNo(int activityNo);

	
	/**
	 * 농부 사용자가 체험 활동 삭제
	 * @param activityNo - 삭제될 체험 번호
	 * @return int - 삭제 결과
	 */
	public int activityDelete(int activityNo);

	
	/**
	 * 농장 번호로 농장 조회
	 * @param farmNo
	 * @return
	 */
	public Farm selectFarmByFarmNo(int farmNo);
	
}
