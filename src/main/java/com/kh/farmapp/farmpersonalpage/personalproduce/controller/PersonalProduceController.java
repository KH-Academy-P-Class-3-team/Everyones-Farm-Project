package com.kh.farmapp.farmpersonalpage.personalproduce.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

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
	
	//개인 농산물 상품등록 작성 화면 
	@RequestMapping(value = "/personalproduce/personalproducewrite.do", method = RequestMethod.GET)
	public void ProductWrite() {
//		System.out.println("상품등록 페이지 접속 완료");
		
	}

	
	//개인 농산물 상품등록
	@RequestMapping(value = "/personalproduce/productwrite.do", method = RequestMethod.POST)
	public String introduceWrite(@RequestParam Map<String, Object> commandMap) {
		
//		System.out.println(commandMap.get("expirationDate"));
		
		Product pd = new Product();
		ProductOption po = new ProductOption(); 
		
		String eDate = (String) commandMap.get("expirationDate");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date pod = sdf.parse(eDate);
			
			po.setExpirationDate(pod);
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		
		personalproduceService.writeProduct(commandMap);
		personalproduceService.writeProductOption(commandMap);
		
		
		
		return "redirect:/personalproduce/personalproducelist.do";
	}
	
	//개인 농산물 리스트 화면
	@RequestMapping(value = "personalproduce/personalproducelist.do", method = RequestMethod.GET)
	public ModelAndView personalproduceList(@RequestParam(required=false, defaultValue="1") int cPage) {
//		System.out.println("개인농산물 리스트");
		
		ModelAndView mav = new ModelAndView();
		
		int cntPerPage = 10;

		Map<String,Object> res = personalproduceService.selectProductList(cPage, cntPerPage);
		mav.addObject("paging", res.get("paging"));
		mav.addObject("list", res);
		mav.setViewName("personalproduce/personalproducelist");
		
		return mav;

	}
	
	//상세조회 화면
	@RequestMapping(value = "/personalproduce/personalproducedetail.do", method = RequestMethod.GET)
	public ModelAndView farmdiaryDetail(int productNo) {

		ModelAndView mav = new ModelAndView();

		Map<String, Object> res = personalproduceService.selectProductDetail(productNo);
		mav.addObject("detail", res);
		mav.setViewName("personalproduce/personalproducedetail");

		return mav;

	}
	

	
}
