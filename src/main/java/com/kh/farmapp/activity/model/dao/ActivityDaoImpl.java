package com.kh.farmapp.activity.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.dto.Application;
import common.dto.Farm;
import common.dto.FarmActivity;
import common.dto.FarmActivityFile;
import common.dto.FarmActivitySchedule;
import common.dto.Farmer;
import common.util.Paging;

@Repository
public class ActivityDaoImpl implements ActivityDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<FarmActivity> selectActivityList(Map<String, Object> map) {
		return sqlSession.selectList("ACTIVITY.selectActivityList", map);
	}

	@Override
	public List<FarmActivityFile> selectActivityFileThumbnail() {
		return sqlSession.selectList("ACTIVITY.selectActivityFileThumbnail");
	}

	@Override
	public FarmActivity selectActivityDetail(int activityNo) {
		
		// 클래스 다이어그램 용 객체 선언
		Farm farm = new Farm();
		
		return null;
	}

	@Override
	public List<Map<String, String>> selectFileWithActivity(int activityNo) {
		return null;
	}

	@Override
	public List<FarmActivity> selectActivityByTitle(Map<String, Object> map) {
		return sqlSession.selectList("ACTIVITY.selectActivityByTitle", map);
	}
	
	@Override
	public int selectActivityByTitleCnt(Map<String, Object> map) {
		return sqlSession.selectOne("ACTIVITY.selectActivityByTitleCnt", map);
	}

	@Override
	public int insertApplication(Application application) {
		return 0;
	}

	@Override
	public int insertActivity(FarmActivity farmActivity) {
		return sqlSession.insert("ACTIVITY.insertActivity", farmActivity);
	}

	@Override
	public Farm selectFarmByFarmerNo(Farmer farmer) {
		return sqlSession.selectOne("ACTIVITY.selectFarmByFarmerNo", farmer);
	}

	@Override
	public List<FarmActivity> selectActivityListByFarmNo(Farm farm) {
		return sqlSession.selectList("ACTIVITY.selectActivityListByFarmNo", farm);
	}

	@Override
	public int insertFile(FarmActivityFile activityFile) {
		return sqlSession.insert("ACTIVITY.insertActivityFile", activityFile);
	}

	@Override
	public int insertActivitySchedule(FarmActivitySchedule schedule) {
		return sqlSession.insert("ACTIVITY.insertActivitySchedule", schedule);
	}

	@Override
	public int selectActivityCnt(int isHelp) {
		return sqlSession.selectOne("ACTIVITY.selectActivityCnt", isHelp);
	}

	@Override
	public List<Farm> selectFarmList() {
		return sqlSession.selectList("ACTIVITY.selectFarmList");
	}

	@Override
	public List<FarmActivity> selectActivityByFarmName(Map<String, Object> map) {
		return sqlSession.selectList("ACTIVITY.selectActivityByFarmName", map);
	}

	@Override
	public int selectActivityByFarmNameCnt(Map<String, Object> map) {
		return sqlSession.selectOne("ACTIVITY.selectActivityByFarmNameCnt", map);
	}



	
	
}
