package com.kh.farmapp.member.user.model.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import common.dto.UserTB;

public interface UserService {
	
	/**
	 * 회원 가입
	 * @param user
	 * @return int
	 */
	public int insertUser(UserTB user);
	
	/**
	 * 회원 찾기(로그인)
	 * @param commandMap
	 * @return User
	 */
	public UserTB selectUser(Map<String, Object> commandMap);
	
	/**
	 * 가입 이메일 보내기
	 * @param user
	 * @param urlPath
	 */
	public void joinMailSend(UserTB user, String urlPath);
	
	/**
	 * 아이디 찾기
	 * @param commandMap
	 * @return User
	 */
	public UserTB findId(Map<String, Object> commandMap);
	
	/**
	 * 비밀번호 찾기
	 * @param commandMap
	 * @return User
	 */
	public UserTB findPw(Map<String, Object> commandMap);
	
	
	/**
	 * 비밀번호찾기 이메일 보내기
	 * @param user
	 * @param urlPath
	 */
	public void findPwMailSend(UserTB user, String urlPath);
	
	/**
	 * 비밀번호 업데이트
	 * @param user
	 * @return int
	 */
	public int updatePw(UserTB user);

	/**
	 * 아이디 중복 체크
	 * @param userId
	 * @return int (0보다 크면 불가능함)
	 */
	public int selectIdCheck(String userId);

	/**
	 * 이메일 중복 체크
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

	public String getAccessToken(String code);

	public HashMap<String, Object> getUserInfo(String accessToken);
	
}
