package com.kh.farmapp.farmpersonalpage.farmintroduce.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.farmpersonalpage.personalproduce.model.service.PersonalProduceService;

@Controller
public class FarmIntroduceController {
	
	@Autowired
	private PersonalProduceService personalproduceService; 
	
	@RequestMapping(value = "/farmintroduce/farmintroduceForm.do", method = RequestMethod.GET)
	public ModelAndView farmqnaList(
			HttpSession session
			, String farmerNo
			) {
		
		// 파라미터용 farmNo 조회  * 수정이가 수정 *
		int farmNo = personalproduceService.selectFarmNoByFarmerNo(farmerNo);
		
		System.out.println("농장소개페이지 접속");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("farmintroduce/farmintroduceForm");
		// model 값 넘기기
		mav.addObject("farmerNo", farmerNo);
		
		// 파라미터용 farmNo View에 넘겨주기  * 수정이가 수정 *
		if( farmNo != 0) {
			mav.addObject("farmNo", farmNo);
		}
		
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
