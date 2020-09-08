package com.kh.farmapp.admin.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.dto.Farm;
import common.dto.Farmer;
import common.dto.UserTB;

/**
 * AdminUserDao 를 상속 받는 클래스
 * AdminUserDao 를 구현 하는 클래스
 */
@Repository
public class AdminUserDaoImpl implements AdminUserDao {

	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public List<Map<String, Object>> selectAllFarmerList() {
		
		// 클래스 다이어그램 용 객체
		Farmer farmer = new Farmer();
		Farm farm = new Farm();
		
		return null;
	}

	@Override
	public List<Map<String, Object>> selectAllUserList() {
		return session.selectList("ADMINMEMBER.selectAllUserList");
	}

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
	public int updateIsConfirm(Farmer farmer) {
		return 0;
	}

	@Override
	public int updateIsConfirmToNo(Farmer farmer) {
		return 0;
	}

	@Override
	public int updatePause(UserTB user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(UserTB user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePause(Farmer farmer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteFarmer(Farmer farmer) {
		// TODO Auto-generated method stub
		return 0;
	}

}
