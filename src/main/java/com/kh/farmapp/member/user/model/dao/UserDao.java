package com.kh.farmapp.member.user.model.dao;

import java.util.Map;

import common.dto.UserTB;

public interface UserDao {
	
	/**
	 * 회원 가입
	 * @param user
	 * @return int - 등록 성공여부
	 */
	public int insertUser(UserTB user);
	
	/**
	 * 로그인할때 회원 선택
	 * @param commandMap
	 * @return User
	 */
	public UserTB selectUser(Map<String, Object> commandMap);
	
	/**
	 * 전화번호로 아이디 찾기
	 * @param userPhone
	 * @return int
	 */
	public int findUserId(String userPhone);
	
	/**
	 * 비밀번호 업데이트하기
	 * @param user
	 * @return int
	 */
	public int updatePw(UserTB user);

	/**
	 * 중복 아이디 확인
	 * @param userId
	 * @return int
	 */
	public int selectIdCheck(String userId);
	
}
