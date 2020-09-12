package com.kh.farmapp.admin.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import common.dto.Notice;
import common.util.AdminPaging;


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
	 * @param noticeNo - 조회할 공지사항 번호를 갖는 Map
	 * @return Notice - 조회 결과 반환
	 */
	public Map<String, Object> selectNoticeByNoticNo(Notice noticeNo);
	
	
	/**
	 * 공지사항 작성
	 * @param notice - 공지사항 작성 정보를 저장하고 있는 Notice 객체
	 * @return int - 작성 결과(insert 결과)
	 */
	public int writeNotice(Notice notice);
	
	/**
	 * 공지사항 삭제
	 * @param noticeNoList - 공지사항 번호 정보를 갖는 List<String>
	 * @return int - 삭제 결과
	 */
	public int deleteNoticeByNoticeNo(List<Object> noticeNoList);


	/**
	 * 페이징 설정
	 * 
	 * @param curPage - 현재 페이지 번호(querystring 값)
	 * @return AdminPaging - 조회 결과 반환 객체
	 */
	public AdminPaging getPaging(String curPage);


	/**
	 * 페이징 처리 된 공지사항 목록 불러오기
	 * 
	 * @param apaging - 페이징 정보를 가진 AdminPaging 객체
	 * @return List<Map<String, Object>> - 조회된 결과 반환 객체
	 */
	public List<Map<String, Object>> selectNoticeByAPaging(AdminPaging apaging);


	/**
	 * 작성될 글의 번호를 미리 조회한다.
	 * 
	 * @return String - 조회 결과 반환
	 */
	public String selectPostNo();
	
}
