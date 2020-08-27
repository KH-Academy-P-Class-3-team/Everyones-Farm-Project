package com.kh.farmapp.member.farmer.model.dao;

import java.util.Map;

import common.dto.Farm;
import common.dto.Farmer;

public interface FarmerDao {

	/**
	 * 회원 가입
	 * @param farmer
	 * @return int
	 */
	public int insertFarmer(Farmer farmer);
	
	/**
	 * 회원 가입
	 * @param farm
	 * @return int
	 */
	public int insertFarm(Farm farm);
	
	/**
	 * 로그인(회원 선택)
	 * @param commandMap
	 * @return Farmer
	 */
	public Farmer selectFarmer(Map<String, Object> commandMap);
	
	/**
	 * 전화번호로 아이디 찾기
	 * @param farmerPhone
	 * @return int
	 */
	public int findFarmerId(String farmerPhone);
	
	/**
	 * 비밀번호 수정하기
	 * @param farmer
	 * @return int
	 */
	public int updatePw(Farmer farmer);

}
