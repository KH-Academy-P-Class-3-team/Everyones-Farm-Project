package com.kh.farmapp.admin.oneonone.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.farmapp.admin.model.service.AdminOneOnOneService;

import common.dto.AnsweredOneonone;
import common.dto.QuestionOneonone;
import common.util.AdminPaging;


@Controller
public class AdminOneOnOneController {

	// member field
	private static final int USER_CODE = 1;
	
	// log 를 남기기 위한 Logger 객체
	private static final Logger logger = LoggerFactory.getLogger(AdminOneOnOneController.class);

	// service 객체
	@Autowired
	private AdminOneOnOneService adminOneOnOneService;

	// 일반 회원 1대1 문의 목록 페이지
	@RequestMapping(value = "/admin/oneonone/user", method = RequestMethod.GET)
	public String adminUserOneOnOneList(
				Model model
				// 페이징 처리시 필요한 변수
				, @RequestParam(defaultValue = "0") String curPage
				// 검색 처리시 필요한 변수
				, @RequestParam(defaultValue = "") String search
			) {
		
		// logger 찍기
		logger.info("/admin/oneonone/user - [GET] 요청");
		
		// 페이징 설정에 대한 정보를 갖는 Map 객체
		Map<String, Object> pagingConfig = new HashMap<>();
		pagingConfig.put("curPage", curPage);
		pagingConfig.put("search", search);
		pagingConfig.put("listCode", USER_CODE);
		logger.debug("pagingConfig: " + pagingConfig);
		
		// 페이징 설정
		AdminPaging apaging = adminOneOnOneService.getPaging(pagingConfig);
		logger.debug("apaging: " + apaging.toString());
		
		// list 불러오기
		List<Map<String, Object>> userOneOnOneList = adminOneOnOneService.selectAllUserOneOnOneList(apaging);
		for(Map<String, Object> q: userOneOnOneList) {
			logger.debug("q: " + q.toString());
		}
		
		// model 값 넘겨주기
		// 페이징 객체 넘기기
		if( apaging != null ) {
			
			model.addAttribute("apaging", apaging);
			
		}
		// 페이징 처리된 목록 넘기기
		if( userOneOnOneList != null ) {
			
			model.addAttribute("userOneOnOneList", userOneOnOneList);
			
		}
		
		return "admin/oneonone/userlist";
	}
	
	// 농업인 회원 1대1 문의 목록 페이지
	@RequestMapping(value = "/admin/oneonone/farmer", method = RequestMethod.GET)
	public String adminFarmerOneOnOneList() {
		return "";
	}
	
	// 일반 회원 1대1 문의 상세 페이지
	@RequestMapping(value = "/admin/oneonone/user/detail", method = RequestMethod.GET)
	public String adminUserOneOnOneDetail(
			// question_no 값을 갖는 QuestionOneOnOne
			QuestionOneonone q
			) {
		
		logger.info("/admin/oneonone/user/detail - [GET] 요청");
		
		logger.debug("questionNo: " + q.getQuestionNo());
		
		return "admin/oneonone/user_detail";
	}
	
	// 농업인 회원 1대1 문의 상세 페이지
	@RequestMapping(value = "/admin/oneonone/farmer/detail", method = RequestMethod.GET)
	public String adminFarmerOneOnOneDetail(QuestionOneonone q) {
		return null;
	}
	
	// 일반 회원 1대1 답변 작성 폼 페이지
	@RequestMapping(value = "/admin/oneonone/user/write", method = RequestMethod.GET)
	public void writeAnswerToUser() {
	}
	
	// 일반 회원 1대1 답변 작성
	@RequestMapping(value = "/admin/oneonone/user/write", method = RequestMethod.POST)
	public String writeAnswerToUserProc(AnsweredOneonone answer) {
		return "";
	}
	
	// 농업인 회원 1대1 답변 작성 폼 페이지
	@RequestMapping(value = "/admin/oneonone/farmer/write", method = RequestMethod.GET)
	public void writeAnswerToFarmer() {
	}
	
	// 농업인 회원 1대1 답변 작성
	@RequestMapping(value = "/admin/oneonone/farmer/write", method = RequestMethod.POST)
	public String writeAnswerToFarmerProc(AnsweredOneonone answer) {
		return "";
	}
	
	// 일반 회원 1대1 답변 수정 폼 페이지
	@RequestMapping(value = "/admin/oneonone/user/update", method = RequestMethod.GET)
	public void modifyAnswerToUser() {
	}
	
	// 일반 회원 1대1 답변 수정
	@RequestMapping(value = "/admin/oneonone/user/update", method = RequestMethod.POST)
	public String modifyAnswerToUserProc(AnsweredOneonone modifyAnswer) {
		return "";
	}
	
	// 농업인 회원 1대1 답변 수정 폼 페이지
	@RequestMapping(value = "/admin/oneonone/farmer/update", method = RequestMethod.GET)
	public void modifyAnswerToFarmer() {
	}
	
	// 농업인 회원 1대1 답변 수정
	@RequestMapping(value = "/admin/oneonone/farmer/update", method = RequestMethod.POST)
	public String modifyAnswerToFarmerProc(AnsweredOneonone modifyAnswer) {
		return "";
	}
	
	// 일반인 회원 1대1 답변 삭제
	@RequestMapping(value = "/admin/oneonone/user/delete", method = RequestMethod.POST)
	public String deleteAnswerToUser(AnsweredOneonone deleteAnswer) {
		return "";
	}
	
	// 농업인 회원 1대1 답변 삭제
	@RequestMapping(value = "/admin/oneonone/farmer/delete", method = RequestMethod.POST)
	public String deleteAnswerToFarmer(AnsweredOneonone deleteAnswer) {
		return "";
	}
	
}
