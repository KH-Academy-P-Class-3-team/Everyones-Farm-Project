package com.kh.farmapp.admin.model.dao;

import java.util.List;
import java.util.Map;

import common.dto.Farmer;
import common.dto.UserTB;
import common.util.AdminPaging;

/**
 * 관리자 페이지 중 회원 관리 페이지의 Dao interface
 */
public interface AdminUserDao {


	/**
	 * 관리자 페이지의 농업인 회원 신청 관리 페이지에 사용된다.
	 * 농업인 회원가입을 신청한 회원들의 목록을 조회
	 * @return List<Map<String, Object>> - 조회 결과 반환
	 */
	public List<Map<String, Object>> selectAllFarmerApplicationList();

	/**
	 * 관리자 페이지의 농업인 회원 신청 상세 페이지에 사용된다.
	 * 특정 회원의 농업인 회원가입을 신청한 회원들이 작성한 신청서에 대한 정보를 조회
	 * @param farmerNo - 농장 번호 정보를 갖는 Farmer 객체
	 * @return List<Map<String, Object>> - 조회 결과 반환
	 */
	public List<Map<String, Object>> selectFarmerApplicationByFarmerNo(Farmer farmerNo);

	/**
	 * 농업인 회원의 is_confirm 컬럼의 값을 'n'로 업데이트 한다.
	 * @param farmer - 보류할 농업인 회원 객체
	 * @return int - is_confirm 컬럼 업데이트 결과 반환
	 */
	public int updateIsConfirmToNo(Farmer farmer);

	/**
	 * 페이징 처리를 위한 총 user count 조회
	 * 
	 * @return int - 조회된 결과
	 */
	public int selectCntAllUserList();

	/**
	 * 페이징 처리된 일반 회원 목록 조회하기
	 * 
	 * @param apaging - 페이징 정보를 갖는 AdminPaging 객체
	 * @return List<Map<String, Object>> - 조회 결과 반환
	 */
	public List<Map<String, Object>> selectAllUserByPaging(AdminPaging apaging);

	/**
	 * 검색된 결과 갯수
	 * 
	 * @param search - 검색어
	 * @return int - 조회 결과
	 */
	public int selectCntUserBySearch(String search);

	/**
	 * is_leave 컬럼 업데이트로 회원 탈퇴
	 * 
	 * @param userNoList - 회원 번호를 갖는 List
	 * @return int - 회원 탈퇴 결과 반환
	 */
	public int deleteUserByUserNo(List<String> userNoList);

	/**
	 * is_leave 컬럼 업데이트 회원 탈퇴 취소
	 * 
	 * @param userNoList - 회원 번호를 갖는 List
	 * @return int - 회원 탈퇴 취소 결과 반환
	 */
	public int delCancelUserByUserNo(List<String> userNoList);

	/**
	 * 페이징 처리를 위한 총 farmer count 조회
	 * 
	 * @return int - 조회된 결과 반환
	 */
	public int selectCntAllFarmerList();

	/**
	 * 검색된 결과 갯수
	 * 
	 * @param search - 검색어
	 * @return int - 조회 결과
	 */
	public int selectCntFarmerBySearch(String search);

	/**
	 * 페이징 처리된 농업인 회원 목록 조회하기
	 * 
	 * @param apaging - 페이징 정보를 갖는 AdminPaging 객체
	 * @return List<Map<String, Object>> - 조회 반환 결과
	 */
	public List<Map<String, Object>> selectFarmerByPaging(AdminPaging apaging);

	/**
	 * 농업인 회원 탈퇴 처리
	 * 
	 * @param farmerNoList - 농업인 회원 번호를 갖는 List
	 * @return int - 탈퇴 처리 결과
	 */
	public int deleteFarmerByFarmerNo(List<String> farmerNoList);

	/**
	 * 농업인 회원 탈퇴 처리 취소
	 * 
	 * @param farmerNoList - farmerNo 정보를 갖는 List
	 * @return int - 탈퇴 취소 처리 결과
	 */
	public int delCancelFarmerByFarmerNo(List<String> farmerNoList);

	/**
	 * 농장 입점 신청 총 갯수
	 * 
	 * @return int - 조회된 결과
	 */
	public int selectCntAllFarmApplicationList();

	/**
	 * 검색된 농장 입점 신청 총 갯수
	 * 
	 * @param search - 검색어
	 * @return int - 조회 결과 반환
	 */
	public int selectCntFarmApplicationBySearch(String search);

	/**
	 * 농장 입점 신청 목록 조회(페이징 처리)
	 * 
	 * @param apaging - 페이징 정보를 갖는 AdminPaging 객체
	 * @return List<Map<String, Object>> - 조회 결과 반환
	 */
	public List<Map<String, Object>> selectFarmApplicationByPaging(AdminPaging apaging);

	/**
	 * 농장 입점 승인 처리
	 * 
	 * @param farmerNoList - farmerNo 정보를 갖는 List
	 * @return int - 승인 처리 결과
	 */
	public int approveFarmerApplication(List<String> farmerNoList);

	/**
	 * 농장 입점 신청 목록에서 선택된 회원들의 메일 조회
	 * 
	 * @param farmerNoList - farmerNo 정보를 갖는 List
	 * @return List<Farmer> - 조회 결과
	 */
	public List<Farmer> selectFarmerMailByFarmerNo(List<String> farmerNoList);

	/**
	 * 농장 입점 신청 보류
	 * 
	 * @param farmerNoList - 보류할 farmerNo 정보를 갖는 List
	 * @return int - 보류 결과
	 */
	public int holdFarmerApplication(List<String> farmerNoList);

}
