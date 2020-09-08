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
	 * 관리자 페이지의 농업인 회원 관리 페이지에 사용된다
	 * 사이트의 모든 농업인 회원 목록을 조회 요청한다.
	 * @return List<Map<String, Object>> - 조회 결과 반환
	 */
	public List<Map<String, Object>> selectAllFarmerList();

	/**
	 * 관리자 페이지의 일반 회원 관리 페이지에 사용된다
	 * 사이트의 모든 일반 회원 목록을 조회 요청한다.
	 * @return List<Map<String, Object>> - 조회 결과 반환
	 */
	public List<Map<String, Object>> selectAllUserList();
	
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
	 * 관리자는 신청서를 보고 승인을 한다.
	 * @param farmer - 승인할 농업인 회원 객체
	 * @return int - is_confirm 컬럼 업데이트 결과 반환
	 */
	public int approveFarmerApplication(Farmer farmer);
	
	/**
	 * 관리자 페이지의 농업인 회원 신청 상세 페이지에서 사용된다.
	 * 관리자는 신청서를 보고 보류한다.
	 * @param farmer - 보류할 농업인 회원 객체
	 * @return int - is_confirm 컬럼 업데이트 결과 반환
	 */
	public int putFarmerApplicationOnHold(Farmer farmer);
	
	/**
	 * 회원 활동 정지, pause 컬럼 업데이트
	 * @param user - 활동 정지 시킬 User 객체
	 * @return int - 업데이트 결과
	 */
	public int updatePause(UserTB user);
	
	/**
	 * 회원 탈퇴, is_leave 컬럼 업데이트
	 * @param user - 탈퇴 시킬 User 객체
	 * @return int - 업데이트 결과
	 */
	public int deleteUser(UserTB user);
	
	/**
	 * 농업인 회원 활동 정지, pause 컬럼 업데이트
	 * @param farmer - 활동 정지 시킬 Farmer 객체
	 * @return int - 업데이트 결과
	 */
	public int updatePause(Farmer farmer);
	
	/**
	 * 농업인 회원 탈퇴, is_leave 컬럼 업데이트
	 * @param farmer - 탈퇴 시킬 Farmer 객체
	 * @return int - 업데이트 결과
	 */
	public int deleteFarmer(Farmer farmer);

	/**
	 * 일반 회원 목록 페이징 처리를 위한 페이징 설정
	 * 
	 * @param curPage - 현재 페이지를 나타내는 querystring
	 * @return AdminPaging - userlist 페이징 객체
	 */
	public AdminPaging getPaging(String curPage);

	/**
	 * 일반 회원 페이징 처리한 목록 조회
	 * 
	 * @param apaging - 페이징 정보를 가진 AdminPaging 객체
	 * @return List<Map<String, Object>> - 조회 결과 반환
	 */
	public List<Map<String, Object>> selectAllUserByPaging(AdminPaging apaging);

}
