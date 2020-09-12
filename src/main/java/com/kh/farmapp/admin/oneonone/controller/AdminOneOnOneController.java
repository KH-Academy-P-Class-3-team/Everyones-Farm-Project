package com.kh.farmapp.admin.oneonone.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kh.farmapp.admin.model.service.AdminOneOnOneService;

import common.dto.Admin;
import common.dto.AnsweredOneonone;
import common.dto.EveryonesFarmFile;
import common.dto.QuestionOneonone;
import common.util.AdminPaging;
import common.util.upload.img.CkImageUpload;
import common.util.upload.img.model.service.CkImageUploadService;


@Controller
public class AdminOneOnOneController {

	// member field
	// paging 설정 시 user의 문의, farmer의 문의 중 고르기 위한 코드를 저장하는 변수
	private static final int USER_CODE = 1;
	private static final int FARMER_CODE = 2;
	
	private static final int ANSWERD_ONEONONE_BOARD_NO = 6; 
	
	// log 를 남기기 위한 Logger 객체
	private static final Logger logger = LoggerFactory.getLogger(AdminOneOnOneController.class);

	// service 객체
	@Autowired
	private AdminOneOnOneService adminOneOnOneService;
	
	// file delete 와 연관된 service 객체
	@Autowired
	private CkImageUploadService ckImageUploadService;
	
	// 로컬저장소에 저장된 file delete 와 연관된 controller 객체
	@Autowired
	private CkImageUpload ckImageUpload;

	// 일반 회원 1대1 문의 목록 페이지
	@RequestMapping(value = "/admin/oneonone/user", method = RequestMethod.GET)
	public String adminUserOneOnOneList(
				Model model
				// 페이징 처리시 필요한 변수
				, @RequestParam(defaultValue = "0") String curPage
				// 검색 처리시 필요한 변수
				, @RequestParam(defaultValue = "") String search
				, HttpSession session
			) {
		
		// admin login 안되어 있을 시 로그인 화면으로 redirect
		Admin adminLogin = (Admin) session.getAttribute("adminInfo");
		if( adminLogin == null ) {
			return "redirect:/admin/login";
		}
		
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
	public String adminFarmerOneOnOneList(
			Model model
			// 페이징 처리시 필요한 변수
			, @RequestParam(defaultValue = "0") String curPage
			// 검색 처리시 필요한 변수
			, @RequestParam(defaultValue = "") String search
			, HttpSession sessioin
			) {
		
		// admin login 안되어 있을 시
		Admin adminLogin = (Admin) sessioin.getAttribute("adminInfo");
		if( adminLogin == null ) {
			// admin login 페이지로 redirect
			return "redirect:/admin/login";
		}
		
		// url 요청 logger 찍기
		logger.info("/admin/oneonone/farmer - [GET] 요청");
		
		// 페이징 설정에 대한 정보를 갖는 Map 객체
		Map<String, Object> pagingConfig = new HashMap<>();
		pagingConfig.put("curPage", curPage);
		pagingConfig.put("search", search);
		pagingConfig.put("listCode", FARMER_CODE);
		logger.debug("pagingConfig: " + pagingConfig);
		
		// 페이징 설정
		AdminPaging apaging = adminOneOnOneService.getPaging(pagingConfig);
		logger.debug("apaging: " + apaging.toString());
		
		// list 불러오기
		List<Map<String, Object>> farmerOneOnOneList = adminOneOnOneService.selectAllFarmerOneOnOneList(apaging);
		for(Map<String, Object> q: farmerOneOnOneList) {
			logger.debug("q: " + q.toString());
		}
		
		// model 값 넘겨주기
		// 페이징 객체 넘기기
		if( apaging != null ) {
			
			model.addAttribute("apaging", apaging);
			
		}
		// 페이징 처리된 목록 넘기기
		if( farmerOneOnOneList != null ) {
			
			model.addAttribute("farmerOneOnOneList", farmerOneOnOneList);
			
		}
		
		return "admin/oneonone/farmerlist";
	}
	
	// 일반 회원 1대1 문의 상세 페이지
	@RequestMapping(value = "/admin/oneonone/user/detail", method = RequestMethod.GET)
	public String adminUserOneOnOneDetail(
			// question_no 값을 갖는 QuestionOneOnOne
			QuestionOneonone q
			, Model model
			, HttpSession session
			) {
		
		// adminInfo null 일 때
		Admin adminLogin = (Admin) session.getAttribute("adminInfo");
		if( adminLogin == null ) {
			return "redirect:/admin/main";
		}
		
		// 현재 url 찍기
		logger.info("/admin/oneonone/user/detail - [GET] 요청");
		
		// questionNo 찍어보기
		logger.debug("questionNo: " + q.getQuestionNo());
		
		// questionNo 로 해당 문의글 조회
		Map<String, Object> question = adminOneOnOneService.selectUserOneOnOneByNo(q);
		logger.debug("question: " + question.toString());
		
		// questionNo 로 해당 답글 조회
		Map<String, Object> answer = adminOneOnOneService.selectAnswerOneOnOneByQuestionNo(q);
		if( answer != null ) {
			logger.debug("answer: " + answer.toString());
		}
		
		// 조회된 문의글이 null 값이 아닐 때
		if( question != null ) {
			// model 값 넘겨주기
			model.addAttribute("question", question);
		}
		
		// 조회된 답글이 null 값이 아닐 때
		if( answer != null ) {
			// model 값 넘겨주기
			model.addAttribute("answer", answer);
		}
		
		return "admin/oneonone/user_detail";
	}
	
	// 농업인 회원 1대1 문의 상세 페이지
	@RequestMapping(value = "/admin/oneonone/farmer/detail", method = RequestMethod.GET)
	public String adminFarmerOneOnOneDetail(
			QuestionOneonone q
			, Model model
			, HttpSession session
			) {
		
		// adminInfo null 일 때
		Admin adminLogin = (Admin) session.getAttribute("adminInfo");
		if( adminLogin == null ) {
			return "redirect:/admin/main";
		}
		
		// 현재 url 찍기
		logger.info("/admin/oneonone/farmer/detail - [GET] 요청");
		
		// questionNo 찍어보기
		logger.debug("questionNo: " + q.getQuestionNo());
		
		// questionNo 로 해당 문의글 조회
		Map<String, Object> question = adminOneOnOneService.selectFarmerOneOnOneByNo(q);
		logger.debug("question: " + question.toString());
		
		// questionNo 로 해당 답글 조회
		Map<String, Object> answer = adminOneOnOneService.selectAnswerOneOnOneByQuestionNo(q);
		if( answer != null ) {
			logger.debug("answer: " + answer.toString());
		}
		
		// 조회된 문의글이 null 값이 아닐 때
		if( question != null ) {
			// model 값 넘겨주기
			model.addAttribute("question", question);
		}
		
		// 조회된 답글이 null 값이 아닐 때
		if( answer != null ) {
			// model 값 넘겨주기
			model.addAttribute("answer", answer);
		}
		
		return "admin/oneonone/farmer_detail";
	}
	
	// 1대1 답변 작성
	@RequestMapping(value = "/admin/oneonone/write", method = RequestMethod.POST)
	public String writeAnswerToUserProc(
			// 답변 저장
			AnsweredOneonone answer
			// session
			, HttpSession session
			, Model model
			, String writeCode
			) {
		
		// adminInfo 가 null 인 경우
		Admin adminLogin = (Admin) session.getAttribute("adminInfo");
		if( adminLogin == null ) {

			// 관리자 로그인 화면으로 리다이렉트
			return "redirect:/admin/login";
			
		} else { // admin login이 되어있을 경우 adminInfo 가 not null 인 경우
			
			answer.setAdminNo(adminLogin.getAdminNo());
			
		}
		
		logger.info("/admin/oneonone/user/write - [POST] 요청");

		logger.debug("answer: " + answer.toString());
		logger.debug("adminInfo: " + session.getAttribute("adminInfo").toString());
		
		int insertRes = adminOneOnOneService.writeAnswerToUser(answer);
		logger.debug("insertRes: " + insertRes);
		
		// insert 결과 성공
		if( insertRes >= 1 ) {
			
			// 문의 글의 답변 상태 업데이트
			int updateRes = adminOneOnOneService.updateAnswerStateByQuestionNo(answer);
			logger.debug("updateRes: " + updateRes);
			
			// update 성공시
			if( updateRes >= 1 ) {
				// alert msg
				model.addAttribute("alertMsg", "답변 작성에 성공하였습니다.");
			} else {
				// alert msg
				model.addAttribute("alertMsg", "답변 작성에 성공하였습니다.");
			}
			
		} else { // insert 결과 실패
			
			// alert msg
			model.addAttribute("alertMsg", "답변 작성에 성공하였습니다.");
		}

		// writeCode 저장
		int isFarmer = 0;
		if( writeCode != null && !"".equals(writeCode) ) {
			isFarmer = Integer.parseInt(writeCode);
		}
		
		// 문의 상세 페이지로 리다이렉트
		if( isFarmer != 0 ) {
			switch (isFarmer) {
			case USER_CODE:
				model.addAttribute("url", "user/detail?questionNo=" + answer.getQuestionNo());
				break;
			case FARMER_CODE:
				model.addAttribute("url", "farmer/detail?questionNo=" + answer.getQuestionNo());
				break;
			}
		} 
		
		return "common/result";
	}
	
	// 일반 회원 1대1 답변 수정 폼 페이지
//	@RequestMapping(value = "/admin/oneonone/user/update", method = RequestMethod.GET)
//	public void modifyAnswerToUser() {
//	}
	
	// 일반 회원 1대1 답변 수정
	@RequestMapping(value = "/admin/oneonone/update", method = RequestMethod.POST)
	public String modifyAnswerToUserProc(
				AnsweredOneonone modifyAnswer
				, HttpSession session
				, Model model
				, String updateCode
				) {
		
		// adminLogin null 일 때
		Admin adminLogin = (Admin) session.getAttribute("adminInfo");
		if( adminLogin == null ) {
			
			return "redirect:/admin/login";
		} else {
			
			// modifyAnswer 객체에 adminNo 설정
			modifyAnswer.setAdminNo(adminLogin.getAdminNo());
		}
		
		// logger 찍기
		logger.info("/admin/oneonone/user/update - [POST] 요청");
		
		// modifyAnswer 찍기
		logger.debug("modifyAnswer: " + modifyAnswer);
		
		// 수정하기
		int updateRes = adminOneOnOneService.updateAnswer(modifyAnswer);
		logger.debug("updateRes: " + updateRes);
		
		// udpateRes >= 1 - 수정 성공
		if( updateRes >= 1 ) {

			// alert msg
			model.addAttribute("alertMsg", "답변 수정에 성공하였습니다.");
		} else { // 수정 실패
			
			// alert msg
			model.addAttribute("alertMsg", "답변 수정에 실패하였습니다.");
		}
		
		// writeCode 저장
		int isFarmer = 0;
		if( updateCode != null && !"".equals(updateCode) ) {
			isFarmer = Integer.parseInt(updateCode);
		}
		
		// 문의 상세 페이지로 리다이렉트
		if( isFarmer != 0 ) {
			switch (isFarmer) {
			case USER_CODE:
				model.addAttribute("url", "user/detail?questionNo=" + modifyAnswer.getQuestionNo());
				break;
			case FARMER_CODE:
				model.addAttribute("url", "farmer/detail?questionNo=" + modifyAnswer.getQuestionNo());
				break;
			}
		} 
		
		return "common/result";
	}
	
	// 일반인 회원 1대1 답변 삭제
	@RequestMapping(value = "/admin/oneonone/delete", method = RequestMethod.POST)
	@ResponseBody
	public String deleteAnswerToUser(
			AnsweredOneonone deleteAnswer
			, String deleteCode
			) {
		
		// url 찍기
		logger.info("/admin/oneonone/user/delete - [POST] 요청");
		
		// 넘겨받은 queryString 값 확인
		logger.debug("deleteAnswer: " + deleteAnswer.toString());
		
		// file dto 먼저 삭제
		// file 테이블에서 delete 할 정보를 갖는 Map
		Map<String, Object> deleteConfig = new HashMap<>();
		List<Object> postNo = new ArrayList<>();
		postNo.add(deleteAnswer.getQuestionNo());
		
		deleteConfig.put("boardNo", ANSWERD_ONEONONE_BOARD_NO);
		deleteConfig.put("postNo", postNo);
		
		// 서버에서 먼저 삭제
		// delete 할 파일들을 모두 조회
		List<EveryonesFarmFile> deleteFiles = ckImageUploadService.selectFilesByBoardNoAndPostNo(deleteConfig);
		// deleteFiles test 출력
		for(EveryonesFarmFile e : deleteFiles) {
			logger.debug("삭제할 file 정보: " + e.toString());
			// deleteFile 함수 호출
			ckImageUpload.deleteFile(e.getSavePath());
		}
		
		
		// 테이블에서 삭제
		int fileDelRes = ckImageUploadService.deleteFile(deleteConfig);
		logger.debug("fileDelRes: " + fileDelRes);
		
		// 글 삭제
		int delRes = adminOneOnOneService.deleteAnswer(deleteAnswer);
		logger.debug("delRes: " + delRes);
//		int delRes = 0;
		
		// ajax 에 응답할 데이터를 저장하는 Map
		Map<String, Object> resultMap = new HashMap<>();
		int isDeleted = 0; // 연산이 수행했는지 안했는지에 대한 값을 저장하는 변수
		
		// delete 연산 성공
		if( delRes >= 1) {
			
			// 답변 상태 업데이트 - 답변 대기로
			int updateRes = adminOneOnOneService.updateWaitAnswerByQuestionNo(deleteAnswer);
			logger.debug("updateRes: " + updateRes);
			
			// 업데이트가 성공적으로 이루어짐
			if( updateRes >= 1 ) {
				
				isDeleted = 1;
				resultMap.put("isDeleted", isDeleted);
				resultMap.put("questionNo", deleteAnswer.getQuestionNo());
			} else {
				resultMap.put("isDeleted", isDeleted);
			}
			
			
			
		} else { // delete 연산 실패
			
			resultMap.put("isDeleted", isDeleted);
			
		}
		
		// Gson 객체 - ajax에 응답할 객체
		Gson gson = new Gson();
		String resJson = gson.toJson(resultMap);
		logger.debug("resJson: " + resJson);
		
		
		return resJson;
	}
	
	// 농업인 회원 1대1 답변 삭제
	@RequestMapping(value = "/admin/oneonone/farmer/delete", method = RequestMethod.POST)
	public String deleteAnswerToFarmer(AnsweredOneonone deleteAnswer) {
		return "";
	}
	
}
