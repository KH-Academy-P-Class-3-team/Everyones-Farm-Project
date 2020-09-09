package com.kh.farmapp.admin.model.service;

import java.util.List;
import java.util.Map;

import common.dto.Farmer;
import common.dto.UserTB;
import common.util.AdminPaging;

/**
 * 관리자 페이지 중 회원 관리 페이지의 Service interface
 */
public interface AdminUserService {
	
	/**
	 * 관리자 페이지의 농업인 회원 신청 관리 페이지에 사용된다.
	 * 농업인 회원가입을 신청한 회원들의 목록을 조회 요청한다.
	 * @return List<Map<String, Object>> - 조회 결과 반환
	 */
	public List<Map<String, Object>> selectAllFarmerApplicationList();
	
	/**
	 * 관리자 페이지의 농업인 회원 신청 상세 페이지에 사용된다.
	 * 특정 회원의 농업인 회원가입을 신청한 회원들이 작성한 신청서에 대한 정보를 조회 요청한다.
	 * @param farmerNo - 농장 번호 정보를 갖는 Farmer 객체
	 * @return List<Map<String, Object>> - 조회 결과 반환
	 */
	public List<Map<String, Object>> selectFarmerApplicationByFarmerNo(Farmer farmerNo);
	
	/**
	 * 관리자 페이지의 농업인 회원 신청 상세 페이지에서 사용된다.
	 * 관리자는 신청서를 보고 보류한다.
	 * @param farmer - 보류할 농업인 회원 객체
	 * @return int - is_confirm 컬럼 업데이트 결과 반환
	 */
	public int putFarmerApplicationOnHold(Farmer farmer);
	
	/**
	 * 회원 목록 페이징 처리를 위한 페이징 설정
	 * 
	 * @param pagingConfig - paging 설정에 대한 값들을 가지고 있는 Map
	 * @return AdminPaging - list 페이징 객체
	 */
	public AdminPaging getPaging(Map<String, Object> pagingConfig);

	/**
	 * 일반 회원 페이징 처리한 목록 조회
	 * 
	 * @param apaging - 페이징 정보를 가진 AdminPaging 객체
	 * @return List<Map<String, Object>> - 조회 결과 반환
	 */
	public List<Map<String, Object>> selectAllUserByPaging(AdminPaging apaging);

	/**
	 * is_leave 컬럼 업데이트 (회원 탈퇴) 
	 * @param userNoList - 탈퇴할 회원 번호가 저장된 List<String>
	 * @return int - 회원 탈퇴 결과 반환
	 */
	public int deleteUserByUserNo(List<String> userNoList);

	/**
	 * is_leave 컬럼 업데이트 (회원 탈퇴 취소)
	 * 
	 * @param userNoList - 탈퇴 취소할 회원 번호가 저장된 List
	 * @return int - 회원 탈퇴 취소 결과 반환
	 */
	public int delCancelUserByUserNo(List<String> userNoList);

	/**
	 * 농업인 회원 페이징 처리한 목록 조회
	 * 
	 * @param apaging
	 * @return
	 */
	public List<Map<String, Object>> selectFarmerByPaging(AdminPaging apaging);

	/**
	 * 농업인 회원 탈퇴 처리 요청
	 * 
	 * @param farmerNoList - 농업인 회원 번호를 갖는 List
	 * @return int - 탈퇴 처리 결과
	 */
	public int deleteFarmerByFaremrNo(List<String> farmerNoList);

	/**
	 * 농업인 회원 탈퇴 취소 처리 요청
	 * 
	 * @param farmerNoList - farmerNo 갖는 List
	 * @return int - 탈퇴 취소 처리 결과
	 */
	public int delCancelFarmerByFarmerNo(List<String> farmerNoList);

	/**
	 * 농장 입점 신청 목록 조회
	 * 
	 * @param apaging - 페이징 정보를 갖는 AdminPaging 객체
	 * @return List<Map<String, Object>> - 조회 결과 반환
	 */
	public List<Map<String, Object>> selectFarmApplicationByPaging(AdminPaging apaging);

	/**
	 * 농장 입점 신청 승인 요청
	 * 
	 * @param farmerNoList - farmerNo 정보를 갖는 List
	 * @return int - 승인 요청 결과
	 */
	public int approveFarmerApplication(List<String> farmerNoList);

	/**
	 * 농장 입점 신청 목록에서 선택된 회원들의 메일 조회 요청
	 * 
	 * @param farmerNoList - farmerNo 정보를 갖는 List
	 * @return List<Farmer> - 조회 결과
	 */
	public List<Farmer> selectFarmerMailByFarmerNo(List<String> farmerNoList);

	/**
	 * 농장 입점 신청 승인 메일 보내기
	 * 
	 * @param mailRecipient - 메일 받는 사람
	 * @param urlPath - 홈페이지 서버
	 */
	public void approveMailSend(Farmer mailRecipient, String urlPath);

	/**
	 * 농장 입점 신청 보류 요청
	 * 
	 * @param farmerNoList - 보류할 farmerNo 정보를 갖는 List 
	 * @return int - 보류 결과
	 */
	public int holdFarmerApplication(List<String> farmerNoList);

	/**
	 * 농장 입점 보류 메일 보내기
	 * 
	 * @param mailRecipient - 메일 정보를 갖는 Farmer 객체
	 * @param urlPath - 서버 주소
	 */
	public void holdMailSend(Farmer mailRecipient, String urlPath);

}
