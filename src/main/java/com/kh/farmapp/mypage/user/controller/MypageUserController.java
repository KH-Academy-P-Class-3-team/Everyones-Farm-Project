package com.kh.farmapp.mypage.user.controller;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.admin.oneonone.controller.AdminOneOnOneController;
import com.kh.farmapp.mypage.user.model.service.MyPageService;

import common.dto.UserProfile;
import common.dto.UserTB;

@Controller
public class MypageUserController {

	@Autowired
	private MyPageService mypageService;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	//마이 페이지 메인으로 보내는 메서드
	@RequestMapping("mypage/user/modify")
	public ModelAndView mypage(HttpSession session) {
		
		UserTB user = (UserTB) session.getAttribute("userInfo");
		
		ModelAndView mav = new ModelAndView();

		if( user == null) {
			mav.addObject("alertMsg", "로그인이 필요합니다.");
			mav.addObject("url", "../../user/login.do");
			mav.setViewName("common/result");
			return mav;
		}
		
		UserProfile profile = new UserProfile();
		
		
		user = mypageService.selectUser(user);
		
		profile = mypageService.selectUserProfile(user);
		
		mav.addObject("userData", user);
		mav.addObject("profile", profile);
		mav.setViewName("mypage/user/modify");
		
		return mav;
		
	}
	
	//회원 정보를 수정한다
	@RequestMapping("/modify/userInfo")
	public String modifyPirvate(UserTB user, HttpSession session, MultipartFile upload) {
		
		UserTB user2 = (UserTB) session.getAttribute("userInfo");
		int userno = user2.getUserNo();
		
		user.setUserNo(userno);
		mypageService.modifyUser(user);
			
		return "redirect:/mypage/user/modify";
		
	}
	//회원 정보를 수정한다
	@RequestMapping("/modify/profile")
	public String modifyProfile(UserTB user, HttpSession session, MultipartFile upload) {
		
		UserTB user2 = (UserTB) session.getAttribute("userInfo");
		int userno = user2.getUserNo();
		
		String root  = session.getServletContext().getRealPath("/");
		
		user.setUserNo(userno);
		mypageService.modifyUserProfile(user, root, upload);
		
		return "redirect:/mypage/user/modify";
		
	}
	
	@RequestMapping("/modify/emailcheck")
	@ResponseBody
	public String emailCheck(String email, HttpSession session) {
		UserTB user = (UserTB) session.getAttribute("userInfo");
		int res = mypageService.selectEmailCheck(email, user);
		
		if(res>0) {
			return email;
		} else {
			return "";
		}
	}
	
	//전화번호 중복 체크
	@RequestMapping("/modify/phonecheck")
	@ResponseBody
	public String phoneCheck(String phone, HttpSession session) {
		UserTB user = (UserTB) session.getAttribute("userInfo");
		int res = mypageService.selectPhoneCheck(phone, user);
		
		if(res>0) {
			return phone;
		} else {
			return "";
		}
	}
	
	

	
	@RequestMapping("mypage/user/deleteId")
	public void deleteID(HttpSession session, Model model) {
		
	}
	
	

	//회원 탈퇴 하는 메서드
	@RequestMapping("leave")
	public ModelAndView leave(HttpSession session,
			String userPW) {
		ModelAndView mav = new ModelAndView();
		UserTB ckUser = (UserTB) session.getAttribute("userInfo");
		
		ckUser = mypageService.selectUser(ckUser);
		
		if(passwordEncoder.matches(userPW, ckUser.getUserPw())) {

			int res = mypageService.leave(ckUser);
			
			if(res > 0) {
				session.removeAttribute("userInfo");
				mav.addObject("alertMsg", "탈퇴되었습니다. 감사했습니다 안녕히가세요.");
				mav.addObject("url", "/farmapp");
				mav.setViewName("common/result");
			}else {
				mav.addObject("alertMsg", "탈퇴 거부되었습니다.");
				mav.addObject("url", "mypage/user/deleteId");
				mav.setViewName("common/result");
			}
		}else {
			mav.addObject("alertMsg", "비밀번호가 일치하지 않습니다.");
			mav.addObject("url", "mypage/user/deleteId");
			mav.setViewName("common/result");
		}
		
		
		return mav;
	}




}
