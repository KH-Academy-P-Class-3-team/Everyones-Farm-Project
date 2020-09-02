package com.kh.farmapp.admin.main.controller;

import java.util.ArrayList;
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

import com.kh.farmapp.admin.model.service.AdminMainService;

import common.dto.Admin;


@Controller
public class AdminMainController {

	// 상수
	// 농장 입점 신청 목록의 크기가 5를 넘어갈 때, subList를 사용하기 위한 상수들 List.subList(firstRow, lastRow);
	private static final int FLIST_FIRST_ROW = 0;
	private static final int FLIST_LAST_ROW = 5;
	
	// log 를 남기기 위한 Logger 객체
	private static final Logger logger = LoggerFactory.getLogger(AdminMainController.class);
	
	@Autowired
	private AdminMainService adminMainService;
	
	// 관리자 페이지 메인
	@RequestMapping(value = "/admin/main", method = RequestMethod.GET)
	public String adminMain(
			HttpSession session
			, Model model
			) {
		
		// 로그인이 안되어 있을 경우, 바로 로그인 페이지로 이동
		Admin loginAdmin = (Admin) session.getAttribute("adminInfo");
		if( loginAdmin == null) {
			
			return "redirect:/admin/login";
			
		}
		
		logger.info("/admin/main - [GET] 요청");
		
		// 최근 농장 입점신청 목록 Top5
		// is_confirm 이 0 이 있는 경우에 다 받아오고 최대 5개만 보여주기
		// 만약에 없다면? 최근 입점 목록은 아얘 보여주지 말 것! 또는 최근 입점신청 목록이 없습니다를 보여줄 것
		List<Map<String, Object>> fList = adminMainService.selectLatestFarmerApplicationList();
		if ( fList.size() >= 5 ) { // fList 의 크기가 5보다 클 경우(5 이상)
			fList = fList.subList(FLIST_FIRST_ROW, FLIST_LAST_ROW);
			
		}

		// fList test output
//		for(Map<String, Object> m : fList) {
//			System.out.println(m);
//		}
		
		// view 에 fList 넘겨주기
		model.addAttribute("fList", fList);

		// 최근 고객센터 문의 Top5
		List<Map<String, Object>> qList = adminMainService.selectLatestQuestionList();
		// qList test output
//		for(Map<String, Object> m : qList) {
//			System.out.println(m);
//			logger.info(m.toString());
//		}
		
		// qList 가 null 값이 아닐 때!
		if(qList != null) {
			model.addAttribute("qList", qList);
		}
		
		return "admin/admin_main";
	}
	
}
