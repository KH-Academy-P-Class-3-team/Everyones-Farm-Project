package com.kh.farmapp.notice.model.service;

import java.util.List;

import common.dto.Notice;

/**
 * 공지사항 & 자주묻는질문 페이지에 대한 Service
 *
 */
public interface NoticeService {

	/**
	 * 가장 최근 공지사항 하나를 조회 요청
	 * @return Notice - 조회 결과 반환
	 */
	public Notice selectOneNotice();
}
