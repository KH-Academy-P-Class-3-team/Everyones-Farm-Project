package com.kh.farmapp.member.farmer.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.dto.Farm;
import common.dto.Farmer;

@Repository
public class FarmerDaoImpl implements FarmerDao{

	@Autowired
	SqlSessionTemplate session;
	
	
	@Override
	public int insertFarmer(Farmer farmer) {
		return session.insert("FARMER.insertFarmer", farmer);
	}
	@Override
	public int insertFarm(Farm farm) {
		return session.insert("FARMER.insertFarm", farm);
	}
	
	@Override
	public int selectIdCheck(String farmerId) {
		return session.selectOne("FARMER.selectIdCheck", farmerId);
	}
	
	@Override
	public int selectEmailCheck(String email) {
		return session.selectOne("FARMER.selectEmailCheck", email);
	}
	
	@Override
	public int selectPhoneCheck(String phone) {
		return session.selectOne("FARMER.selectPhoneCheck", phone);
	}
	
	@Override
	public int selectfarmPhoneCheck(String phone) {
		return session.selectOne("FARMER.selectfarmPhoneCheck", phone);
	}

	@Override
	public Farmer selectFarmer(Map<String, Object> commandMap) {
		
		return session.selectOne("FARMER.selectFarmer", commandMap);
	}
	
	@Override
	public Farmer findFarmerId(Map<String, Object> commandMap) {
		return session.selectOne("FARMER.selectId", commandMap);
	}
	
	@Override
	public Farmer findFarmerPw(Map<String, Object> commandMap) {
		return session.selectOne("FARMER.selectPw", commandMap);
	}
	
	@Override
	public int updatePw(Farmer farmer) {
		return session.update("FARMER.updatePw", farmer);
	}
	
}
