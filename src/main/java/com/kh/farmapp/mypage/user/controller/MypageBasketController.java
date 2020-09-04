package com.kh.farmapp.mypage.user.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.mypage.user.model.service.MyPageService;

import common.dto.TBOrder;
import common.dto.UserTB;

@Controller
public class MypageBasketController {

	@Autowired
	private MyPageService mypageService;


	//장바구니 폐이지
	@RequestMapping("mypage/user/basket")
	public ModelAndView baskePage(@RequestParam(required=false, defaultValue="1") int cPage, HttpSession session ) {
		
		UserTB user = (UserTB) session.getAttribute("userInfo");
		int userNo = user.getUserNo();
		int cntPerPage = 5;
		Map<String, Object> basket = mypageService.basketList(userNo, cPage, cntPerPage);
		
		System.out.println(basket);
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("page", basket.get("page"));
		mav.addObject("basket", basket);
		mav.setViewName("mypage/user/basket");
		
		return mav;
		
	}

	//장바구니 리스트 -ajax
	public ModelAndView basketList(@RequestParam(required=false, defaultValue="1") int cPage) {
		return null;
	}


	//선택된 제품들의 가격의 합을 구하는 메서드
	@RequestMapping("mypage/user/addProduct")
	public String addProduct(Map<String , Object> map) {
		
		return null;
	}

	//구매 목록 리스트
	@RequestMapping("mypage/user/orderList")
	public ModelAndView orderList(@RequestParam(required=false, defaultValue="1") int cPage, HttpSession session) {
		UserTB user = (UserTB) session.getAttribute("userInfo");
		
//		int userNo = user.getUserNo();
		int cntPerPage = 5;
		Map<String, Object> order = mypageService.orderList(2, cPage, cntPerPage);
		
		System.out.println(order);
		ModelAndView mav = new ModelAndView();
		mav.addObject("page", order.get("page"));
		mav.addObject("order", order);
		mav.setViewName("mypage/user/orderList");
		
		return mav;
		
	}

	//구매 목록 리스트 상세 정보
	@RequestMapping("mypage/user/OrderDetail")
	public void orderDetail(int orderNo) {
		
		Map<String, Object> orderDetail = mypageService.orderDetail(orderNo);
		
	}

}
