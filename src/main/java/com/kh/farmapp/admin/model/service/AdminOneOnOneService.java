package com.kh.farmapp.admin.model.service;

import java.util.List;
import java.util.Map;

import common.dto.AnsweredOneonone;
import common.dto.QuestionOneonone;
import common.util.AdminPaging;


/**
 * 1대1문의 관리 페이지 Service interface
 */
public interface AdminOneOnOneService {
	
	/**
	 * 일반 회원 1대1 문의 목록 조회
	 * @param apaging - 페이징 정보를 갖는 AdminPaging 객체
	 * @return List<Map<String, Object>> - 조회 결과 반환
	 */
	public List<Map<String, Object>> selectAllUserOneOnOneList(AdminPaging apaging);
	
	/**
	 * 농업인 회원 1대1 문의 목록 조회
	 * @return List<Map<String, Object>> - 조회 결과 반환
	 */
	public List<Map<String, Object>> selectAllFarmerOneOnOneList();
	
	/**
	 * 일반 회원 1대1 문의 상세 조회
	 * @param qNo - 상세 조회될 질문에 대한 정보를 갖는 QuestionOneonone 객체
	 * @return Map<String, Object> - 조회 결과 반환
	 */
	public Map<String, Object> selectUserOneOnOneByNo(QuestionOneonone qNo);
	
	/**
	 * 농업인 회원 1대1 문의 상세 조회
	 * @param qNo - 상세 조회될 질문에 대한 정보를 갖는 QuestionOneonone 객체
	 * @return List<Map<String, Object>> - 조회 결과 반환
	 */	
	public List<Map<String, Object>> selectFarmerOneOnOneByNo(QuestionOneonone qNo);
	
	/**
	 * 일반 회원의 문의에 답변 작성하기
	 * @param a - 작성한 답변에 대한 정보를 갖는 AnsweredOneOnOne 객체
	 * @return int - 작성 결과(insert 결과)
	 */
	public int writeAnswerToUser(AnsweredOneonone a);

	/**
	 * 농업인 회원의 문의에 답변 작성하기
	 * @param a - 작성한 답변에 대한 정보를 갖는 AnsweredOneOnOne 객체
	 * @return int - 작성 결과(insert 결과)
	 */
	public int writeAnswerToFarmer(AnsweredOneonone a);
	
	/**
	 * 일반 회원의 문의에 작성한 답변 수정하기
	 * @param a - 수정한 답변에 대한 정보를 갖는 AnsweredOneOnOne 객체
	 * @return int - 수정 결과(update 결과)
	 */
	public int updateAnswerToUser(AnsweredOneonone a);
	
	/**
	 * 농업인 회원의문의에 작성한 답변 수정하기
	 * @param a - 수정할 답변에 대한 정보를 갖는 AnsweredOneOnOne 객체
	 * @return int - 수정 결과(update 결과)
	 */
	public int updateAnswerToFarmer(AnsweredOneonone a);
	
	/**
	 * 일반 회원의 문의에 작성한 답변 삭제하기
	 * @param aNo - 삭제할 답변에 대한 정보를 갖는 AnsweredOneOnOne 객체
	 * @return int - 삭제 결과(delete 결과)
	 */
	public int deleteAnswerToUserByNo(AnsweredOneonone aNo);

	/**
	 * 일반 회원의 문의에 작성한 답변 삭제하기
	 * @param aNo - 삭제할 답변에 대한 정보를 갖는 AnsweredOneOnOne 객체
	 * @return int - 삭제 결과(delete 결과)
	 */
	public int deleteAnswerToFarmerByNo(AnsweredOneonone aNo);

	/**
	 * 문의 목록 조회시 페이징 처리를 위한 페이징 객체 설정
	 * 
	 * @param pagingConfig - 페이징 설정 정보를 갖는 Map
	 * @return AdminPaging - 설정된 페이징 객체 반환
	 */
	public AdminPaging getPaging(Map<String, Object> pagingConfig);
	
}
