package com.kh.farmapp.admin.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	@RequestMapping(value = "/useradmin/farmerlist", method = RequestMethod.GET)
	public String adminFarmerList() {
		return "";
	}
	
	// 일반 회원 관리 페이지
	@RequestMapping(value = "/useradmin/userlist", method = RequestMethod.GET)
	public String adminUserList() {
		return "admin/member/admin_user_list";
	}
	
	// 농업인 회원 신청 관리 페이지
	@RequestMapping(value = "/useradmin/fapplicationlist", method = RequestMethod.GET)
	public String adminFarmerApplicationList() {
		return "";
	}
	
	// 농업인 회원 신청 관리 상세 페이지
	@RequestMapping(value = "/useradmin/fapplicationdetail", method = RequestMethod.GET)
	public String adminFarmerApplicationDetail() {
		return "";
	}
	
	// 농업인 회원 신청 승인
	@RequestMapping(value = "/useradmin/approvefapplication", method = RequestMethod.POST)
	public void approveFarmerApplication(Farmer farmer) {
	}
	
	// 농업인 회원 신청 보류
	@RequestMapping(value = "/useradmin/putfapplicationonhold", method = RequestMethod.POST)
	public void putFarmerApplicationOnHold(Farmer farmer) {
	}
	
	// 일반 회원 정지
	@RequestMapping(value = "/useradmin/pauseuser", method = RequestMethod.POST)
	public void pauseUser(UserTB user) {
	}
	
	// 일반 회원 탈퇴
	@RequestMapping(value = "/useradmin/deleteuser", method = RequestMethod.POST)
	public void deleteUser(UserTB user) {
	}
	
	// 농업인 회원 정지
	@RequestMapping(value = "/useradmin/pausefarmer", method = RequestMethod.POST)
	public void pauseFarmer(Farmer farmer) {
	}
	
	// 농업인 회원 탈퇴
	@RequestMapping(value = "/useradmin/deletefarmer", method = RequestMethod.POST)
	public void deleteFarmer(Farmer farmer) {
	}
	
}
