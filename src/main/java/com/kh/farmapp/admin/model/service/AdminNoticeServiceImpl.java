package com.kh.farmapp.admin.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.farmapp.admin.model.dao.AdminNoticeDao;

import common.dto.Admin;
import common.dto.Notice;
import common.util.AdminPaging;


/**
 * AdminNoticeService 를 상속 받는 클래스
 * AdminNoticeService 를 구현 하는 클래스
 */
@Service
public class AdminNoticeServiceImpl implements AdminNoticeService {

	// dao
	@Autowired
	private AdminNoticeDao adminNoticeDao;

	// 공지사항 목록 조회
	@Override
	public List<Map<String, Object>> selectAllNoticeList() {
		return adminNoticeDao.selectAllNoticeList();
	}

	// 공지사항 번호를 통해 특정 공지사항 조회
	@Override
	public Map<String, Object> selectNoticeByNoticNo(Notice noticeNo) {
		return adminNoticeDao.selectNoticeByNoticeNo(noticeNo);
	}

	// 공지사항 작성
	@Override
	public int writeNotice(Notice notice) {
		return adminNoticeDao.insertNotice(notice);
	}

	// 공지사항 삭제
	@Override
	public int deleteNoticeByNoticeNo(List<Object> noticeNoList) {
		return adminNoticeDao.deleteNoticeByNoticeNo(noticeNoList);
	}
	
	// 페이징 설정
	@Override
	public AdminPaging getPaging(String curPage) {

		// curPageNo 초기화, curPageNo 은 현재 페이지 번호를 뜻함!
		int curPageNo = 0;
		if( curPage != null && !"".equals(curPage) ) {
			curPageNo = Integer.parseInt(curPage);
		}
		
		// NOTICE 테이블의 총 게시글 수를 조회한다.
		int totalCount = adminNoticeDao.selectCntAllNotice();
		
		// AdminPaging 객체 생성 - 현재 페이지(curPage), 총 게시글 수(totalCount) 활용
		AdminPaging paging = new AdminPaging(totalCount, curPageNo);
		
		return paging;
	}
	
	// 페이징 정보로 공지사항 목록 조회
	@Override
	public List<Map<String, Object>> selectNoticeByAPaging(AdminPaging apaging) {
		return adminNoticeDao.selectNoticeByAPaging(apaging);
	}

	// 글의 번호를 미리 조회
	@Override
	public String selectPostNo() {
		return adminNoticeDao.selectPostNo();
	}

}
