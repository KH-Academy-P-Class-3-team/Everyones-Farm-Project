package com.kh.farmapp.member.farmer.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.member.farmer.model.service.FarmerService;

@Controller
@RequestMapping("/farmer")
public class FarmerController {

	@Autowired
	private FarmerService farmerService;
	
	//로그인 메인창
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {
		
		return "member/login";
	}
	
	//농부 로그인 창
	@RequestMapping(value="/farmerlogin.do",  method=RequestMethod.GET)
	public String farmerlogin() {
		
		return "member/farmerlogin";
	}
	
	//아이디 찾기 창
	@RequestMapping(value="/findid.do")
	public String findId() {
		
		return "member/findId";
	}
	
	//회원가입 창
	@RequestMapping(value="farmerjoin.do")
	public String join() {
		return "member/farmerjoin";
	}
	
	//이용약관 창 띄우기
	@RequestMapping(value="/usertos.do")
	public String tos() {
		return "member/farmertos";
	}
	
//	
//	//관리자에게 승인확인 보내기
//	@RequestMapping("")
//	public ModelAndView SendManager() {
//		ModelAndView mav = new ModelAndView();
//		return mav;
//	}
//	
//	//로그인
//	@RequestMapping("")
//	public String loginImpl() {
//		return null;
//	}
//	
//	//아이디 중복 체크
//	@RequestMapping("")
//	public String idCheck(String UserId) {
//		return null;
//	}
//	
//	//가입 이메일 보내기
//	@RequestMapping
//	public ModelAndView joinEmailCheck() {
//		ModelAndView mav = new ModelAndView();
//		return mav;
//	}
//	
//	//비밀번호 찾기 이메일 보내기
//	@RequestMapping
//	public ModelAndView findPwEmail() {
//		ModelAndView mav = new ModelAndView();
//		return mav;
//	}
//	
//	//로그아웃
//	public void logout(HttpSession session, HttpServletResponse response) {
//		
//	}
}
