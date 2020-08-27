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
	public Farmer selectFarmer(Map<String, Object> commandMap) {
		
		// 클래스 다이어그램 용 객체 선언
		Farmer farmer = new Farmer();
		Farm farm = new Farm();
		
		return null;
	}
	
	@Override
	public int findFarmerId(String farmerPhone) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int updatePw(Farmer farmer) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
