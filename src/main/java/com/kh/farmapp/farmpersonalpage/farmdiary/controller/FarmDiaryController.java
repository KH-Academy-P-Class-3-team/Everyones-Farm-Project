package com.kh.farmapp.farmpersonalpage.farmdiary.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.farmpersonalpage.farmdiary.model.service.FarmDiaryService;

import common.dto.FarmDiary;


@Controller
public class FarmDiaryController {
	
	@Autowired
	FarmDiaryService farmdiaryService;

	//농장 일기 작성 화면
	@RequestMapping("/farmdiary/farmdiarywrite.do")
	public void farmdiaryWrite() {
		System.out.println("wrtie 페이지 접속 완료");
		
	}
	
	//농장 일기 작성
	@RequestMapping("/diary/diarywrite.do")
	public String diaryWrite(
			@RequestParam Map<String, Object> commandMap) {

		farmdiaryService.writeFarmDiary(commandMap);
		
		
		return "redirect:/farmdiary/farmdiarylist.do";
	}
	
	//농장일기 리스트
	@RequestMapping("/farmdiary/farmdiarylist.do")
	public ModelAndView farmdiaryList(@RequestParam(required = false, defaultValue = "1") int cPage) {
		
		ModelAndView mav = new ModelAndView();
		
		int cntPerPage = 10;
		
		Map<String,Object> res = farmdiaryService.selectFarmDiaryList(cPage, cntPerPage);
		mav.addObject("paging", res.get("paging"));
		mav.addObject("list", res);
		mav.setViewName("farmdiary/farmdiarylist");

		
		
		
		return mav;
	}
	
	@RequestMapping("/farmdiary/farmdiarydetail.do")
	public String farmdiaryDetail(FarmDiary farmdiary, Model model) {
		
		System.out.println("상세페이지 접속완료");
		System.out.println(farmdiary);
		
		model.addAttribute("detail", farmdiaryService.selectFarmDiaryDetail(farmdiary.getFarmDiaryNo()));
		
		
//		Map<String,Object> farmdiary = farmdiaryService.selectFarmDiaryDetail(dailyNo);
	
//		ModelAndView mav = new ModelAndView(); 
		
//		mav.setViewName("/farmdiary/farmdiarydetail");
//		mav.addObject("data", farmdiary);
		
//		if(data.get("farmdiary") != null) {
//			
//		}else {
//			mav.addObject("alertMsg", "해당 게시물이 존재하지 않습니다");
//			mav.addObject("back", "back");
//			mav.setViewName("common/result");
//		}
		
//		return mav;
		return "farmdiary/farmdiarydetail";
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
