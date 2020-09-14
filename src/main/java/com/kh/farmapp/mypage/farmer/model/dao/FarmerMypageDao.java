package com.kh.farmapp.mypage.farmer.model.dao;

import java.util.List;
import java.util.Map;

import common.dto.Application;
import common.dto.FarmingDailylog;
import common.dto.page.Criteria;

public interface FarmerMypageDao {

	/**
	 * 최근 농업인이 작성 한 농업인들의  영농일지 목록 조회(전체 목록)
	 * list(Criteria cri)+ 페이징 처리 
	 * @return List<FarmingDailylog> - 조회 결과 반환
	 */
	public List<FarmingDailylog> dailyLoglist(Criteria cri);
	
	/**
	 * 영농일지 목록 페이징
	 * @return 페이지 총 갯 수
	 */
	public int listCount();
	
	/**
	 * 영농일지 작성 
	 * @param FarmingDailylog 영농일지 작성하기
	 */
	public void writeDailylog(FarmingDailylog farmingDailylog);

	
	
	/**
	 * 최근 일반 고객들의 활동 신청 내역 리스트 조회(전체목록)
	 * @param list(Criteria cri)+ 페이징 처리 
	 * @return List<FarmActivity> - 조회 결과 반환
	 */
	public List<Map<String, Object>> activitylist(Criteria cri);
	
	/**
	 * 활동내역 목록 페이징
	 * @return 페이지 총 갯 수
	 */
	public int listCount2();
	
	
	public int updateIsApproval(Application application);

	public Application selectOne(Application application);
	
}
