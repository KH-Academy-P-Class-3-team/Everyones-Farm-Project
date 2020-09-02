package com.kh.farmapp.admin.model.service;

import java.util.List;
import java.util.Map;

import common.dto.Notice;


/**
 * 관리자 페이지 중 공지사항&자주묻는질문 관리 Service interface
 */
public interface AdminNoticeService {
	
	/**
	 * 공지사항 목록 조회
	 * @return List<Notice> - 조회 결과 반환
	 */
	public List<Map<String, Object>> selectAllNoticeList();
	
	
	/**
	 * 공지사항 번호를 통해 특정 공지사항 조회
	 * @param noticeNo - 조회할 공지사항 번호를 갖는 Notice 객체
	 * @return Notice - 조회 결과 반환
	 */
	public Notice selectNoticeByNoticNo(Notice noticeNo);
	
	
	/**
	 * 공지사항 작성
	 * @param notice - 공지사항 작성 정보를 저장하고 있는 Notice 객체
	 * @return int - 작성 결과(insert 결과)
	 */
	public int writeNotice(Notice notice);
	
	/**
	 * 공지사항 삭제
	 * @param noticeNo - 공지사항 번호 정보를 갖는 Notice 객체
	 * @return int - 삭제 결과
	 */
	public int deleteNoticeByNoticeNo(Notice noticeNo);
	
}
