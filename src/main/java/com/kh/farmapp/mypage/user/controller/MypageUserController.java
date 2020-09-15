package com.kh.farmapp.mypage.user.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.admin.login.controller.AdminLoginController;
import com.kh.farmapp.admin.oneonone.controller.AdminOneOnOneController;
import com.kh.farmapp.mypage.user.model.service.MyPageService;

import common.dto.Farmer;
import common.dto.UserProfile;
import common.dto.UserTB;

@Controller
public class MypageUserController {

	// log 를 남기기 위한 Logger 객체
	private static final Logger logger = LoggerFactory.getLogger(MypageUserController.class);
	
	@Autowired
	private MyPageService mypageService;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	//마이 페이지 메인으로 보내는 메서드
	@RequestMapping("mypage/user/modify")
	public ModelAndView mypage(HttpSession session) {

		UserTB user = (UserTB) session.getAttribute("userInfo");
		Farmer farmer = (Farmer) session.getAttribute("farmerInfo");
		ModelAndView mav = new ModelAndView();

		if( user == null && farmer == null) {
			mav.addObject("alertMsg", "로그인이 필요합니다.");
			mav.addObject("url", "../../user/login.do");
			mav.setViewName("common/result");
			return mav;
		}

		UserProfile profile = new UserProfile();
		if(farmer == null) {

			user = mypageService.selectUser(user);

			profile = mypageService.selectUserProfile(user);

			mav.addObject("userData", user);
			mav.addObject("profile", profile);
			mav.setViewName("mypage/user/modify");

		}else {

			farmer = mypageService.selectFarmer(farmer);

			profile = mypageService.selectFarmerProfile(farmer);

			mav.addObject("farmerData", farmer);
			mav.addObject("profile", profile);
			mav.setViewName("mypage/user/modify");

		}

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
	@RequestMapping("/modify/farmerInfo")
	public String modifyFarmerPirvate(Farmer farmer, HttpSession session, MultipartFile upload) {
		Farmer farmer2 = (Farmer) session.getAttribute("farmerInfo");
		int farmerNo = farmer2.getFarmerNo();
		System.out.println("farmer : "+farmer);
		farmer.setFarmerNo(farmerNo);
		mypageService.modifyFarmer(farmer);

		return "redirect:/mypage/user/modify";
	}

	@RequestMapping("/modify/profile")
	public ModelAndView modifyProfile(UserTB user, HttpSession session, MultipartFile upload) {

		UserTB user2 = (UserTB) session.getAttribute("userInfo");

		ModelAndView mav = new ModelAndView();
		if(upload.getOriginalFilename() == null) {
			mav.addObject("alertMsg", "변경이 없습니다.");
			mav.addObject("url", "../mypage/user/modify");
			mav.setViewName("common/result");
		}

		String root = session.getServletContext().getRealPath("/");

		mypageService.modifyprofile(user2, upload, root);
		mav.setViewName("redirect:/mypage/user/modify");

		return mav;
	}
	@RequestMapping("/modify/farmerProfile")
	public ModelAndView modifyFarmerProfile(
			UserTB user
			, HttpSession session
			, @RequestParam("upload") MultipartFile upload) {

		Farmer farmer2 = (Farmer) session.getAttribute("farmerInfo");

		// upload test print
		logger.debug("upload: " + upload.toString());
		logger.debug("upload.getSize(): " + upload.getSize());
		logger.debug("upload.getOriginalFilename(): " + upload.getOriginalFilename());
		
		ModelAndView mav = new ModelAndView();
		if(upload.getOriginalFilename() == "" || "".equals(upload.getOriginalFilename() )) {
			mav.addObject("alertMsg", "변경이 없습니다.");
			mav.addObject("url", "../mypage/user/modify");
			mav.setViewName("common/result");
			return mav;
		}

		String root = session.getServletContext().getRealPath("/");
		
		logger.debug("root: " + root);
		logger.debug("upload.isEmpty(): " + upload.isEmpty());

		mypageService.modifyFarmerprofile(farmer2, upload, root);
		mav.setViewName("redirect:/mypage/user/modify");

		return mav;
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
	@RequestMapping("/modify/farmerEmailcheck")
	@ResponseBody
	public String farmerEmailCheck(String email, HttpSession session) {
		Farmer farmer = (Farmer) session.getAttribute("farmerInfo");
		int res = mypageService.selectFarmerEmailCheck(email, farmer);

		if(res>0) {
			return email;
		} else {
			return "";
		}
	}

	//전화번호 중복 체크
	@RequestMapping("/modify/farmerPhonecheck")
	@ResponseBody
	public String farmerPhoneCheck(String phone, HttpSession session) {
		Farmer farmer = (Farmer) session.getAttribute("farmerInfo");
		int res = mypageService.selectFarmerPhoneCheck(phone, farmer);

		if(res>0) {
			return phone;
		} else {
			return "";
		}
	}




	@RequestMapping("mypage/user/deleteId")
	public ModelAndView deleteID(HttpSession session, Model model) {

		UserTB user = (UserTB) session.getAttribute("userInfo");
		Farmer farmer = (Farmer) session.getAttribute("farmerInfo");
		ModelAndView mav = new ModelAndView();

		if( user == null && farmer == null) {
			mav.addObject("alertMsg", "로그인이 필요합니다.");
			mav.addObject("url", "../../user/login.do");
			mav.setViewName("common/result");
			return mav;
		}
		
		mav.setViewName("mypage/user/deleteId");
		return mav;
	}



	//회원 탈퇴 하는 메서드
	@RequestMapping("leave")
	public ModelAndView leave(HttpSession session,
			String userPW) {
		ModelAndView mav = new ModelAndView();
		UserTB ckUser = (UserTB) session.getAttribute("userInfo");
		Farmer ckFarmer = (Farmer) session.getAttribute("farmerInfo");
		ckUser = mypageService.selectUser(ckUser);
		ckFarmer = mypageService.selectFarmer(ckFarmer);
		if(ckUser != null) {

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
		}
		if(ckFarmer != null) {
			
			if(passwordEncoder.matches(userPW, ckFarmer.getFarmerPw())) {
				
				int res = mypageService.farmerLeave(ckFarmer);
				
				if(res > 0) {
					session.removeAttribute("farmerInfo");
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
		}


		return mav;
	}




}
