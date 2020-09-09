package com.kh.farmapp.admin.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.farmapp.admin.model.dao.AdminUserDao;

import common.dto.Farmer;
import common.dto.UserTB;
import common.util.AdminPaging;
/**
 * AdminUserSerivce 를 상속 받는 클래스
 * AdminUserService 구현 클래스
 */
@Service
public class AdminUserServiceImpl implements AdminUserService{

	@Autowired
	private AdminUserDao adminUserDao;
	
	// pagingConfig 상수
	private static final int USER_CODE = 0;
	private static final int FARMER_CODE = 1;
	
	@Override
	public List<Map<String, Object>> selectAllFarmerApplicationList() {
		return adminUserDao.selectAllFarmerApplicationList();
	}

	@Override
	public List<Map<String, Object>> selectFarmerApplicationByFarmerNo(Farmer farmerNo) {
		return adminUserDao.selectFarmerApplicationByFarmerNo(farmerNo);
	}

	@Override
	public int approveFarmerApplication(Farmer farmer) {
		return adminUserDao.updateIsConfirm(farmer);
	}
	
	@Override
	public int putFarmerApplicationOnHold(Farmer farmer) {
		return adminUserDao.updateIsConfirmToNo(farmer);
	}

	// 회원 페이징 처리
	@Override
	public AdminPaging getPaging(Map<String, Object> pagingConfig) {
		
		String curPage = (String) pagingConfig.get("curPage");
		String search = (String) pagingConfig.get("search");
		int listCode = (int) pagingConfig.get("listCode");
		
		// curPageNo 초기화, curPageNo 은 현재 페이지 번호를 뜻함!
		int curPageNo = 0;
		if( curPage != null && !"".equals(curPage) ) {
			curPageNo = Integer.parseInt(curPage);
		}
		
		// NOTICE 테이블의 총 게시글 수를 조회한다.
		int totalCount = 0;
		// 검색어가 없을 경우, null일 경우
		if( search == null || "".equals(search) ) {
			
			switch (listCode) {
			case USER_CODE:
				totalCount = adminUserDao.selectCntAllUserList();
				break;
			case FARMER_CODE:
				totalCount = adminUserDao.selectCntAllFarmerList();
				break;
			}
			
		} else { // 검색어가 있을 경우
			
			switch (listCode) {
			case USER_CODE:
				totalCount = adminUserDao.selectCntUserBySearch(search);
				break;
			case FARMER_CODE:
				totalCount = adminUserDao.selectCntFarmerBySearch(search);
				break;
			}
			
		}
		
		// AdminPaging 객체 생성 - 현재 페이지(curPage), 총 게시글 수(totalCount) 활용
		AdminPaging paging = new AdminPaging(totalCount, curPageNo);
		// 검색어 AdminPaging 객체에 넣어주기
		paging.setSearch(search);
		
		return paging;
	}
	
	// 페이징에 의한 회원 조회
	@Override
	public List<Map<String, Object>> selectAllUserByPaging(AdminPaging apaging) {
		return adminUserDao.selectAllUserByPaging(apaging);
	}
	
	// 선택된 회원들 탈퇴시키기
	@Override
	public int deleteUserByUserNo(List<String> userNoList) {
		return adminUserDao.deleteUserByUserNo(userNoList);
	}
	
	// 선택된 회원 탈퇴 취소
	@Override
	public int delCancelUserByUserNo(List<String> userNoList) {
		return adminUserDao.delCancelUserByUserNo(userNoList);
	}
	
	// 페이징 처리된 farmer 회원 목록
	@Override
	public List<Map<String, Object>> selectFarmerByPaging(AdminPaging apaging) {
		return adminUserDao.selectFarmerByPaging(apaging);
	}
	
	// 농업인 회원 탈퇴 처리
	@Override
	public int deleteFarmerByFaremrNo(List<String> farmerNoList) {
		return adminUserDao.deleteFarmerByFarmerNo(farmerNoList);
	}
	
	// 농업인 회원 탈퇴 취소 처리
	@Override
	public int delCancelFarmerByFarmerNo(List<String> farmerNoList) {
		return adminUserDao.delCancelFarmerByFarmerNo(farmerNoList);
	}
}
