package com.kh.farmapp.main.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.farmapp.main.model.dao.MainDao;

import common.dto.Application;
import common.dto.Farm;
import common.dto.FarmNews;
import common.dto.Product;
/**
 * MainService 를 상속 받는 클래스
 * Service 구현 클래스
 */
@Service
public class MainServiceImpl implements MainService{

	@Autowired
	private MainDao mainDao;

	// 제철 먹거리 top3 조회
	@Override
	public List<Map<String, Object>> selectTop3SeasonalFood() {
		return mainDao.selectTop3SeasonalFood();
	}

	@Override
	public List<Map<String, Object>> selectTop3Farm() {
		return mainDao.selectTop3Farm();
	}

	@Override
	public List<FarmNews> selectLatestFarmNews() {
		return mainDao.selectLatestFarmNews();
	}
	
	@Override
	public List<Map<String, Object>> selectTest() {
		return mainDao.selectTest();
	}
	
	// 검색어로 제철 먹거리 검색
	@Override
	public List<Map<String, Object>> selectSeasonalFoodBySearch(String search) {
		return mainDao.selectSeasonalFoodBySearch(search);
	}
	
	// 검색어로 일반 먹거리 검색
	@Override
	public List<Map<String, Object>> selectGeneralFoodBySearch(String search) {
		return mainDao.selectGeneralFoodBySearch(search);
	}
	

	// 검색어로 농장 검색
	@Override
	public List<Map<String, Object>> selectFarmBySearch(String search) {
		return mainDao.selectFarmBySearch(search);
	}

	// 검색어로 체험 검색
	@Override
	public List<Map<String, Object>> selectActivityBySearch(String search) {
		return mainDao.selectActivityBySearch(search);
	}
}
