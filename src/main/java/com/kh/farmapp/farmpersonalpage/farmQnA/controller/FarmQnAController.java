package com.kh.farmapp.farmpersonalpage.farmQnA.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.farmpersonalpage.farmQnA.model.service.FarmQnAService;

@Controller
public class FarmQnAController {

	@Autowired
	private FarmQnAService farmqnaService;

	//QnA 작성 화면
	@RequestMapping(value = "/farmQnA/farmQnAwrite.do", method = RequestMethod.GET)
	public void farmdiaryqnaWrite() {
		System.out.println("wrtie 페이지 접속 완료");

	}

	//QnA 일기 작성
	@RequestMapping(value = "/QnA/QnAwrite.do", method = RequestMethod.POST)
	public String diaryqnaWrite(
			@RequestParam Map<String, Object> commandMap) {

		farmqnaService.writeFarmQnA(commandMap);

		System.out.println(commandMap);

		return "redirect:/farmQnA/farmQnAlist.do";
	}

	//QnA 리스트 화면
	@RequestMapping(value = "/farmQnA/farmQnAlist.do", method = RequestMethod.GET)
	public ModelAndView farmdiaryList(@RequestParam(required = false, defaultValue = "1") int cPage) {

		ModelAndView mav = new ModelAndView();

		int cntPerPage = 10;

		Map<String,Object> res = farmqnaService.selectFarmQnAList(cPage, cntPerPage);
		mav.addObject("paging", res.get("paging"));
		mav.addObject("list", res);
		mav.setViewName("farmQnA/farmQnAlist");


		//		System.out.println(res);

		return mav;
	}

	//상세조회 화면
	@RequestMapping(value = "/farmQnA/farmQnAdetail.do", method = RequestMethod.GET)
	public ModelAndView farmdiaryDetail(int farmQnaQuestionNo) {

		ModelAndView mav = new ModelAndView();

		Map<String, Object> res = farmqnaService.selectQnADetail(farmQnaQuestionNo);
		mav.addObject("detail", res);
		mav.setViewName("farmQnA/farmQnAdetail");

		return mav;

	}

	//게시글 삭제
	@RequestMapping(value = "/farmQnA/farmQnAdelete.do", method = RequestMethod.GET )
	public String deleteQnA(@RequestParam(value="farmQnaQuestionNo") int farmQnaQuestionNo) {

		farmqnaService.deleteQnA(farmQnaQuestionNo);

		return "redirect:/farmQnA/farmQnAlist.do";
	}

//	//게시글 수정 화면
//	@RequestMapping(value = "/farmdiary/farmdiarymodify.do", method = RequestMethod.GET)
//	public ModelAndView farmdiaryModify(int farmDiaryNo) {
//		System.out.println("수정 페이지 접속 완료");
//
//		ModelAndView mav = new ModelAndView();
//
//		Map<String, Object> res = farmdiaryService.selectFarmDiaryDetail(farmDiaryNo);
//		mav.addObject("detail", res);	
//
//		return mav;
//	}
//	//게시글 수정
//	@RequestMapping(value = "/diary/diarymodify.do", method = RequestMethod.POST)
//	public ModelAndView diarymodify(@RequestParam Map<String, Object> commandMap) {
//
//		ModelAndView mav = new ModelAndView();
//
//		farmdiaryService.modifyFarmDiary(commandMap);
//
//		mav.setViewName("redirect:/farmdiary/farmdiarylist.do");
//
//		return mav;
//	}

}
