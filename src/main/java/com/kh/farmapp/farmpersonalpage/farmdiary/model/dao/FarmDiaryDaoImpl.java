package com.kh.farmapp.farmpersonalpage.farmdiary.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.dto.FarmDiary;
import common.dto.FarmDiaryFile;
import common.dto.Farmer;
import common.util.Paging;

@Repository
public class FarmDiaryDaoImpl implements FarmDiaryDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertFarmDiary(Map<String, Object> commandMap) {
		return sqlSession.insert("Diary.insertFarmDiary", commandMap);
		
	}
<<<<<<< HEAD
	
//	@Override
//	public void updateHit(FarmDiary hit) {
//		
//	}

	@Override
	public List<FarmDiary> selectFarmDiaryList(Paging paging) {
		
		// 클래스 다이어그램 용 DTO 객체 선언
		Farmer farmer = new Farmer();
		FarmDiary farmDiary = new FarmDiary();
		FarmDiaryFile fdFile = new FarmDiaryFile();
		
		System.out.println(sqlSession.selectList("Diary.selectFarmDiaryList", paging));
		return sqlSession.selectList("Diary.selectFarmDiaryList", paging);
=======

	@Override
	public int updateFarmDiaryHits(int hits) {
		return sqlSession.update("Diary.updateFarmDiaryHits", hits);
	}

	@Override
	public List<FarmDiary> selectFarmDiaryList(Map<String, Object> map) {
		return sqlSession.selectList("Diary.selectFarmDiaryList", map);
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
	}
	
	@Override
	public int contentCnt() {
		int cnt = sqlSession.selectOne("Diary.selectContentCnt");
		return cnt;
	}
	
	@Override
	public FarmDiary selectFarmDiaryDetail(int farmDiaryNo) {
		return sqlSession.selectOne("Diary.selectFarmDiaryDetail", farmDiaryNo);
	}
	
	@Override
	public int deleteFarmDiary() {
		return 0;
	}

	@Override
	public int modifyFarmDiary() {
		return 0;
	}


	// farmerNo 로 farmNo 조회
	@Override
	public int selectFarmNoByFarmerNo(String farmerNo) {
		return sqlSession.selectOne("Diary.selectFarmNoByFarmerNo", farmerNo);
	}

}
