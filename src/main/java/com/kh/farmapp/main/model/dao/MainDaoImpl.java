package com.kh.farmapp.main.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.dto.Application;
import common.dto.Farm;
import common.dto.FarmNews;
import common.dto.Product;

/**
 * MainDao 를 상속받는 클래스
 * Dao 구현 클래스
 */
@Repository
public class MainDaoImpl implements MainDao {
	
	@Autowired
	private SqlSessionTemplate session;

	// 제철 먹거리 top3 조회
	@Override
	public List<Map<String, Object>> selectTop3SeasonalFood() {
		return session.selectList("MAIN.selectTop3SeasonalFood");
	}
	
	@Override
	public List<Map<String, Object>> selectTop3Farm() {
		return session.selectList("MAIN.selectFarmTop3");
	}

	@Override
	public List<FarmNews> selectLatestFarmNews() {
		return null;
	}
	
	@Override
	public List<Map<String, Object>> selectTest() {
		return session.selectList("TEST.testSelect");
	}
	
	// 검색어로 제철 먹거리 검색
	@Override
	public List<Map<String, Object>> selectSeasonalFoodBySearch(String search) {
		return null;
	}
	
	// 검색어로 일반 먹거리 검색
	@Override
	public List<Map<String, Object>> selectGeneralFoodBySearch(String search) {
		return null;
	}

	// 검색어로 농장 검색
	@Override
	public List<Map<String, Object>> selectFarmBySearch(String search) {
		return null;
	}

	// 검색어로 체험 검색
	@Override
	public List<Map<String, Object>> selectActivityBySearch(String search) {
		return null;
	}

}
