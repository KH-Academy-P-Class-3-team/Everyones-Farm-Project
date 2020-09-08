package com.kh.farmapp.admin.model.dao;

import java.util.List;
import java.util.Map;

import common.dto.Farmer;
import common.dto.UserTB;

/**
 * 관리자 페이지 중 회원 관리 페이지의 Dao interface
 */
public interface AdminUserDao {

	/**
	 * 관리자 페이지의 농업인 회원 관리 페이지에 사용된다
	 * 사이트의 모든 농업인 회원 목록을 조회
	 * @return List<Map<String, Object>> - 조회 결과 반환
	 */
	public List<Map<String, Object>> selectAllFarmerList();

	/**
	 * 관리자 페이지의 일반 회원 관리 페이지에 사용된다
	 * 사이트의 모든 일반 회원 목록을 조회
	 * @return List<Map<String, Object>> - 조회 결과 반환
	 */
	public List<Map<String, Object>> selectAllUserList();

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
	 * 농업인 회원의 is_confirm 컬럼의 값을 'y'로 업데이트 한다.
	 * @param farmer - 승인할 농업인 회원 객체
	 * @return int - is_confirm 컬럼 업데이트 결과 반환
	 */
	public int updateIsConfirm(Farmer farmer);

	/**
	 * 농업인 회원의 is_confirm 컬럼의 값을 'n'로 업데이트 한다.(사실 아직 정해진 게 없다... 다시 생각해봐야 한다)
	 * @param farmer - 보류할 농업인 회원 객체
	 * @return int - is_confirm 컬럼 업데이트 결과 반환
	 */
	public int updateIsConfirmToNo(Farmer farmer);

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

}
