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
	public int updateAnswer(AnsweredOneonone a);
	
	/**
	 * 농업인 회원의문의에 작성한 답변 수정하기
	 * @param a - 수정할 답변에 대한 정보를 갖는 AnsweredOneOnOne 객체
	 * @return int - 수정 결과(update 결과)
	 */
	public int updateAnswerToFarmer(AnsweredOneonone a);
	
	/**
	 * 문의 목록 조회시 페이징 처리를 위한 페이징 객체 설정
	 * 
	 * @param pagingConfig - 페이징 설정 정보를 갖는 Map
	 * @return AdminPaging - 설정된 페이징 객체 반환
	 */
	public AdminPaging getPaging(Map<String, Object> pagingConfig);

	/**
	 * questionNo 로 문의 글 조회
	 * 
	 * @param q - questionNo 정보를 갖는 QuestionOneonone 객체
	 * @return Map<String, Object> - 조회 결과 반환
	 */
	public Map<String, Object> selectAnswerOneOnOneByQuestionNo(QuestionOneonone q);

	/**
	 * 답변 삭제
	 * 
	 * @param deleteAnswer - 삭제할 답변의 정보를 갖는 AnsweredOneonone 객체
	 * @return int - delete 수행 결과
	 */
	public int deleteAnswer(AnsweredOneonone deleteAnswer);

	/**
	 * 답변 상태 업데이트
	 * 
	 * @param answer - 문의글 번호 정보를 갖는 AnsweredOneonone 객체
	 * @return int - update 결과 반환
	 */
	public int updateAnswerStateByQuestionNo(AnsweredOneonone answer);

	/**
	 * 답변 삭제시 답변 상태 업데이트
	 * 
	 * @param deleteAnswer - 문의글 번호 정보를 갖는 AnsweredOneonone 객체
	 * @return int - update 결과 반환
	 */
	public int updateWaitAnswerByQuestionNo(AnsweredOneonone deleteAnswer);

}
