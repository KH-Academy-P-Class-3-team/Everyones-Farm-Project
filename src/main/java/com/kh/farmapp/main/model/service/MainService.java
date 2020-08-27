package com.kh.farmapp.main.model.service;

import java.util.List;
import java.util.Map;

import common.dto.Application;
import common.dto.Farm;
import common.dto.FarmNews;
import common.dto.Product;

/**
 * 메인 화면에 대한 Service interface
 */
public interface MainService {

	/**
	 * 메인 화면에 보여줄 제철 먹거리 상품 조회 요청
	 * 제철 먹거리 인기 판매순으로 3가지만 조회한다.
	 * @return List<Product> - 조회 결과 반환
	 */
	public List<Product> selectTop3SeasonalFood();
	
	/**
	 * 메인 화면에 보여줄 이달의 농장 Top3를 조회 요청
	 * @return List<Farm> - 조회 결과 반환
	 */
	public List<Map<String, Object>> selectTop3Farm();
	
	/**
	 * 메인 화면에 보여줄 농업소식 게시판의 최신글 5개를 조회 요청
	 * @return List<FarmNews> - 조회 결과 반환
	 */
	public List<FarmNews> selectLatestFarmNews();

	/**
	 * 조인을 위한 테스트 method
	 * 
	 * @return
	 */
	public List<Map<String, Object>> selectTest();
	
}
