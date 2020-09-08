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
	public int deleteUser(UserTB user) {
		return adminUserDao.deleteUser(user);
	}

	@Override
	public int updatePause(Farmer farmer) {
		return adminUserDao.updatePause(farmer);
	}

	@Override
	public int deleteFarmer(Farmer farmer) {
		return adminUserDao.deleteFarmer(farmer);
	}
	
	@Override
	public AdminPaging getPaging(String curPage) {
		// curPageNo 초기화, curPageNo 은 현재 페이지 번호를 뜻함!
		int curPageNo = 0;
		if( curPage != null && !"".equals(curPage) ) {
			curPageNo = Integer.parseInt(curPage);
		}
		
		// NOTICE 테이블의 총 게시글 수를 조회한다.
		int totalCount = adminUserDao.selectCntAllUserList();
		
		// AdminPaging 객체 생성 - 현재 페이지(curPage), 총 게시글 수(totalCount) 활용
		AdminPaging paging = new AdminPaging(totalCount, curPageNo);
		
		return paging;
	}
	
	@Override
	public List<Map<String, Object>> selectAllUserByPaging(AdminPaging apaging) {
		return adminUserDao.selectAllUserByPaging(apaging);
	}

}
