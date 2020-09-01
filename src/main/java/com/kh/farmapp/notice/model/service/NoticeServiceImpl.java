package com.kh.farmapp.notice.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.farmapp.notice.model.dao.NoticeDao;

import common.dto.Notice;

/**
 * NoticeService 를 상속받는 클래스
 * NoticeSerivce 구현 클래스
 *
 */
@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public Notice selectOneNotice() {
		return noticeDao.selectOneNotice();
	}
	
}
