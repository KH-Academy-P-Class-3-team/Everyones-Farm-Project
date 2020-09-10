package com.kh.farmapp.admin.model.dao;

import java.util.List;
import java.util.Map;

import common.dto.AnsweredOneonone;
import common.dto.QuestionOneonone;
import common.util.AdminPaging;

/**
 * 1대1문의 관리 페이지의 Dao interface
 */
public interface AdminOneOnOneDao {

	/**
	 * 일반 회원 1대1 문의 목록 조회
	 * @param apaging - paging 정보를 갖는 AdminPaging 객체
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
	 * @return List<Map<String, Object>> - 조회 결과 반환
	 */
	public List<Map<String, Object>> selectUserOneOnOneByNo(QuestionOneonone qNo);

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
	public int insertAnswerToUser(AnsweredOneonone a);

	/**
	 * 농업인 회원의 문의에 답변 작성하기
	 * @param a - 작성한 답변에 대한 정보를 갖는 AnsweredOneOnOne 객체
	 * @return int - 작성 결과(insert 결과)
	 */
	public int insertAnswerToFarmer(AnsweredOneonone a);

	/**
	 * 일반 회원의 문의에 작성한 답변 수정하기
	 * @param a - 수정한 답변에 대한 정보를 갖는 AnsweredOneOnOne 객체
	 * @return int - 수정 결과(update 결과)
	 */
	public int updateAnswertToUser(AnsweredOneonone a);

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
	 * 일반 회원의 문의 목록 총 갯수 조회
	 * @param search - 검색어
	 * @return int - 조회 결과 반환
	 */
	public int selectCntAllUserOneOnOne(String search);

}
