package com.kh.farmapp.admin.main.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.farmapp.admin.model.service.AdminMainService;

import common.dto.Admin;


@Controller
public class AdminMainController {

	// log 를 남기기 위한 Logger 객체
	private static final Logger logger = LoggerFactory.getLogger(AdminMainController.class);
	
	@Autowired
	private AdminMainService adminMainService;
	
	// 관리자 페이지 메인
	@RequestMapping(value = "/admin/main", method = RequestMethod.GET)
	public String adminMain(
			HttpSession session
			, Model model
			) {
		
		// 로그인이 안되어 있을 경우, 바로 로그인 페이지로 이동
		Admin loginAdmin = (Admin) session.getAttribute("adminInfo");
		if( loginAdmin == null) {
			
			return "redirect:/admin/login";
			
		}
		
		logger.info("/admin/main - [GET] 요청");
		
		return "admin/admin_main";
	}
	
}
