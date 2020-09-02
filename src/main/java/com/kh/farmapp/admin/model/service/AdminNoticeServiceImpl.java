package com.kh.farmapp.admin.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.farmapp.admin.model.dao.AdminNoticeDao;

import common.dto.Notice;


/**
 * AdminNoticeService 를 상속 받는 클래스
 * AdminNoticeService 를 구현 하는 클래스
 */
@Service
public class AdminNoticeServiceImpl implements AdminNoticeService {

	// dao
	@Autowired
	private AdminNoticeDao adminNoticeDao;

	@Override
	public List<Map<String, Object>> selectAllNoticeList() {
		return adminNoticeDao.selectAllNoticeList();
	}

	// 공지사항 번호를 통해 특정 공지사항 조회
	@Override
	public Notice selectNoticeByNoticNo(Notice noticeNo) {
		return adminNoticeDao.selectNoticeByNoticeNo(noticeNo);
	}

	// 공지사항 작성
	@Override
	public int writeNotice(Notice notice) {
		return adminNoticeDao.insertNotice(notice);
	}

	// 공지사항 삭제
	@Override
	public int deleteNoticeByNoticeNo(Notice noticeNo) {
		return adminNoticeDao.deleteNoticeByNoticeNo(noticeNo);
	}

}
