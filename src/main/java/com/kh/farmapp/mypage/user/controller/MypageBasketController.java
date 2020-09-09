package com.kh.farmapp.mypage.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.mypage.user.model.service.MyPageService;

import common.dto.Farmer;
import common.dto.QuestionOneonone;
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
	
	
	@RequestMapping("/basket/delete")
	public ModelAndView deleteBasket(HttpServletRequest request) {
		
		String basketNo = request.getParameter("names");
		
		String[] array = basketNo.split(",");
		int[] arr = new int[array.length];
		
		for(int i=0;i<array.length;i++) {
		arr[i] = Integer.parseInt(array[i]);
		System.out.println(arr[i]);
		}
		
		int res = mypageService.deleteBasket(arr);
		
		ModelAndView mav = new ModelAndView();
		
		if(res >0 ) {
			
			mav.addObject("alertMsg", "삭제되었습니다");
			mav.addObject("url", "../mypage/user/basket");
			mav.setViewName("common/result");
			
		}else {
			mav.addObject("alertMsg", "삭제가 실패했습니다");
			mav.addObject("url", "../mypage/user/basket");
			mav.setViewName("common/result");
			
		}
		
		
		System.out.println(basketNo);
		
		
		
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
		
		int userNo = user.getUserNo();
		int cntPerPage = 5;
		Map<String, Object> order = mypageService.orderList(userNo, cPage, cntPerPage);

		ModelAndView mav = new ModelAndView();
		
		
		System.out.println(order);
		mav.addObject("page", order.get("page"));
		mav.addObject("order", order);
		mav.setViewName("mypage/user/orderList");
		
		return mav;
		
	}

	//구매 목록 리스트 상세 정보
	@RequestMapping("mypage/user/OrderDetail")
	public ModelAndView orderDetail(int orderNo, HttpSession session) {
		
		UserTB user = (UserTB) session.getAttribute("userInfo");
		System.out.println("orderno:"+orderNo);
		
		Map<String, Object> orderDetail = mypageService.orderDetail(orderNo);
		
		ModelAndView mav = new ModelAndView();
		
		System.out.println(orderDetail);
		

		
		Map<String, Object> total = mypageService.getOrderTotal(user.getUserNo());

		int max = Integer.parseInt(String.valueOf(total.get("MAX")));
		int min = Integer.parseInt(String.valueOf(total.get("MIN")));
		//위아래 페이지로 넘어가기
		Map<String, Object> down = new HashMap<String, Object>();
		int forDown = orderNo;
		while( min <= forDown) {
			--forDown;
			down = mypageService.orderDetail(forDown);
			
			if(down != null)
			break;
		}

		Map<String, Object> up = new HashMap<String, Object>();
		int forUp = orderNo;
		while( max >= forUp) {
			++forUp;
			up = mypageService.orderDetail(forUp);
			
			if(up != null)
			break;
		}
		System.out.println("up :"+up);
		System.out.println("down : "+down);
		mav.addObject("up", up);
		mav.addObject("down", down);
		mav.addObject("total", total);
		mav.addObject("orderDetail", orderDetail);
		mav.setViewName("mypage/user/OrderDetail");

		return mav;
		
	}
	
	

}
