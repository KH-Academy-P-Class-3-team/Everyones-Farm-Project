package com.kh.farmapp.admin.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.farmapp.admin.model.dao.AdminUserDao;

import common.dto.Farmer;
import common.dto.UserTB;
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

}
