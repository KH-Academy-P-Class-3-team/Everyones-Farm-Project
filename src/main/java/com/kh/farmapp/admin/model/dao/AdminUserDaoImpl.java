package com.kh.farmapp.admin.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.dto.Farm;
import common.dto.Farmer;
import common.dto.UserTB;
import common.util.AdminPaging;

/**
 * AdminUserDao 를 상속 받는 클래스
 * AdminUserDao 를 구현 하는 클래스
 */
@Repository
public class AdminUserDaoImpl implements AdminUserDao {

	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public List<Map<String, Object>> selectAllFarmerApplicationList() {
		
		// 클래스 다이어그램 용 객체
		Farmer farmer = new Farmer();
		Farm farm = new Farm();
		
		return null;
	}

	@Override
	public List<Map<String, Object>> selectFarmerApplicationByFarmerNo(Farmer farmerNo) {
		
		// 클래스 다이어그램 용 객체
		Farmer farmer = new Farmer();
		Farm farm = new Farm();
		
		return null;
	}

	@Override
	public int updateIsConfirmToNo(Farmer farmer) {
		return 0;
	}

	// 일반 회원 총 갯수
	@Override
	public int selectCntAllUserList() {
		return session.selectOne("ADMINMEMBER.selectCntAllUserList");
	}
	
	// 페이징 처리가 된 목록 조회
	@Override
	public List<Map<String, Object>> selectAllUserByPaging(AdminPaging apaging) {
		return session.selectList("ADMINMEMBER.selectAllUserByPaging", apaging);
	}

	// 검색된 회원 총 갯수
	@Override
	public int selectCntUserBySearch(String search) {
		return session.selectOne("ADMINMEMBER.selectCntUserBySearch", search);
	}
	
	// 회원 탈퇴
	@Override
	public int deleteUserByUserNo(List<String> userNoList) {
		return session.update("ADMINMEMBER.deleteUserByUserNo", userNoList);
	}
	
	// 회원 탈퇴 취소
	@Override
	public int delCancelUserByUserNo(List<String> userNoList) {
		return session.update("ADMINMEMBER.delCancelUserByUserNo", userNoList);
	}
	
	// farmer 회원 총 갯수
	@Override
	public int selectCntAllFarmerList() {
		return session.selectOne("ADMINMEMBER.selectCntAllFarmerList");
	}
	
	// 검색된 farmer 회원 갯수
	@Override
	public int selectCntFarmerBySearch(String search) {
		return session.selectOne("ADMINMEMBER.selectCntFarmerBySearch", search);
	}
	
	// 페이징 처리가 된 목록 조회
	@Override
	public List<Map<String, Object>> selectFarmerByPaging(AdminPaging apaging) {
		return session.selectList("ADMINMEMBER.selectFarmerByPaging", apaging);
	}

	// 농업인 회원 탈퇴 처리
	@Override
	public int deleteFarmerByFarmerNo(List<String> farmerNoList) {
		return session.update("ADMINMEMBER.deleteFarmerByFarmerNo", farmerNoList);
	}
	
	// 농업인 회원 탈퇴 취소 처리
	@Override
	public int delCancelFarmerByFarmerNo(List<String> farmerNoList) {
		return session.update("ADMINMEMBER.delCancelFarmerByFarmerNo", farmerNoList);
	}
	
	// 농장 입점 신청 갯수 조회
	@Override
	public int selectCntAllFarmApplicationList() {
		return session.selectOne("ADMINMEMBER.selectCntAllFarmApplicationList");
	}
	
	// 검색된 농장 입점 신청 갯수 조회
	@Override
	public int selectCntFarmApplicationBySearch(String search) {
		return session.selectOne("ADMINMEMBER.selectCntFarmApplicationBySearch", search);
	}
	
	// 농장 입점 신청 목록 조회
	@Override
	public List<Map<String, Object>> selectFarmApplicationByPaging(AdminPaging apaging) {
		return session.selectList("ADMINMEMBER.selectFarmApplicationByPaging", apaging);
	}
	
	// 농장 입점 승인 처리
	@Override
	public int approveFarmerApplication(List<String> farmerNoList) {
		return session.update("ADMINMEMBER.approveFarmerApplication", farmerNoList);
	}
	
	// 농장 입점 신청 목록에서 선택된 회원들의 메일 조회
	@Override
	public List<Farmer> selectFarmerMailByFarmerNo(List<String> farmerNoList) {
		return session.selectList("ADMINMEMBER.selectFarmerMailByFarmerNo", farmerNoList);
	}
}
