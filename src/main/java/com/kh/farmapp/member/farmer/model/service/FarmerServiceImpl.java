package com.kh.farmapp.member.farmer.model.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.farmapp.member.farmer.model.dao.FarmerDao;

import common.dto.Farm;
import common.dto.Farmer;

@Service
public class FarmerServiceImpl implements FarmerService{


	@Autowired
	private FarmerDao farmerDao;
	
	
	@Override
	public int insertFarmer(Farmer farmer) {
		return farmerDao.insertFarmer(farmer);
	}
	
	@Override
	public int insertFarm(Farm farm) {
		return farmerDao.insertFarm(farm);
	}
	
	@Override
	public Farmer selectFarmer(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void joinMailSend(Farmer farmer, String urlPath) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Farmer findId(Farmer farmer) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Farmer findPw(Farmer farmer) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Farmer findFarmerId(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void findPwMailSend(Farmer farmer, String urlPath) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean updatePw(Farmer farmer) {
		// TODO Auto-generated method stub
		return false;
	}
}
