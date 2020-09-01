package com.kh.farmapp.admin.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.farmapp.admin.model.service.AdminMainService;


@Controller
public class AdminMainController {

	// log 를 남기기 위한 Logger 객체
	private static final Logger logger = LoggerFactory.getLogger(AdminMainController.class);
	
	@Autowired
	private AdminMainService adminMainService;
	
	// 관리자 페이지 메인
	@RequestMapping(value = "/admin/main", method = RequestMethod.GET)
	public String adminMain() {
		
		logger.info("/admin/main - [GET] 요청");
		
		return "admin/admin_main";
	}
	
}
