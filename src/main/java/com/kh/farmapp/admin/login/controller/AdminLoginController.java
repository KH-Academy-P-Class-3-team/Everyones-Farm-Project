package com.kh.farmapp.admin.login.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.farmapp.admin.model.service.AdminLoginService;

import common.dto.Admin;

@Controller
public class AdminLoginController {

	// log 를 남기기 위한 Logger 객체
	private static final Logger logger = LoggerFactory.getLogger(AdminLoginController.class);
	
	@Autowired
	private AdminLoginService adminLoginService;
	
	// 관리자 로그인 페이지
	@RequestMapping(value = "/admin/login", method = RequestMethod.GET)
	public String adminLogin(
			Model model
			, HttpSession session
			) {
		
		// 로그인이 되어 있다면, session 영역에 adminInfo 값이 들어 있다면
		if( session.getAttribute("adminInfo") != null) {
			// 관리자 메인 화면으로 이동
			model.addAttribute("alertMsg", "이미 로그인이 되어있습니다.");
			model.addAttribute("url", "main");
			return "common/result";
		}
		
		// 로그 찍기
		logger.info("AdminLoginController : /admin/login [GET] 요청");
		
		return "admin/login/alogin";
	}
	
	// 관리자 로그인 동작
	@RequestMapping(value = "/admin/login", method = RequestMethod.POST)
	public String adminLoginProc(
			@ModelAttribute Admin admin
			, Model model
			, HttpSession session
			) {

		// 로그 찍기
		logger.info("AdminLoginController : /admin/login [POST] 요청");
		
		logger.info("admin: " + admin);
		
		Admin selectAdmin = adminLoginService.selectAdminByIdAndPw(admin);
		
		// selectAdmin null 이 아닐 때, 로그인 성공
		if(selectAdmin != null) {
			// 비밀번호 session 영역에 안넘기기
			selectAdmin.setAdminPw(null);
			// session 영역에 로그인 객체 넘기기
			session.setAttribute("adminInfo", selectAdmin);
			
			// 관리자 메인 화면으로 이동
			model.addAttribute("alertMsg", "관리자 로그인에 성공했습니다! 환영합니다.");
			model.addAttribute("url", "main");
			
		} else { // 로그인 실패
			model.addAttribute("alertMsg", "관리자 로그인에 실패했습니다...");
			model.addAttribute("url", "login");
			
		}
		
		return "common/result";
	}
	
	// 관리자 로그아웃 동작
	@RequestMapping(value = "/admin/logout")
	public String adminLogoutProc(
			HttpSession session
			, Model model
			) {
		
		if( session.getAttribute("adminInfo") != null) {
			session.removeAttribute("adminInfo");
			
			model.addAttribute("alertMsg", "관리자 로그아웃이 성공하였습니다! 관리자 페이지는 로그인 상태에서만 들어갈 수 있기 때문에 관리자 로그인 페이지로 이동합니다.");
			model.addAttribute("url", "login");
		} else {
			model.addAttribute("alertMsg", "어떤 이유로 인해 관리자 로그아웃에 실패하였습니다...");
			model.addAttribute("url", "main");
			
		}
		
		return "common/result";
	}
}
