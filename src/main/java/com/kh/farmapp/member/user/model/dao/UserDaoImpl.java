package com.kh.farmapp.member.user.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.dto.UserTB;

@Repository
public class UserDaoImpl implements UserDao{ 
 
	@Autowired
	SqlSessionTemplate session;
	
	@Override
	public int insertUser(UserTB user) {
		return session.insert("USER.insertUser", user);
	}
	
	@Override
	public UserTB selectUser(Map<String, Object> commandMap) {
		return session.selectOne("USER.selectUser", commandMap);
	}
	
	@Override
	public int findUserId(String userPhone) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int updatePw(UserTB user) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int selectIdCheck(String userId) {
		// TODO Auto-generated method stub
		return session.selectOne("USER.selectIdCheck", userId);
	}
	
}
