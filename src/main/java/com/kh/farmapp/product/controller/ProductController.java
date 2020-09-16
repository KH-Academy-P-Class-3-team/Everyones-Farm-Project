package com.kh.farmapp.product.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.product.model.service.ProductService;

import common.dto.Admin;
import common.dto.Basket;
import common.dto.Farmer;
import common.dto.Product;
import common.dto.UserTB;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	//판매 메인 창 띄우기
	@RequestMapping(value="/main.do")
	public String productmain(
			Model model
			, HttpSession session) {
		
		List<Map<String, Object>> seasontop = productService.selectSeasonTop();
		List<Map<String, Object>> generaltop = productService.selectGeneralTop();
		
		model.addAttribute("season", seasontop);
		model.addAttribute("general", generaltop);
		
		return "product/productmain";
	}
	
	//제철음식 리스트
	@RequestMapping("/seasonlist.do")
	public ModelAndView seasonlist(
			@RequestParam(required =false, defaultValue = "1") int cPage) {
		ModelAndView mav = new ModelAndView();
		int cntPerPage = 9;
		
		Map<String, Object> commandMap = productService.selectSeasonList(cPage, cntPerPage, 0);
		
		
		
		mav.addObject("paging", commandMap.get("paging"));
		mav.addObject("plist", commandMap.get("plist"));
		mav.addObject("fileList", commandMap.get("fileList"));
		mav.setViewName("product/seasonList");
		return mav;
	}
	
	//일반음식 리스트
	@RequestMapping("/generallist.do")
	public ModelAndView generallist(
			@RequestParam(required =false, defaultValue = "1") int cPage) {
		ModelAndView mav = new ModelAndView();
		int cntPerPage = 9;
		
		Map<String, Object> commandMap = productService.selectGeneralList(cPage, cntPerPage, 0);
		mav.addObject("paging", commandMap.get("paging"));
		mav.addObject("plist", commandMap.get("plist"));
		mav.addObject("fileList", commandMap.get("fileList"));
		mav.setViewName("product/generalList");
		return mav;
	}
	
	//상세보기
	@RequestMapping("/productDetail.do")
	public ModelAndView productDetail(int productNo
			, HttpSession session ) {
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> commandMap = productService.selectProductDetail(productNo);
		List<Map<String, Object>> option = productService.selectProductOption(productNo);
		
		
		// file 이 null 값이 아닐 때 추가하기
		if( commandMap.get("fileList") != null ) {
			mav.addObject("fileList", commandMap.get("fileList"));
		}
		mav.addObject("data", commandMap);
		mav.addObject("option", option);
		mav.setViewName("product/productDetail");
		return mav;
	}

	//리스트 검색
	@RequestMapping("/seasonSearch.do")
	public ModelAndView seasonSearch(int isSeasonalFood, String title, String filter
			, @RequestParam(required=false, defaultValue="1") int cPage) {
		
		int cntPerPage = 9;
		
		Map<String, Object> commandMap = productService.selectSeasonSearch(cPage, cntPerPage, isSeasonalFood, title, filter);
		
		ModelAndView mav = new ModelAndView();
		
		if(((List<Product>)commandMap.get("plist")).isEmpty()) {
			mav.addObject("msg", "조회된 결과가 없습니다.");
			mav.setViewName("product/result");
		} else {
			mav.addObject("paging", commandMap.get("paging"));
			mav.addObject("plist", commandMap.get("plist"));
			mav.addObject("file", commandMap.get("fileList"));
			
			mav.setViewName("product/searchResult");
			
		}
		return mav;
	}
	
	//장바구니 담기
	@RequestMapping("cartimpl.do")
	public String cartImpl(
			@ModelAttribute Basket basket
			, Model model 
			, @RequestParam Map<String, Object> commandMap
			, HttpServletRequest req
			, HttpSession session
				) {
		
		String root = req.getContextPath();
		UserTB userInfo = (UserTB) session.getAttribute("userInfo");
		Farmer farmerInfo = (Farmer) session.getAttribute("farmerInfo");
		
		if(userInfo == null && farmerInfo == null) {
			model.addAttribute("alertMsg", "로그인해주세요!");
			model.addAttribute("url", "javascript:history.go(-2);");
		}
		
		else if(userInfo != null) {
			commandMap.put("userNo", userInfo.getUserNo());
			commandMap.put("farmerNo", null);
			int res = productService.insertBasket(commandMap); 
			if(res>0) {
				model.addAttribute("confirmMsg", "장바구니를 확인하시겠습니까?");
				model.addAttribute("confirmUrl", root+"/product/main.do"); //장바구니 링크
				model.addAttribute("confirmBackUrl", "javascript:history.go(-1);"); 
			} else {
				model.addAttribute("alertMsg", "장바구니에 담지 못했습니다.");
				model.addAttribute("url", root+"/product/main.do");
			}
			
		} else if ( farmerInfo != null) {
			commandMap.put("userNo", null);
			commandMap.put("farmerNo", farmerInfo.getFarmerNo());
			int res = productService.insertBasket(commandMap); 
			if(res>0) {
				model.addAttribute("confirmMsg", "장바구니를 확인하시겠습니까?");
				model.addAttribute("confirmUrl", root+"/product/main.do"); //장바구니 링크
				model.addAttribute("confirmBackUrl", "javascript:history.go(-1);"); 
			} else {
				model.addAttribute("alertMsg", "장바구니에 담지 못했습니다.");
				model.addAttribute("url", root+"/product/main.do");
			}
		} 
		
		return "common/result";
	}
	
	//구매
	@RequestMapping("/buy.do")
	public String buy( Model model,
			HttpServletRequest req
			, HttpSession session) {
		
		String root = req.getContextPath();
		
		if(session.getAttribute("userInfo") == null && session.getAttribute("farmerInfo") == null) {
			model.addAttribute("alertMsg", "로그인해주세요!");
			model.addAttribute("url", "javascript:history.go(-1);");
		} else {
			model.addAttribute("confirmMsg", "구매하시겠습니까?");
			model.addAttribute("confirmUrl", "../"); //구매 링크
			model.addAttribute("confirmBackUrl", "javascript:history.go(-1);"); //장바구니 링크
		}
		return "common/result";
	}

}
