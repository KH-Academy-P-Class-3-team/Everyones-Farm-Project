package com.kh.farmapp.mypage.user.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

		if( user == null) {
			mav.addObject("alertMsg", "로그인이 필요합니다.");
			mav.addObject("url", "../../user/login.do");
			mav.setViewName("common/result");
			return mav;
		}
		
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
	

}
