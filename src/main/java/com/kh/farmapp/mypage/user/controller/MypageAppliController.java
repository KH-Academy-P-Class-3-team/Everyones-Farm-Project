package com.kh.farmapp.mypage.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.mypage.user.model.service.MyPageService;

import common.dto.UserTB;

@Controller
public class MypageAppliController {

	@Autowired
	private MyPageService mypageService;

	@RequestMapping("mypage/user/myActive")
	public ModelAndView enterPage(HttpSession session) {
		
		UserTB user = (UserTB) session.getAttribute("userInfo");
		ModelAndView mav = new ModelAndView();
		
		List<Map<String, Object>> activeList = mypageService.appliActList(user);
		
		int res = mypageService.cntApli(user);
		
		for(Map<String, Object> p : activeList) {
			System.out.println(p);
		}
		
		mav.addObject("activeList1", activeList);
		mav.addObject("res", res);
		mav.setViewName("mypage/user/myActive");
		
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
