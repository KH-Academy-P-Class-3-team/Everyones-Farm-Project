package com.kh.farmapp.admin.notice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.kh.farmapp.admin.model.service.AdminNoticeService;

import common.dto.Notice;
import common.util.AdminPaging;

/**
 * 공지사항 & 자주 묻는 질문 관리 페이지
 */
@Controller
public class AdminNoticeController {

	// log 를 남기기 위한 Logger 객체
	private static final Logger logger = LoggerFactory.getLogger(AdminNoticeController.class);

	// service 객체
	@Autowired
	private AdminNoticeService adminNoticeService;
	
	// 공지사항 관리 목록 페이지
	@RequestMapping(value = "/adminnotice/list", method = RequestMethod.GET)
	public String adminNoticeList(
			Model model
			, @RequestParam(defaultValue = "0") String curPage
			) {
		
		// 로그 찍기
		logger.info("/adminnotice/list - [GET] 요청");
		
		// 페이징 설정
		AdminPaging apaging = adminNoticeService.getPaging(curPage);
//		logger.info("AdminPaging: " + apaging.toString());
		
		// apaging 정보로 notice 목록 불러오기
		List<Map<String, Object>> pagingNList = adminNoticeService.selectNoticeByAPaging(apaging);
		//pagingNList test output
//		for(Map<String, Object> m : pagingNList) {
//			logger.info("m: " + m.toString());
//		}
		
		// model 값 넘겨주기
		// 페이징 객체 넘기기
		if( apaging != null ) {
			model.addAttribute("apaging", apaging);
		}
		// 페이징 처리된 목록 넘기기
		if( pagingNList != null ) {
			model.addAttribute("pagingNList", pagingNList);
		}
		
		return "admin/notice/admin_notice_list";
	}
	
	
	// 공지사항 관리 공지사항 상세 페이지
	@RequestMapping(value = "/adminnotice/noticedetail", method = RequestMethod.GET)
	public String adminNoticeDetail(Notice noticeNo) {
		return "";
	}
	
	// 공지사항 관리 공지사항 작성 폼 페이지
	@RequestMapping(value = "/adminnotice/write", method = RequestMethod.GET)
	public String adminNoticeWrite() {
		return "admin/notice/admin_notice_write";
	}
	
	// 공지사항 관리 공지사항 작성
	@RequestMapping(value = "/adminnotice/write", method = RequestMethod.POST)
	public String adminNoticeWriteProc(Notice notice) {
		return "";
	}
	
	// 공지사항 관리 공지사항 삭제
	@RequestMapping(value = "/adminnotice/delete", method = RequestMethod.POST)
	@ResponseBody
	public int deleteNotice(
			// 삭제할 번호들
			@RequestParam Map<String, Object> deleteNums
			) {
		
		// 현재 어떤 url 이 실행되고 있는지
		logger.info("/adminnotice/delete [POST] 요청");

		// ajax 반환 값
		int result = 1;
		
		// noticeNo -> ArrayList 로 변환
		String[] nums = deleteNums.get("noticeNo").toString().split(",");
		List<Object> noticeNoList =  new ArrayList<>(Arrays.asList(nums));
//		logger.info("noticeNoList: " + noticeNoList.toString());
//		logger.info("noticeNoList: " + noticeNoList.getClass().getName());
		
		// 삭제 처리
		int delRes = adminNoticeService.deleteNoticeByNoticeNo(noticeNoList);
		
		if(delRes >= 1) { // 삭제 결과 성공
			
			logger.info("삭제 성공~");
			return result;
			
		} else { // 삭제 결과 실패
			
			logger.info("삭제 실패~");
			result = 0;
			return result;
			
		}
		
	}
	
}
