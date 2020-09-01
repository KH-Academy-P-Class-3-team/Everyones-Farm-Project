package com.kh.farmapp.admin.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.farmapp.admin.model.service.AdminLoginService;

@Controller
public class AdminLoginController {

	// log 를 남기기 위한 Logger 객체
	private static final Logger logger = LoggerFactory.getLogger(AdminLoginController.class);
	
	@Autowired
	private AdminLoginService adminLoginService;
	
	// 관리자 로그인 페이지
	@RequestMapping(value = "/admin/login", method = RequestMethod.GET)
	public String adminLogin() {
		return "admin/login/alogin";
	}
	
	// 관리자 로그인 동작
	@RequestMapping(value = "/admin/login", method = RequestMethod.POST)
	public String adminLoginProc() {
		return "";
	}
}
