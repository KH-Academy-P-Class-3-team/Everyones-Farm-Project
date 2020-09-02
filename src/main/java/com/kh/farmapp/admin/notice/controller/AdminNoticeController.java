package com.kh.farmapp.admin.notice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.farmapp.admin.model.service.AdminNoticeService;

import common.dto.Notice;

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
	public String adminNoticeList() {
		return "admin/notice/admin_notice_list";
	}
	
	
	// 공지사항 관리 공지사항 상세 페이지
	@RequestMapping(value = "/adminnotice/noticedetail", method = RequestMethod.GET)
	public String adminNoticeDetail(Notice noticeNo) {
		return "";
	}
	
	// 공지사항 관리 공지사항 작성 폼 페이지
	@RequestMapping(value = "/adminnotice/writenotice", method = RequestMethod.GET)
	public void adminNoticeWrite() {
	}
	
	// 공지사항 관리 공지사항 작성
	@RequestMapping(value = "/adminnotice/writenotice", method = RequestMethod.POST)
	public String adminNoticeWriteProc(Notice notice) {
		return "";
	}
	
	// 공지사항 관리 공지사항 삭제
	@RequestMapping(value = "/adminnotice/deletenotice", method = RequestMethod.POST)
	public String deleteNotice(Notice notice) {
		return "";
	}
	
}
