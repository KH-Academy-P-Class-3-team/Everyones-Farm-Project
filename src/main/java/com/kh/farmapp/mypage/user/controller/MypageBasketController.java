package com.kh.farmapp.mypage.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.mypage.user.model.service.MyPageService;

@Controller
public class MypageBasketController {

	@Autowired
	private MyPageService mypageService;


	//장바구니 폐이지
	@RequestMapping("mypage/user/basket")
	public void baskePage(@RequestParam(required=false, defaultValue="1") int cPage) {
		
		mypageService.appliActList();
		
	}

	//장바구니 리스트 -ajax
	public ModelAndView basketList(@RequestParam(required=false, defaultValue="1") int cPage) {
		return null;
	}


	//선택된 제품들의 가격의 합을 구하는 메서드
	public String addProduct(Map<String , Object> map) {
		return null;
	}

	//구매 목록 리스트
	@RequestMapping("mypage/user/orderList")
	public void orderList(@RequestParam(required=false, defaultValue="1") int cPage) {
		mypageService.appliActList();
	}

	//구매 목록 리스트 상세 정보
	@RequestMapping("mypage/user/OrderDetail")
	public void orderDetail() {
		mypageService.appliActList();
	}

}
