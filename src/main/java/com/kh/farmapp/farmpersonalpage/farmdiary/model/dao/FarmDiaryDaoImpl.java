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

		return sqlSession.selectList("Diary.selectFarmDiaryList", paging);
	}
	
	@Override
	public Map<String, Object> selectFarmDiaryDetail(int farmDiaryNo) {
		return sqlSession.selectOne("Diary.selectFarmDiaryDetail", farmDiaryNo);
	}

	@Override
	public int contentCnt() {
		int cnt = sqlSession.selectOne("Diary.selectContentCnt");
		return cnt;
	}

	@Override
	public int deleteFarmDiary() {
		return 0;
	}

	@Override
	public int modifyFarmDiary() {
		return 0;
	}


}
