package com.kh.farmapp.farmpersonalpage.farmdiary.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.farmpersonalpage.farmdiary.model.service.FarmDiaryService;



@Controller
public class FarmDiaryController {
	
	@Autowired
	private FarmDiaryService farmdiaryService;

	//농장 일기 작성 화면
	@RequestMapping(value = "/farmdiary/farmdiarywrite.do", method = RequestMethod.GET)
	public void farmdiaryWrite() {
		System.out.println("wrtie 페이지 접속 완료");
		
	}
	
	//농장 일기 작성
	@RequestMapping(value = "/diary/diarywrite.do", method = RequestMethod.POST)
	public String diaryWrite(
			@RequestParam Map<String, Object> commandMap) {

		farmdiaryService.writeFarmDiary(commandMap);
		
		
		return "redirect:/farmdiary/farmdiarylist.do";
	}
	
	//농장일기 리스트
	@RequestMapping(value = "/farmdiary/farmdiarylist.do", method = RequestMethod.GET)
	public ModelAndView farmdiaryList(@RequestParam(required = false, defaultValue = "1") int cPage) {
		
		ModelAndView mav = new ModelAndView();
		
		int cntPerPage = 10;
		
		Map<String,Object> res = farmdiaryService.selectFarmDiaryList(cPage, cntPerPage);
		mav.addObject("paging", res.get("paging"));
		mav.addObject("list", res);
		mav.setViewName("farmdiary/farmdiarylist");

		
		
		
		return mav;
	}
	
	@RequestMapping(value = "/farmdiary/farmdiarydetail.do", method = RequestMethod.GET)
	public ModelAndView farmdiaryDetail(int farmDiaryNo) {
		
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> res = farmdiaryService.selectFarmDiaryDetail(farmDiaryNo);
		mav.addObject("detail", res);
		mav.setViewName("farmdiary/farmdiarydetail");
		
		System.out.println(mav);
		
		return mav;

	}
	

//	
//	@RequestMapping("diary/diaryboardupload.do")
//	public ModelAndView writeUpload() {
//		
//		ModelAndView mav = new ModelAndView();
//		
//		return mav;
//		
//	}
	
//	
//	
//	
//	@RequestMapping("farmdiary/farmdiarymodify")
//	public void diaryModify() {
//		
//	}
//	
//	@RequestMapping("/farmdiary/farmdiarylist.do")
//	public ModelAndView farmdiaryModify() {
//		
//		ModelAndView mav = new ModelAndView(); 
//		
//		mav.setViewName("farmdiary/farmdiarymodify");
//		
//		return null;
//		
//	}
}
