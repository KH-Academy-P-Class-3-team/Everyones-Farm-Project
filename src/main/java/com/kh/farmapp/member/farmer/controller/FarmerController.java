package com.kh.farmapp.member.farmer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.member.farmer.model.service.FarmerService;

import common.dto.Farm;
import common.dto.Farmer;

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
	@RequestMapping(value="/farmertos.do")
	public String tos() {
		return "member/farmertos";
	}
	
	//회원가입
	@RequestMapping("/joinimpl.do")
	public String joinImpl(
			@ModelAttribute Farmer farmer
			, @ModelAttribute Farm farm
			, Model model
			, HttpServletRequest req
			) {
		
		String root = req.getContextPath();
		int res = farmerService.insertFarmer(farmer);
		int res2 = farmerService.insertFarm(farm);
		if(res>0) {
			model.addAttribute("alertMsg", "회원가입에 성공했습니다");
			model.addAttribute("url", root+"/user/userlogin.do");
		} else {
			model.addAttribute("alertMsg", "회원가입에 실패했습니다");
			model.addAttribute("url", root+"/user/userjoin.do");
		}
		
		return "common/result";
		
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
