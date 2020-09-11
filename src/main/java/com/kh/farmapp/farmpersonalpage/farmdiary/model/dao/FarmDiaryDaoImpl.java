package com.kh.farmapp.farmpersonalpage.farmdiary.model.dao;

import java.util.List;
import java.util.Map;

import javax.activation.CommandMap;

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
	public int deleteFarmDiary(int farmDiaryNo) {
		return sqlSession.delete("Diary.deleteFarmDiary", farmDiaryNo);
	}

	@Override
	public int modifyFarmDiary(Map<String, Object> commandMap) {
		return sqlSession.update("Diary.modifyFarmDiary", commandMap);
	}
	
	//파일 업로드
//	@Override
//	public int insertFileWithSC(Map<String, String> fileInfo) {
//		return sqlSession.insert("Diary.insertFileWithSC_N",fileInfo);
//	}
//	@Override
//	public int insertFile(Map<String, String> fileInfo) {
//		return sqlSession.insert("Diary.insertFileWithSC_N",fileInfo);
//	}



}
