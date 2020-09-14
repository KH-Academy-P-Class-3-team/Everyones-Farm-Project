package com.kh.farmapp.admin.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.dto.Notice;
import common.util.AdminPaging;

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
	public Map<String, Object> selectNoticeByNoticeNo(Notice noticeNo) {
		return session.selectOne("ADMINNOTICE.selectNoticeByNoticeNo", noticeNo);
	}

	// 공지사항 insert
	@Override
	public int insertNotice(Notice notice) {
		return session.insert("ADMINNOTICE.insertNotice", notice);
	}

	@Override
	public int deleteNoticeByNoticeNo(Notice noticeNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	// NOTICE 테이블의 모든 행 count 조회
	@Override
	public int selectCntAllNotice() {
		return session.selectOne("ADMINNOTICE.selectCntAllNotice");
	}
	
	// 페이징 정보로 Notice 목록 조회
	@Override
	public List<Map<String, Object>> selectNoticeByAPaging(AdminPaging apaging) {
		return session.selectList("ADMINNOTICE.selectNoticeByAPaging", apaging);
	}

	// 작성될 글의 번호를 미리 조회
	@Override
	public String selectPostNo() {
		return session.selectOne("ADMINNOTICE.selectPostNo");
	}
}
