package com.kh.farmapp.main.model.dao;

import java.util.List;
import java.util.Map;

import common.dto.Application;
import common.dto.Farm;
import common.dto.FarmNews;
import common.dto.Product;

/**
 * Main 화면에 대한 dao interface
 */
public interface MainDao {

	/**
	 * 메인 화면에 보여줄 제철 먹거리 상품 조회한다.
	 * 제철 먹거리 인기 판매순으로 3가지만 조회한다.
	 * @return List<Map<String, Object>> - 조회 결과 반환
	 */
	public List<Map<String, Object>> selectTop3SeasonalFood();

	/**
	 * 메인 화면에 보여줄 이달의 농장 Top3를 조회한다.
	 * @return List<Farm> - 조회 결과 반환
	 */
	public List<Map<String, Object>> selectTop3Farm();

	/**
	 * 메인 화면에 보여줄 농업소식 게시판의 최신글 5개를 조회 한다.
	 * @return List<FarmNews> - 조회 결과 반환
	 */
	public List<FarmNews> selectLatestFarmNews();

	/**
	 * 조인 연산을 위한 테스트 method
	 * 
	 * @param testA
	 * @return
	 */
	public List<Map<String, Object>> selectTest();

	/**
	 * 검색어로 제철 먹거리 검색
	 * 
	 * @param search - 검색어
	 * @return List<Map<String, Object>> - 조회 결과
	 */
	public List<Map<String, Object>> selectSeasonalFoodBySearch(String search);

	/**
	 * 검색어로 일반 먹거리 검색
	 * 
	 * @param search - 검색어
	 * @return List<Map<String, Object>> - 검색 결과 반환
	 */
	public List<Map<String, Object>> selectGeneralFoodBySearch(String search);

	/**
	 * 검색어로 농장 검색
	 * 
	 * @param search - 검색어
	 * @return List<Map<String, Object>> - 검색 결과 반환
	 */
	public List<Map<String, Object>> selectFarmBySearch(String search);

	/**
	 * 검색어로 체험 검색
	 * 
	 * @param search - 검색어
	 * @return List<Map<String, Object>> - 검색 결과 반환
	 */
	public List<Map<String, Object>> selectActivityBySearch(String search);

}
