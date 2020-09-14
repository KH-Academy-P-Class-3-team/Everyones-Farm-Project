package com.kh.farmapp.admin.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.farmapp.admin.model.dao.AdminMainDao;

import common.util.AdminPaging;

/**
 * AdminMainService 를 상속 받는 클래스
 * AdminMainServiceImpl 구현 클래스
 */
@Service
public class AdminMainServiceImpl implements AdminMainService{

	@Autowired
	private AdminMainDao adminMainDao;
	
	@Override
	public List<Map<String, Object>> selectLatestFarmerApplicationList() {
		return adminMainDao.selectLatestFarmerApplicationList();
	}
	
	@Override
	public List<Map<String, Object>> selectLatestQuestionList() {
		return adminMainDao.selectLatestQuestionList();
	}

}
