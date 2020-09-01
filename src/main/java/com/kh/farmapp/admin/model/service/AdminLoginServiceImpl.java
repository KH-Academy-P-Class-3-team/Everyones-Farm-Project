package com.kh.farmapp.admin.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.farmapp.admin.model.dao.AdminLoginDao;

import common.dto.Admin;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {

	@Autowired
	private AdminLoginDao adminLoginDao;
	
	@Override
	public Admin selectAdminByIdAndPw(Admin admin) {
		return adminLoginDao.selectAdminByIdAndPw(admin);
	}
}
