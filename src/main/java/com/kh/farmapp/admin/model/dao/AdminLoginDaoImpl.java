package com.kh.farmapp.admin.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.dto.Admin;

@Repository
public class AdminLoginDaoImpl implements AdminLoginDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public Admin selectAdminByIdAndPw(Admin admin) {
		return sqlSession.selectOne("ADMINLOGIN.selectAdminByIdAndPw", admin);
	}
}
