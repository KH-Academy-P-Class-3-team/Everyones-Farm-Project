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
	public UserTB findUserId(Map<String, Object> commandMap) {
		return session.selectOne("USER.selectId", commandMap);
	}
	
	@Override
	public UserTB findUserPw(Map<String, Object> commandMap) {
		return session.selectOne("USER.selectPw", commandMap);
	}
	
	@Override
	public int updatePw(UserTB user) {
		return session.update("USER.updatePw", user);
	}
	
	@Override
	public int selectIdCheck(String userId) {
		return session.selectOne("USER.selectIdCheck", userId);
	}
	
	@Override
	public int selectEmailCheck(String email) {
		return session.selectOne("USER.selectEmailCheck", email);
	}
	
	@Override
	public int selectPhoneCheck(String phone) {
		return session.selectOne("USER.selectPhoneCheck", phone);
	}
	
}
