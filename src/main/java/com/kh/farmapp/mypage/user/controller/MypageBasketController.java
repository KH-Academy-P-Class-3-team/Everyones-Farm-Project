package com.kh.farmapp.mypage.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
<<<<<<< HEAD
	@RequestMapping("mypage/user/OrderDetail")
	public void orderDetail() {
		mypageService.appliActList();
=======
	@RequestMapping("/mypage/user/OrderDetail")
	public ModelAndView orderDetail(int orderNo, HttpSession session) {
		
		UserTB user = (UserTB) session.getAttribute("userInfo");
		System.out.println(orderNo);
		Map<String, Object> orderDetail = mypageService.orderDetail(orderNo, user.getUserNo());
		
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
			down = mypageService.orderDetail(forDown, user.getUserNo());
			
			if(down != null)
			break;
		}

		Map<String, Object> up = new HashMap<String, Object>();
		int forUp = orderNo;
		while( max >= forUp) {
			++forUp;
			up = mypageService.orderDetail(forUp, user.getUserNo());
			
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
	@RequestMapping("/basket/done")
	public String payDone() {
		return "redirect:/mypage/user/basket";
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
	}

}
