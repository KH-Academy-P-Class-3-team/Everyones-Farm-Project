package com.kh.farmapp.notice.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.farmapp.notice.model.service.NoticeService;

import common.dto.Notice;
import common.dto.UserTB;

@Controller
public class NoticeController {

	// log 를 남기기 위한 Logger 객체
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value = "/notice/noticelist", method = RequestMethod.GET)
	public String noticeMain(
				Model model
				, HttpSession session
			) {
		// logger 찍기
		logger.info("NoticeController '/notice/noticelist' [GET] 요청");
		
		// 가장 최근 공지사항 불러오기
		Notice latestNotice = noticeService.selectOneNotice();
//		System.out.println("Notice Controller latestNotice: " + latestNotice);
		
		// Model 객체에 추가하여 view 파일에 전송
		model.addAttribute("latestNotice", latestNotice);
		
		return "notice/noticelist";
	}
	
}
