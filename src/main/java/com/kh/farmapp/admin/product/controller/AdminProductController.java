package com.kh.farmapp.admin.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	@RequestMapping(value = "/productadmin/approveproduct", method = RequestMethod.POST)
	public void approveProduct(Product p) {
	}
	
	// 판매 상품 보류
	@RequestMapping(value = "/productadmin/putproductonhold", method = RequestMethod.POST)
	public void putProductOnHold(Product p) {
	}
	
}
