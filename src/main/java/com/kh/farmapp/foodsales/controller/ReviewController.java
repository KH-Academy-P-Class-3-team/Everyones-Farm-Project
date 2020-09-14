package com.kh.farmapp.foodsales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.foodsales.model.service.ReviewService;

import common.dto.Product;
import common.dto.Review;
import common.dto.ReviewFile;
import common.dto.UserTB;

@Controller
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	//리뷰 작성
//	@RequestMapping("")
//	public String reviewWrite(UserTB user, Product product) {
//		return null;
//	}
	
	//리뷰 삭제
//	@RequestMapping("")
//	public String reviewDelete(Review review) {
//		return null;
//	
//	}
	
	//리뷰 업데이트
//	@RequestMapping("")
//	public String reviewUpdate(UserTB user, Review review) {
//		return null;
//		
//	}
//	
	//리뷰 조회
//	@RequestMapping("")
//	public ModelAndView reviewSelect(Review review, UserTB user, Product product) {
//		ModelAndView mav = new ModelAndView();
//		return mav;
//		
//	}

	//리뷰 삽입
//	@RequestMapping("")
//	public String reviewInsert(User user) {
//		return null;
//		
//	}
	
	//리뷰 파일 넘버
//	@RequestMapping
//	public String reviewfilenoImpl(ReviewFile reviewFile) {
//		return null;
//		
//	}
	
	//리뷰 점수
//	@RequestMapping
//	public int reviewScore(Review reivew, Product product) {
//		return 0;
//
//	}
	
//	//리뷰 날짜
//	@RequestMapping("")
//	public Date reviewDate() {
//		return null;
//		
//	}
	
	//리뷰 번호
//	@RequestMapping
//	public int reviewNo(ReviewFile reviewFile) {
//		return 0;
//	}

	//리뷰 하트 점수
//	@RequestMapping
//	public int heartScore(ReviewFile reviewFile, Product product, User user) {
//		return 0;
//	}
	
	//리뷰 항목
//	@RequestMapping("")
//	public ModelAndView reviewProduct(Review review, User user) {
//		ModelAndView mav = new ModelAndView();
//		return mav;
//		
//	}
	
}
