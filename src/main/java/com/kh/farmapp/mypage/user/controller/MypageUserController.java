package com.kh.farmapp.mypage.user.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestParam;
=======
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.admin.oneonone.controller.AdminOneOnOneController;
import com.kh.farmapp.mypage.user.model.service.MyPageService;
<<<<<<< HEAD
=======

import common.dto.Farmer;
import common.dto.UserProfile;
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
import common.dto.UserTB;

@Controller
public class MypageUserController {

	@Autowired
	private MyPageService mypageService;

	//마이 페이지 메인으로 보내는 메서드
	@RequestMapping("mypage/user/modify")
	public ModelAndView mypage(HttpSession session) {
		
		//테스트 데이터
		UserTB user = new UserTB();
		user.setUserNo(1);
		session.setAttribute("userInfo", user);
		
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> info = mypageService.modifyUser(user);
		info.put("USER_NAME", "아무개");
		System.out.println(info);
		mav.addObject("userData", info);
		
		return mav;
		
	}
	
	//회원 정보를 수정한다
<<<<<<< HEAD
	@RequestMapping("modify/userinfo")
	public void modifyPirvate(UserTB user, HttpSession session, Model model) {
	}
	//회원 사진을를 수정한다
	@RequestMapping("modify/userImg")
	public ModelAndView modifyImg(UserTB user, HttpSession session, @RequestParam File file){
		
		
		ModelAndView mav = new ModelAndView();
		String root = session.getServletContext().getRealPath("farmapp/");
		
		mypageService.insertFile(user, file, root);
=======
	@RequestMapping("/modify/userInfo")
	public String modifyPirvate(UserTB user, HttpSession session, MultipartFile upload) {
		
		UserTB user2 = (UserTB) session.getAttribute("userInfo");
		int userno = user2.getUserNo();
		
		String root  = session.getServletContext().getRealPath("/");
		
		user.setUserNo(userno);
		System.out.println("테스트"+upload.getName()+"테스트2"+upload.getOriginalFilename() );
		mypageService.modifyUser(user, root, upload);
			
		return "redirect:/mypage/user/modify";
			
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
		
		return null;
	}
	
	

	
	@RequestMapping("mypage/user/deleteId")
	public void mypage1() {
	}

<<<<<<< HEAD

	//회원 사진을 수정한다.
	public String modifyprofile(UserTB user, HttpSession session, Model model) {
		return "";
	}
=======
	//회원 탈퇴 하는 메서드
	@RequestMapping("leave")
	public ModelAndView leave(HttpSession session,
			String userPW) {
		ModelAndView mav = new ModelAndView();
		UserTB ckUser = (UserTB) session.getAttribute("userInfo");
		
		ckUser = mypageService.selectUser(ckUser);
		
		if(passwordEncoder.matches(userPW, ckUser.getUserPw())) {
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05

	//회원 탈퇴 하는 메서드
	public String leave(HttpSession session,
			UserTB user, String userId) {
		return "";
	}




}
