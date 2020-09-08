package com.kh.farmapp.admin.user.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.farmapp.admin.model.service.AdminUserService;

import common.dto.Farmer;
import common.dto.UserTB;

@Controller
public class AdminUserController {

	// log 를 남기기 위한 Logger 객체
	private static final Logger logger = LoggerFactory.getLogger(AdminUserController.class);
	
	// service 객체
	@Autowired
	private AdminUserService adminUserService;
	
	// 농업인 회원 관리 페이지
	@RequestMapping(value = "/adminmember/farmerlist", method = RequestMethod.GET)
	public String adminFarmerList() {
		return "";
	}
	
	// 일반 회원 관리 페이지
	@RequestMapping(value = "/adminmember/userlist", method = RequestMethod.GET)
	public String adminUserList(
				Model model
			) {
		
		// logger 찍기 - 해당 url에 들어왔다는 표시
		logger.info("/adminmember/userlist [GET] 요청");
		
		// select 조회 연산 수행
		List<Map<String, Object>> userList = adminUserService.selectAllUserList();
		for(Map< String, Object> m : userList) {
			logger.debug("m: " + m.toString());
		}
		
		return "admin/member/admin_user_list";
	}
	
	// 농업인 회원 신청 관리 페이지
	@RequestMapping(value = "/adminmember/fapplicationlist", method = RequestMethod.GET)
	public String adminFarmerApplicationList() {
		return "";
	}
	
	// 농업인 회원 신청 관리 상세 페이지
	@RequestMapping(value = "/adminmember/fapplicationdetail", method = RequestMethod.GET)
	public String adminFarmerApplicationDetail() {
		return "";
	}
	
	// 농업인 회원 신청 승인
	@RequestMapping(value = "/adminmember/approvefapplication", method = RequestMethod.POST)
	public void approveFarmerApplication(Farmer farmer) {
	}
	
	// 농업인 회원 신청 보류
	@RequestMapping(value = "/adminmember/putfapplicationonhold", method = RequestMethod.POST)
	public void putFarmerApplicationOnHold(Farmer farmer) {
	}
	
	// 일반 회원 정지
	@RequestMapping(value = "/adminmember/pauseuser", method = RequestMethod.POST)
	public void pauseUser(UserTB user) {
	}
	
	// 일반 회원 탈퇴
	@RequestMapping(value = "/adminmember/deleteuser", method = RequestMethod.POST)
	public void deleteUser(UserTB user) {
	}
	
	// 농업인 회원 정지
	@RequestMapping(value = "/adminmember/pausefarmer", method = RequestMethod.POST)
	public void pauseFarmer(Farmer farmer) {
	}
	
	// 농업인 회원 탈퇴
	@RequestMapping(value = "/adminmember/deletefarmer", method = RequestMethod.POST)
	public void deleteFarmer(Farmer farmer) {
	}
	
}
