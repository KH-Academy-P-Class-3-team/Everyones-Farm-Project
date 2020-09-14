package com.kh.farmapp.mypage.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.mypage.user.model.service.MyPageService;

import common.dto.UserTB;

@Controller
public class MypageBasketController {

	@Autowired
	private MyPageService mypageService;


	//장바구니 폐이지
	@RequestMapping("mypage/user/basket")
	public ModelAndView baskePage(@RequestParam(required=false, defaultValue="1") int cPage, HttpSession session ) {
		
		UserTB user = (UserTB) session.getAttribute("userInfo");
		ModelAndView mav = new ModelAndView();


		if( user == null) {
			mav.addObject("alertMsg", "로그인이 필요합니다.");
			mav.addObject("url", "../../user/login.do");
			mav.setViewName("common/result");
			return mav;
		}
		
		int userNo = user.getUserNo();
		int cntPerPage = 5;
		//페이지 네이션이 포함한 장바구니 목록
		Map<String, Object> basket = mypageService.basketList(userNo, cPage, cntPerPage);
		//구매대기 목록
		Map<String, Object> purchase = mypageService.basketListPur(userNo);
		
		user = mypageService.selectUser(user);
		user.setFirstAddress(user.getFirstAddress()+user.getSecondAddress());
		mav.addObject("user", user);
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
	}

	/**
	 * 결제 대기 창에서 장바구니 창으로
	 * @param request
	 * @return
	 */
	@RequestMapping("/basket/subPurchase")
	public ModelAndView subPurchase(HttpServletRequest request) {
		String basketNo = request.getParameter("names");
		
		String[] array = basketNo.split(",");
		int[] arr = new int[array.length];
		
		for(int i=0;i<array.length;i++) {
		arr[i] = Integer.parseInt(array[i]);
		System.out.println(arr[i]);
		}
		ModelAndView mav = new ModelAndView();
		//option의 수량을 다시 더하고 장바구니 에서 purchase컬럼 다시 0으로 바꾸기 
		int res = mypageService.canclePurchase(arr);
		if(res>0) {
			mav.addObject("alertMsg", "구매목록을 지웠습니다");
			mav.addObject("url", "/farmapp/mypage/user/basket");
			mav.setViewName("common/result");
		}else {
			mav.addObject("alertMsg", "구매 목록을 지우지 못했습니다");
			mav.addObject("url", "/farmapp/mypage/user/basket");
			mav.setViewName("common/result");
		}
		
		return mav;
		
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
		System.out.println("orderDetail :"+orderDetail);
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
	}
	

}
