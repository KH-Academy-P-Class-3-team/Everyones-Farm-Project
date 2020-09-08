package com.kh.farmapp.mypage.user.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.mypage.user.model.service.MyPageService;

import common.dto.Farmer;
import common.dto.UserProfile;
import common.dto.UserTB;

@Controller
public class MypageUserController {

	@Autowired
	private MyPageService mypageService;

	//마이 페이지 메인으로 보내는 메서드
	@RequestMapping("mypage/user/modify")
	public ModelAndView mypage(HttpSession session) {
		
		UserTB user = (UserTB) session.getAttribute("userInfo");
		UserProfile profile = new UserProfile();
		
		ModelAndView mav = new ModelAndView();
		
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
		
		String root  = session.getServletContext().getRealPath("/");
		
		System.out.println(upload);
		user.setUserNo(userno);
		System.out.println(user);
		mypageService.modifyUser(user, root, upload);
			
		return "redirect:/mypage/user/modify";
			
		
	}
//	//회원 사진을 수정한다.
//	@RequestMapping("mypage/user/modifyImg")
//	public ModelAndView modifyprofile(MultipartFile upload, HttpSession session) {
//		
//		UserTB user = (UserTB) session.getAttribute("userInfo");
//		
//		
//		
//		int res = mypageService.modifyprofile(user, upload, root);
//		
//		ModelAndView mav = new ModelAndView();
//		System.out.println("active");
//		
//		return mav;
//	}

	
	@RequestMapping("mypage/user/deleteId")
	public void deleteID(HttpSession session, Model model) {
		Farmer farmer = (Farmer) session.getAttribute("farmerInfo");
		if(farmer==null) {
			model.addAttribute("farmer", 0);
		}else {
			model.addAttribute("farmer", 1);
		}
		
	}
	
	


	//회원 탈퇴 하는 메서드
	@RequestMapping("leave")
	public ModelAndView leave(HttpSession session,
			String userPW) {
		ModelAndView mav = new ModelAndView();
		UserTB ckUser = (UserTB) session.getAttribute("userInfo");
		
		ckUser = mypageService.selectUser(ckUser);
		
		System.out.println(ckUser.getUserPw());
		System.out.println(userPW);
		
		if(ckUser.getUserPw().equals(userPW)) {
			ckUser.setUserPw(userPW);
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
