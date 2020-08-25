package com.kh.farmapp.mypage.user.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.mypage.user.model.service.MyPageService;

public class MypageAppliController {

	private MyPageService mypageService;

	//김진규의 파트 
	
	//활동현황 신청보기 (체험농장)-ajax
	public ModelAndView appliActList(@RequestParam(required=false, defaultValue="1") int cPage) {
		return null;
	}	


	//활동현황 신청보기 (일손 돕기)-ajax
	public ModelAndView appliHelpList(@RequestParam(required=false, defaultValue="1") int cPage) {
		return null;
	}

}
