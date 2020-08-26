package com.kh.farmapp.member.user.model.service;

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
	 * @param user
	 * @return User
	 */
	public UserTB findId(UserTB user);
	
	/**
	 * 비밀번호 찾기
	 * @param user
	 * @return User
	 */
	public UserTB findPw(UserTB user);
	
	/**
	 * 아이디로 찾은 회원 
	 * @param req
	 * @return User
	 */
	public UserTB findUserId(HttpServletRequest req);
	
	/**
	 * 비밀번호찾기 이메일 보내기
	 * @param user
	 * @param urlPath
	 */
	public void findPwMailSend(UserTB user, String urlPath);
	
	/**
	 * 비밀번호 업데이트
	 * @param user
	 * @return true/false - 성공실패
	 */
	public boolean updatePw(UserTB user);

	/**
	 * 아이디 중복 체크
	 * @param userId
	 * @return int (0보다 크면 불가능함)
	 */
	public int selectIdCheck(String userId);
	
}
