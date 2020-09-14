package com.kh.farmapp.admin.product.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.farmapp.admin.model.service.AdminProductService;

import common.dto.Product;
import common.util.AdminPaging;

/**
 * 상품 관리 페이지 Controller
 */
@Controller
public class AdminProductController {

	// log 를 남기기 위한 Logger 객체
	private static final Logger logger = LoggerFactory.getLogger(AdminProductController.class);

	// service 객체
	@Autowired
	private AdminProductService adminProductService;
	
	// 판매 상품 신청 목록 페이지
	@RequestMapping(value = "/admin/product/list", method = RequestMethod.GET)
	public String adminProductList(
			Model model
			// 페이징 처리시 필요한 변수
			, @RequestParam(defaultValue = "0") String curPage
			// 검색 처리시 필요한 변수
			, @RequestParam(defaultValue = "") String search
			, HttpSession session
			) {
		
		// url 요청 찍기
		logger.info("/admin/product/list - [GET] 요청");

		// 페이징 설정에 대한 정보를 갖는 Map 객체
		Map<String, Object> pagingConfig = new HashMap<>();
		pagingConfig.put("curPage", curPage);
		pagingConfig.put("search", search);
		logger.debug("pagingConfig: " + pagingConfig.toString());
		
		// 페이징 설정
		AdminPaging apaging = adminProductService.getPaging(pagingConfig);
		logger.debug("apaging: " + apaging.toString());
		
		// product list 불러오기
		List<Map<String, Object>> productList = adminProductService.selectAllProduct(apaging);
		for(Map<String, Object> product: productList) {
			logger.debug("product: " + product.toString());
		}
		
		// model 값 넘기기
		// 페이징
		if( apaging != null ) {
			model.addAttribute("apaging", apaging);
		}
		// list
		if( productList != null ) {
			
			model.addAttribute("productList", productList);
		}
		
		return "admin/product/product_list";
	}
	
	// 판매 상품 승인
	@RequestMapping(value = "/admin/product/approve", method = RequestMethod.POST)
	@ResponseBody
	public int approveProduct(
			// 입점 수락할 번호들
			@RequestParam Map<String, Object> approveNums
			// 서버 url 을 알기 위한 request 객체
			, HttpServletRequest req
			) {
		
		// url 요청 찍기
		logger.info("/admin/product/approve - [POST] 요청");
		
		// ajax 반환 값
		int result = 0;
		
		// approveNums -> ArrayList 로 변환
		String[] productNums = approveNums.get("productNo").toString().split(",");
		List<String> productNoList = new ArrayList<>(Arrays.asList(productNums));
		logger.debug("productNoList: " + productNoList.toString());
		
		// 판매 상품 승인
		int approveRes = adminProductService.approveProduct(productNoList);
		logger.debug("approveRes: " + approveRes);
		
		// 판매 승인 성공/실패
		// 판매 승인 성공
		if(approveRes >= 1) {
			
			result = 1;
		}
		
		return result;
	}
	
	// 판매 상품 보류
	@RequestMapping(value = "/admin/product/hold", method = RequestMethod.POST)
	@ResponseBody
	public int putProductOnHold(
			// 판매 보류 번호들
			@RequestParam Map<String, Object> holdNums
			// 서버 url 을 알기 위한 request 객체
			, HttpServletRequest req
			) {
		
		// url 요청 찍기
		logger.info("/admin/product/hold - [POST] 요청");
		
		// ajax 반환 값
		int result = 0;
		
		// approveNums -> ArrayList 로 변환
		String[] productNums = holdNums.get("productNo").toString().split(",");
		List<String> productNoList = new ArrayList<>(Arrays.asList(productNums));
		logger.debug("productNoList: " + productNoList.toString());
		
		// 판매 상품 승인
		int holdRes = adminProductService.putProductOnHold(productNoList);
		logger.debug("holdRes: " + holdRes);
		
		if(holdRes >= 1) {
			
			result = 1;
		}
		
		return result;
	}
	
}
