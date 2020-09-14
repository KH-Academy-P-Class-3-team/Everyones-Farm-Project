package com.kh.farmapp.mypage.user.controller;

<<<<<<< HEAD
=======
import java.util.HashMap;
import java.util.List;
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.mypage.user.model.service.MyPageService;

import common.dto.Farmer;
import common.dto.UserTB;

@Controller
public class MypageAppliController {

	@Autowired
	private MyPageService mypageService;

	@RequestMapping("mypage/user/myActive")
	public ModelAndView enterPage(HttpSession session) {
		UserTB user = new UserTB();
		
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> info = mypageService.modifyUser(user);
		
		return mav;
	}
	
	//활동현황 신청보기 (체험농장)-ajax
	public ModelAndView appliActList(@RequestParam(required=false, defaultValue="1") int cPage) {
		return null;
	}	


	//활동현황 신청보기 (일손 돕기)-ajax
	public ModelAndView appliHelpList(@RequestParam(required=false, defaultValue="1") int cPage) {
		return null;
	}

}
