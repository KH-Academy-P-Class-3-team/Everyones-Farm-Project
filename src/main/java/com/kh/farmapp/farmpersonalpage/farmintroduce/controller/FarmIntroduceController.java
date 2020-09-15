package com.kh.farmapp.farmpersonalpage.farmintroduce.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FarmIntroduceController {
	
	@RequestMapping(value = "/farmintroduce/farmintroduceForm.do", method = RequestMethod.GET)
	public ModelAndView farmqnaList(
			HttpSession session
			, String farmerNo
			) {
		
		
		
		System.out.println("농장소개페이지 접속");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("farmintroduce/farmintroduceForm");
		// model 값 넘기기
		mav.addObject("farmerNo", farmerNo);
		
		return mav;
	}
	
//	@RequestMapping("farmintroduce/farmintroduceupload.do")
//	public ModelAndView imgUpload() {
//		
//		ModelAndView mav = new ModelAndView();
//		
//		mav.setViewName("farmdiary/farmimg.do");
//		
//		return mav;
//		
//	}
//	
//	@RequestMapping("farmintroduce/farmimg.do")
//	public void boardForm() {
//		System.out.println("이미지 업로드 완료");
//
//	}
}
