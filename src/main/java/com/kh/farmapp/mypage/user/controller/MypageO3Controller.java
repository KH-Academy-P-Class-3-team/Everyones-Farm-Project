package com.kh.farmapp.mypage.user.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.mypage.user.model.service.MyPageService;

import common.dto.QuestionOneonone;

@Controller
public class MypageO3Controller {

	@Autowired
	private MyPageService mypageService;

	//일대일 문의 질문 리스트
	@RequestMapping("mypage/user/mypageO3List")
	public ModelAndView o3List(@RequestParam(required=false, defaultValue="1")int cPage) {

		ModelAndView mav = new ModelAndView();
		int cntPerPage = 10;
		Map<String, Object> o3pList = mypageService.o3List(cPage, cntPerPage);

		System.out.println(o3pList.toString());

		mav.addObject("page", o3pList.get("page"));
		mav.addObject("list", o3pList);
		mav.setViewName("mypage/user/mypageO3List");

		return mav;
	}

	//일대일 문의 디테일 보기
	@RequestMapping("mypage/user/mypageO3Detail")
	public ModelAndView o3Detail(int QUESTION_NO) {


		ModelAndView mav = new ModelAndView();

		//디테일 페이지 정보
		QuestionOneonone o3 = mypageService.o3Detail(QUESTION_NO);
		System.out.println(o3);

		//게시물 수 구하기
		int total = mypageService.getCount();

		//위아래 페이지로 넘어가기
		if(QUESTION_NO!=1) {
			QuestionOneonone up = mypageService.o3Detail(QUESTION_NO-1);
			mav.addObject("up", up);
			System.out.println(up);
		}

		if(total > QUESTION_NO) {
			QuestionOneonone down = mypageService.o3Detail(QUESTION_NO+1);
			mav.addObject("down", down);
			System.out.println(down);
		}


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


	/*
	 * ck에디터
	 */
	private String fileDir = "/farmapp/resources/image/mypage";
	/**
	 * @param multiFile
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/mine/imageUpload.do", method = RequestMethod.POST)
	public void imageUpload(HttpServletRequest request,
			HttpServletResponse response, MultipartHttpServletRequest multiFile
			, @RequestParam MultipartFile upload) throws Exception{
	}
}


