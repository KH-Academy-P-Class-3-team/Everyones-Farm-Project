package com.kh.farmapp.farmpersonalpage.personalproduce.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.farmpersonalpage.personalproduce.model.service.PersonalProduceService;

import common.dto.Product;
import common.dto.ProductOption;

@Controller
public class PersonalProduceController {

	@Autowired
	private PersonalProduceService personalproduceService; 
	
	@RequestMapping(value = "/personalproduce/personalproducelist.do", method = RequestMethod.GET)
	public ModelAndView farmqnaList() {
		System.out.println("개인 농산물 접속");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("personalproduce/personalproducelist");
		
		return mav;
	}
	
	//개인 농산물 상품등록 작성 화면 
	@RequestMapping(value = "/personalproduce/personalproducewrite.do", method = RequestMethod.GET)
	public void ProductWrite() {
		System.out.println("상품등록 페이지 접속 완료");
		
	}

	
	//개인 농산물 등록
	@RequestMapping(value = "/personalproduce/productwrite.do", method = RequestMethod.POST)
	public String introduceWrite(Product product, ProductOption productoption) {
		
		System.out.println(product);
		System.out.println(productoption);
		
		personalproduceService.writeProduct(product);
		personalproduceService.writeProductOption(productoption);
		
		return "redirect:/personalproduce/personalproducelist.do";
	}
	
//	@RequestMapping("personalproduce/personalproducelist.do")
//	public ModelAndView personalproduceList(
//			@RequestParam(required=false, defaultValue="1") int cPage) {
//
//		ModelAndView mav = new ModelAndView();
//
//		return mav;
//
//	}
	
//	@RequestMapping("personalproduce/personalproduceadd.do")
//	public void personalproduceAdd() {
//
//	}
}
