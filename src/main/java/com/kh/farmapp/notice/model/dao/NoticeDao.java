package com.kh.farmapp.notice.model.dao;

import java.util.List;

import common.dto.Notice;

/**
 * 공지사항 & 자주묻는질문 페이지의 Dao interface
 */
public interface NoticeDao {

	/**
	 * 가장 최근 공지사항 하나를 조회 한다.
	 * @return Notice - 조회 결과 반환
	 */
	public Notice selectOneNotice();

}
