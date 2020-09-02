package com.kh.farmapp.admin.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.dto.Notice;

/**
 * AdminNoticeDao 를 상속 받는 클래스
 * AdminNoticeDao 를 구현 하는 클래스
 */
@Repository
public class AdminNoticeDaoImpl implements AdminNoticeDao{

	@Autowired
	private SqlSessionTemplate session;
	
	// 공지사항 목록 조회
	@Override
	public List<Map<String, Object>> selectAllNoticeList() {
		return session.selectList("ADMINNOTICE.selectAllNotice");
	}

	// 공지사항 번호를 통해 특정 공지사항 조회
	@Override
	public Notice selectNoticeByNoticeNo(Notice noticeNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertNotice(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteNoticeByNoticeNo(Notice noticeNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
