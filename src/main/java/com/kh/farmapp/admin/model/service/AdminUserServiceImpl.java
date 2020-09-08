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
	
	@Override
	public List<Map<String, Object>> selectAllFarmerList() {
		return adminUserDao.selectAllFarmerList();
	}

	@Override
	public List<Map<String, Object>> selectAllUserList() {
		return adminUserDao.selectAllUserList();
	}

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

	@Override
	public int updatePause(UserTB user) {
		return adminUserDao.updatePause(user);
	}

	@Override
	public int updatePause(Farmer farmer) {
		return adminUserDao.updatePause(farmer);
	}

	@Override
	public int deleteFarmer(Farmer farmer) {
		return adminUserDao.deleteFarmer(farmer);
	}
	
	// 회원 페이징 처리
	@Override
	public AdminPaging getPaging(String curPage, String search) {
		// curPageNo 초기화, curPageNo 은 현재 페이지 번호를 뜻함!
		int curPageNo = 0;
		if( curPage != null && !"".equals(curPage) ) {
			curPageNo = Integer.parseInt(curPage);
		}
		
		// NOTICE 테이블의 총 게시글 수를 조회한다.
		int totalCount = 0;
		// 검색어가 없을 경우, null일 경우
		if( search == null && "".equals(search) ) {
			
			totalCount = adminUserDao.selectCntAllUserList(); 
			
		} else { // 검색어가 있을 경우
			
			totalCount = adminUserDao.selectCntUserBySearch(search);
			
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

}
