package com.kh.farmapp.foodsales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.foodsales.model.service.SellService;

@Controller
public class SellController {

	@Autowired
	private SellService sellService;
	
	@RequestMapping(value = "/sellfood/list")
	public String testList() {
		return "sellfood/list";
	}
	
//	//판매 목록 조회
//	@RequestMapping("")
//	public ModelAndView sellList() {
//	ModelAndView mav = new ModelAndView();
//	return mav;
//	}
	
	//판매 페이지
	@RequestMapping("/sellfood/food")
	public ModelAndView sellpage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/sellfood/food");
		return mav;
	}
	
	//판매 상세 페이지
	@RequestMapping("sellfood/detail")
	public ModelAndView sellpagelist() {
		ModelAndView mav = new ModelAndView();
		sellService.sellList(null);
		mav.setViewName("sellfood/list");
		return mav;
	}
	
//	//장바구니
//	@RequestMapping()
//	public ModelAndView sellBasket() {
//	ModelAndView mav = new ModelAndView();
//	return mav;
//	}
	
	
	
}
