package com.kh.farmapp.farmpersonalpage.farmdiary.controller;


import java.util.List;
import java.util.Map;

import javax.activation.CommandMap;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.farmpersonalpage.farmdiary.model.service.FarmDiaryService;

import common.dto.FarmDiary;



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
		
		System.out.println(commandMap);


		return "redirect:/farmdiary/farmdiarylist.do";
	}

	//농장일기 리스트 화면
	@RequestMapping(value = "/farmdiary/farmdiarylist.do", method = RequestMethod.GET)
	public ModelAndView farmdiaryList(@RequestParam(required = false, defaultValue = "1") int cPage) {

		ModelAndView mav = new ModelAndView();

		int cntPerPage = 10;

		Map<String,Object> res = farmdiaryService.selectFarmDiaryList(cPage, cntPerPage);
		System.out.println(res);
		mav.addObject("paging", res.get("paging"));
		mav.addObject("list", res);
		mav.setViewName("farmdiary/farmdiarylist");


//		System.out.println(res);

		return mav;
	}
	
	//상세조회 화면
	@RequestMapping(value = "/farmdiary/farmdiarydetail.do", method = RequestMethod.GET)
	public ModelAndView farmdiaryDetail(int farmDiaryNo) {

		ModelAndView mav = new ModelAndView();

		Map<String, Object> res = farmdiaryService.selectFarmDiaryDetail(farmDiaryNo);
		mav.addObject("detail", res);
		mav.setViewName("farmdiary/farmdiarydetail");

		return mav;

	}
	
	//게시글 수정 화면
	@RequestMapping(value = "/farmdiary/farmdiarymodify.do", method = RequestMethod.GET)
	public ModelAndView farmdiaryModify(int farmDiaryNo) {
		System.out.println("수정 페이지 접속 완료");
		
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> res = farmdiaryService.selectFarmDiaryDetail(farmDiaryNo);
		mav.addObject("detail", res);	
				
		return mav;
	}
	//게시글 수정
	@RequestMapping(value = "/diary/diarymodify.do", method = RequestMethod.POST)
	public ModelAndView diarymodify(@RequestParam Map<String, Object> commandMap) {
		
		ModelAndView mav = new ModelAndView();
		
		farmdiaryService.modifyFarmDiary(commandMap);

		mav.setViewName("redirect:/farmdiary/farmdiarylist.do");
		
		return mav;
	}
	
	//게시글 삭제
	@RequestMapping(value = "/farmdiary/farmdiarydelete.do", method = RequestMethod.GET )
	public String deleteFarmdiary(@RequestParam(value="farmDiaryNo") int farmDiaryNo) {

		farmdiaryService.deleteFarmDiary(farmDiaryNo);

		return "redirect:/farmdiary/farmdiarylist.do";
	}
	


	//파일 업로드
	//	@RequestMapping(value = "/diary/diarywrite.do", method = RequestMethod.POST)
	//	public ModelAndView farmdiaryUpload(
	//			  FarmDiary farmdiary
	//			, @RequestParam List<MultipartFile> files
	//			, HttpSession session
	//			) throws Exception {
	//		
	//		ModelAndView mav = new ModelAndView();
	//		
	//		System.out.println(mav);
	//		
	//		String root = session.getServletContext().getRealPath("/");
	//		Member sessionMember = (Member)session.getAttribute("logInInfo");

	//		if(sessionMember != null) {
	//			notice.setUserId(sessionMember.getUserId());
	//		}else {
	//			notice.setUserId("비회원");
	//		}

	//		farmdiaryService.insertFarmdiaryFile(farmdiary, files, root);
	//		mav.setViewName("farmdiary/farmdiarylist");
	//		return mav;
	//	}	


}
