package com.kh.farmapp.member.farmer.model.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import common.dto.Farm;
import common.dto.Farmer;

public interface FarmerService {

	/**
	 * 회원 가입
	 * @param farmer 
	 * @param commandMap
	 * @return int
	 */
//	public int insertFarmer(Map<String, Object> commandMap);
	public int insertFarmer(Farmer farmer);
	
	/**
	 * 회원 가입
	 * @param farm
	 * @return int
	 */
//	public int insertFarm(Map<String, Object> commandMap);
	public int insertFarm(Farm farm);
	
	/**
	 * 회원 찾기(로그인)
	 * @param commandMap
	 * @return Farmer
	 */
	public Farmer selectFarmer(Map<String, Object> commandMap);
	
	/**
	 * 아이디 찾기
	 * @param commandMap
	 * @return Farmer
	 */
	public Farmer findId(Map<String, Object> commandMap);
	
	/**
	 * 비밀번호 찾기
	 * @param commandMap
	 * @return Farmer
	 */
	public Farmer findPw(Map<String, Object> commandMap);
	
	/**
	 * 아이디로 찾은 회원 
	 * @param req
	 * @return Farmer
	 */
	public Farmer findFarmerId(HttpServletRequest req);
	
	/**
	 * 비밀번호찾기 이메일 보내기
	 * @param farmer
	 * @param urlPath
	 */
	public void findPwMailSend(Farmer farmer, String urlPath);
	
	/**
	 * 비밀번호 업데이트
	 * @param farmer
	 * @return true/false - 성공실패
	 */
	public int updatePw(Farmer farmer);

	/**
	 * 아이디 중복 체크
	 * @param farmerId
	 * @return int
	 */
	public int selectIdCheck(String farmerId);

	/**
	 * 비밀번호 중복 체크
	 * @param email
	 * @return int
	 */
	public int selectEmailCheck(String email);

	/**
	 * 전화번호 중복 체크
	 * @param phone
	 * @return int
	 */
	public int selectPhoneCheck(String phone);

	/**
	 * 농장 전화번호 중복 체크
	 * @param phone
	 * @return int
	 */
	public int selectfarmPhoneCheck(String phone);
	
}
