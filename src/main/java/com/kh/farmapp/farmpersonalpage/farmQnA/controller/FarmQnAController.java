package com.kh.farmapp.farmpersonalpage.farmQnA.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.farmapp.farmpersonalpage.farmQnA.model.service.FarmQnAService;
import com.kh.farmapp.farmpersonalpage.personalproduce.model.service.PersonalProduceService;

import common.dto.Farm;
import common.dto.FarmQnaAnswer;
import common.dto.Farmer;
import common.dto.UserTB;
import common.dto.test.SearchCriteria;

@Controller
public class FarmQnAController {

	@Autowired
	private FarmQnAService farmqnaService;
	
	@Autowired
	private PersonalProduceService personalproduceService; 
	
	//QnA 작성 화면
	@RequestMapping(value = "/farmQnA/farmQnAwrite.do", method = RequestMethod.GET)
	public void farmqnaWrite(
			String farmerNo
			, Model model
			) {
//		System.out.println("wrtie 페이지 접속 완료");		
		System.out.println("FarmQnAController farmerNo: " + farmerNo);
		if( farmerNo != null ) {
			model.addAttribute("farmerNo", farmerNo);
		}

	}

	//QnA 작성
	@RequestMapping(value = "/QnA/QnAwrite.do", method = RequestMethod.POST)
	public String qnaWrite(@RequestParam Map<String, Object> commandMap, String farmerNo, Model model
			, HttpSession session) {

		UserTB insertUserData = (UserTB) session.getAttribute("userInfo");
		Farmer inserFarmerData = (Farmer) session.getAttribute("farmerInfo");
		
		int farmNo = farmqnaService.selectFarmNoByFarmerNo2(farmerNo);
		
		if(insertUserData != null) {
			commandMap.put("farmNo", farmNo);
			commandMap.put("userNo", insertUserData.getUserNo());
			System.out.println("/QnA/QnAwrite.do - insertUserData: " + commandMap.get("insertUserData"));
			int res = farmqnaService.insertFarmQna(commandMap);
		}
		if(inserFarmerData != null) {
			commandMap.put("farmNo", farmNo);
			commandMap.put("farmerNo", inserFarmerData.getFarmerNo());
			System.out.println("/QnA/QnAwrite.do - insertUserData: " + commandMap.get("insertUserData"));
			int res = farmqnaService.insertFarmerFarmQna(commandMap);
			
		}
		
	

		return "redirect:/farmQnA/farmQnAlist.do?farmerNo="+farmerNo;
	}

	//QnA 리스트 화면
	@RequestMapping(value = "/farmQnA/farmQnAlist.do", method = RequestMethod.GET)
	public ModelAndView farmdiaryList(@RequestParam(required = false, defaultValue = "1") int cPage, String farmerNo) {

		ModelAndView mav = new ModelAndView();
		
		// 파라미터용 farmNo 조회  * 수정이가 수정 *
		int farmNo = personalproduceService.selectFarmNoByFarmerNo(farmerNo);
//		int farmNo = farmqnaService.selectFarmNoByFarmerNo2(farmerNo);
		System.out.println("FarmQnAController farmNo: " + farmNo);
		
		int cntPerPage = 10;
		
//		System.out.println("FarmQnAContorller - farmerNo: " + farmerNo);
		
		Map<String,Object> res = farmqnaService.selectFarmQnAList(cPage, cntPerPage, farmNo);
		
		mav.addObject("farmerNo", farmerNo);
		mav.addObject("paging", res.get("paging"));
		mav.addObject("list", res.get("fdlist"));
		mav.setViewName("farmQnA/farmQnAlist");
		
//		System.out.println("컨트롤러값"+res);
//		System.out.println(mav);
		//		System.out.println(res);
		if( farmNo != 0) {
			mav.addObject("farmNo", farmNo);
		}
		
		return mav;
	}

	//상세조회 화면
	@RequestMapping(value = "/farmQnA/farmQnAdetail.do", method = RequestMethod.GET)
	public ModelAndView farmdiaryDetail(int farmQnaQuestionNo) {

		ModelAndView mav = new ModelAndView();

		Map<String, Object> res = farmqnaService.selectQnADetail(farmQnaQuestionNo);
		mav.addObject("detail", res);
		mav.setViewName("farmQnA/farmQnAdetail");
		
		List<FarmQnaAnswer> al = farmqnaService.selectAnswerList(farmQnaQuestionNo);
		mav.addObject("answerlist",al);
		return mav;

	}

	//게시글 삭제
	@RequestMapping(value = "/farmQnA/farmQnAdelete.do", method = RequestMethod.GET )
	public String deleteQnA(@RequestParam(value="farmQnaQuestionNo") int farmQnaQuestionNo, String farmerNo) {

		farmqnaService.deleteQnA(farmQnaQuestionNo);

		return "redirect:/farmQnA/farmQnAlist.do?farmQnaQuestionNo="+farmQnaQuestionNo+"&farmerNo="+farmerNo;
	}

	//게시글 수정 화면
	@RequestMapping(value = "/farmQnA/farmQnAmodify.do", method = RequestMethod.GET)
	public ModelAndView farmdiaryModify(int farmQnaQuestionNo) {
//		System.out.println("수정 페이지 접속 완료");

		ModelAndView mav = new ModelAndView();

		Map<String, Object> res = farmqnaService.selectQnADetail(farmQnaQuestionNo);
		mav.addObject("detail", res);	

		return mav;
	}
	//게시글 수정
	@RequestMapping(value = "/QnA/QnAmodify.do", method = RequestMethod.POST)
	public ModelAndView diarymodify(@RequestParam Map<String, Object> commandMap, int farmQnaQuestionNo) {

		ModelAndView mav = new ModelAndView();

		farmqnaService.modifyQnA(commandMap);

		mav.setViewName("redirect:/farmQnA/farmQnAdetail.do?farmQnaQuestionNo="+farmQnaQuestionNo);

		return mav;
	}
		
	//QnA 답글 작성
	@RequestMapping(value = "/QnA/QnAanswerwrite.do", method = RequestMethod.POST)
	public String answerInsert(FarmQnaAnswer farmqnaAnswer, SearchCriteria scri, RedirectAttributes rttr, String farmerNo) {
		
		farmqnaService.writeAnswer(farmqnaAnswer);
		
		rttr.addAttribute("farmQnaQuestionNo", farmqnaAnswer.getFarmQnaQuestionNo());
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/farmQnA/farmQnAdetail.do?farmerNo="+farmerNo;
	}
}
