package com.kh.farmapp.mypage.user.controller;

<<<<<<< HEAD
=======
import java.util.HashMap;
import java.util.List;
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
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
		
<<<<<<< HEAD
=======
		
		mav.addObject("page", basket.get("page"));
		mav.addObject("basket", basket);
		mav.addObject("purchase", purchase);
		mav.setViewName("mypage/user/basket");
		
		return mav;
	}
	
	/**
	 * 결제 대기창으로 데이터 넘기는 메서드
	 * @param request
	 * @return
	 */
	@RequestMapping("/basket/add")
	public ModelAndView addPurchase(HttpServletRequest request) {
		
		String basketNo = request.getParameter("names");
		
		String[] array = basketNo.split(",");
		int[] arr = new int[array.length];
		
		for(int i=0;i<array.length;i++) {
		arr[i] = Integer.parseInt(array[i]);
		System.out.println(arr[i]);
		}
		ModelAndView mav = new ModelAndView();
		int res = mypageService.insertPurchase(arr);
		if(res>0) {
			mav.addObject("alertMsg", "구매목록에 추가되었습니다.");
			mav.addObject("url", "/farmapp/mypage/user/basket");
			mav.setViewName("common/result");
		}else {
			mav.addObject("alertMsg", "구매 수량이 부족합니다..");
			mav.addObject("url", "/farmapp/mypage/user/basket");
			mav.setViewName("common/result");
		}
		
		return mav;
	}
	
	/**
	 * 장바구니에서 삭제
	 * @param request
	 * @return
	 */
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
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
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
<<<<<<< HEAD
	@RequestMapping("mypage/user/OrderDetail")
	public void orderDetail() {
		mypageService.appliActList();
=======
	@RequestMapping("/mypage/user/OrderDetail")
=======
	@RequestMapping("mypage/user/OrderDetail")
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
	public ModelAndView orderDetail(int orderNo, HttpSession session) {
		
		UserTB user = (UserTB) session.getAttribute("userInfo");
		
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
<<<<<<< HEAD
	@RequestMapping("/basket/done")
	public String payDone() {
		return "redirect:/mypage/user/basket";
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
	}
=======
	
	
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added

}
