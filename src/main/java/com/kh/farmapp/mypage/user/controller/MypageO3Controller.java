package com.kh.farmapp.mypage.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.mypage.user.model.service.MyPageService;

<<<<<<< HEAD
=======
import common.dto.Admin;
import common.dto.Notice;
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
import common.dto.QuestionOneonone;

@Controller
public class MypageO3Controller {
	
	@Autowired
	private MyPageService mypageService;
	
	//일대일 문의 질문 리스트
	@RequestMapping("mypage/user/mypageO3List")
		public ModelAndView o3List(@RequestParam(required=false, defaultValue="1") int cPage) {
		
		List<QuestionOneonone> list = mypageService.o3List();
		
<<<<<<< HEAD
		for (QuestionOneonone q : list) {
			System.out.println(q);
		}
		
=======
		int cntPerPage = 10;
		Map<String, Object> o3pList = mypageService.o3List(cPage, cntPerPage, user);

		System.out.println(o3pList.toString());

		mav.addObject("page", o3pList.get("page"));
		mav.addObject("list", o3pList);
		mav.setViewName("mypage/user/mypageO3List");

		return mav;
	}

	//일대일 문의 디테일 보기
	@RequestMapping("mypage/user/mypageO3Detail")
	public ModelAndView o3Detail(int QUESTION_NO, HttpSession session) {

		UserTB user = (UserTB) session.getAttribute("userInfo");
		ModelAndView mav = new ModelAndView();

		//디테일 페이지 정보
		QuestionOneonone o3 = mypageService.o3Detail(QUESTION_NO);
		System.out.println(o3);

		//게시물 수 구하기
		Map<String, Object> total = mypageService.getTotal(user);

		int max = Integer.parseInt(String.valueOf(total.get("MAX")));
		int min = Integer.parseInt(String.valueOf(total.get("MIN")));
		//위아래 페이지로 넘어가기
		QuestionOneonone down = new QuestionOneonone();
		int forDown = QUESTION_NO;
		while( min <= forDown) {
			--forDown;
			down = mypageService.o3Detail(forDown);
			
			if(down != null)
			break;
		}

		QuestionOneonone up = new QuestionOneonone();
		int forUp = QUESTION_NO;
		while( max >= forUp) {
			++forUp;
			up = mypageService.o3Detail(forUp);
			
			if(up != null)
			break;
		}
		mav.addObject("up", up);
		mav.addObject("down", down);
		mav.addObject("total", total);
		mav.addObject("one", o3);
		mav.setViewName("mypage/user/mypageO3Detail");

		return mav;

	}
	@RequestMapping("mypage/user/mypageO3Write")
	public ModelAndView o3Write(HttpSession session) {

		UserTB user = (UserTB) session.getAttribute("userInfo");
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("O3List", list);
		
		return mav;
		}
		
		//일대일 문의 디테일 보기
	@RequestMapping("mypage/user/mypageO3Detail")
		public void o3Detail(int qNo) {
		mypageService.appliActList();
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
