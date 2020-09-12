package com.kh.farmapp.admin.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import common.dto.Notice;
import common.util.AdminPaging;

/**
 * 관리자 페이지 중 공지사항&자주 묻는 질문 관리 페이지의 Dao interface
 */
public interface AdminNoticeDao {

	/**
	 * 공지사항 목록 조회
	 * @return List<Notice> - 조회 결과 반환
	 */
	public List<Map<String, Object>> selectAllNoticeList();

	/**
	 * 공지사항 번호를 통해 특정 공지사항 조회
	 * @param noticeNo - 조회할 공지사항 번호를 갖는 Map
	 * @return Notice - 조회 결과 반환
	 */
	public Map<String, Object> selectNoticeByNoticeNo(Notice noticeNo);

	/**
	 * 공지사항 삽입
	 * @param notice - 공지사항 작성 정보를 저장하고 있는 Notice 객체
	 * @return int - 작성 결과(insert 결과)
	 */
	public int insertNotice(Notice notice);

	/**
	 * 공지사항 삭제
	 * @param noticeNoList - 공지사항 번호 정보를 갖는 List<String>
	 * @return int - 삭제 결과
	 */
	public int deleteNoticeByNoticeNo(List<Object> noticeNoList);

	/**
	 * 공지사항 테이블의 모든 행을 조회
	 * 
	 * @return int - 조회된 결과 반환
	 */
	public int selectCntAllNotice();

	/**
	 * 페이징 정보를 통해 공지사항 목록 조회하기
	 * 
	 * @param apaging - 페이징 정보를 갖는 AdminPaging 객체
	 * @return List<Map<String, Object>> - 조회된 결과 반환 객체
	 */
	public List<Map<String, Object>> selectNoticeByAPaging(AdminPaging apaging);

	/**
	 * 글의 번호를 미리 조회
	 * 
	 * @return - String 조회 결과 반환
	 */
	public String selectPostNo();

}
