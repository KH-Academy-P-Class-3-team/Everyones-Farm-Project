package com.kh.farmapp.member.farmer.model.dao;

import java.util.Map;

import common.dto.Farm;
import common.dto.Farmer;

public interface FarmerDao {

	/**
	 * 회원 가입
	 * @param farmer
	 * @return
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
	 * @param commandMap
	 * @return Farmer
	 */
	public Farmer findFarmerId(Map<String, Object> commandMap);
	
	/**
	 * 비밀번호 수정하기
	 * @param farmer
	 * @return int
	 */
	public int updatePw(Farmer farmer);
	
	/**
	 * 아이디 중복 체크
	 * @param farmerId
	 * @return
	 */
	public int selectIdCheck(String farmerId);
	
	/**
	 * 이메일 중복 체크
	 * @param email
	 * @return
	 */
	public int selectEmailCheck(String email);
	
	/**
	 * 전화번호 중복 체크
	 * @param phone
	 * @return
	 */
	public int selectPhoneCheck(String phone);
	
	/**
	 * 농장 전화번호 중복 체크
	 * @param phone
	 * @return
	 */
	public int selectfarmPhoneCheck(String phone);
	
	/**
	 * 비밀번호 찾기
	 * @param commandMap
	 * @return Farmer
	 */
	public Farmer findFarmerPw(Map<String, Object> commandMap);


}
