package com.kh.farmapp.mypage.farmer.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.dto.Application;
import common.dto.FarmActivity;
import common.dto.FarmingDailylog;
import common.dto.page.Criteria;

@Repository
public class FarmerMypageDaoImpl implements FarmerMypageDao {

	@Autowired
	SqlSessionTemplate session;
	
	// 영농일지 목록조회
	@Override
	public List<FarmingDailylog> dailyLoglist(Criteria cri) {
		return session.selectList("DAILY.listPage",cri);
	}

	// 영농일지 총 갯수
	@Override
	public int listCount() {
		return session.selectOne("DAILY.listCount");
	}

	// 영농일지 작성
	@Override
	public void writeDailylog(FarmingDailylog farmingDailylog) {
		session.insert("DAILY.insertFarmdaily", farmingDailylog);
	}
	
	@Override
	public List<Map<String, Object>> activitylist(Criteria cri) {
//		System.out.println(session.selectList("ACTIVITY.listPage",cri));
		return session.selectList("ACTIVITY.listPage",cri);
	}
	// 영농일지 총 갯수
	@Override
	public int listCount2() {
		return session.selectOne("ACTIVITY.listCount");
	}
	
	@Override
	public int updateIsApproval(Application application) {
		return session.update("ACTIVITY.update",application);
	}

	@Override
	public Application selectOne(Application application) {
		System.out.println(application);
		return session.selectOne("ACTIVITY.selectOne",application);
	}
	
}
