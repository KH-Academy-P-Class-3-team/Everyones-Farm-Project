package com.kh.farmapp.mypage.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.mypage.user.model.service.MyPageService;

import common.dto.QuestionOneonone;

@Controller
public class MypageO3Controller {
	
	@Autowired
	private MyPageService mypageService;
	
	//일대일 문의 질문 리스트
	@RequestMapping("mypage/user/mypageO3List")
		public ModelAndView o3List(@RequestParam(required=false, defaultValue="1") int cPage) {
		
		ModelAndView mav = new ModelAndView();
		
		List<QuestionOneonone> list = mypageService.o3List();
		
		for (QuestionOneonone q : list) {
			System.out.println(q);
		}
		
		
		mav.addObject("list", list);
		mav.setViewName("mypage/user/mypageO3List");
		
		return mav;
		}
		
		//일대일 문의 디테일 보기
	@RequestMapping("mypage/user/mypageO3Detail")
		public ModelAndView o3Detail(int qNo) {
		
		qNo = 1;
		
		ModelAndView mav = new ModelAndView();
		
		QuestionOneonone o3 = mypageService.o3Detail(qNo);
		
		mav.addObject("one", o3);
		mav.setViewName("mypage/user/mypageO3Detail");
		
		return mav;
		
		}
		
		//일대일 문의 작성하기
	@RequestMapping("mypage/user/mypageO3Write")
		public void o3Upload(QuestionOneonone qO3, HttpSession session) {
		}
		
		//일대일 문의 수정
		public String o3Modify(int qNo , String userId
				, HttpSession session) {
			return"";
		}
		
		//일대일 문의 삭제
		public String o3Delete(int qNo, String userId
				, HttpSession session) {
			return"";
		}

}
