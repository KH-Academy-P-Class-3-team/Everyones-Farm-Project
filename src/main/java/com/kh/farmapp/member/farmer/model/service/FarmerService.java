package com.kh.farmapp.member.farmer.model.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import common.dto.Farm;
import common.dto.Farmer;

public interface FarmerService {

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
	 * 회원 찾기
	 * @param commandMap
	 * @return Farmer
	 */
	public Farmer selectFarmer(Map<String, Object> commandMap);
	
	/**
	 * 가입 이메일 보내기
	 * @param farmer
	 * @param urlPath
	 */
	public void joinMailSend(Farmer farmer, String urlPath);
	
	/**
	 * 아이디 찾기
	 * @param farmer
	 * @return Farmer
	 */
	public Farmer findId(Farmer farmer);
	
	/**
	 * 비밀번호 찾기
	 * @param farmer
	 * @return
	 */
	public Farmer findPw(Farmer farmer);
	
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
	public boolean updatePw(Farmer farmer);


	
	
}
