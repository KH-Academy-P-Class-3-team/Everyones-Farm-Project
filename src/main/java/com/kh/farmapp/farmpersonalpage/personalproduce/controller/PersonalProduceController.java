package com.kh.farmapp.farmpersonalpage.personalproduce.controller;

<<<<<<< HEAD
=======
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.kh.farmapp.farmpersonalpage.personalproduce.model.service.PersonalProduceService;

@Controller
public class PersonalProduceController {

	@Autowired
	private PersonalProduceService personalproduceService; 
<<<<<<< HEAD

//	@RequestMapping("personalproduce/personalproducelist.do")
//	public ModelAndView personalproduceList(
//			@RequestParam(required=false, defaultValue="1") int cPage) {
//
//		ModelAndView mav = new ModelAndView();
//
//		return mav;
//
//	}
=======
	
	//개인 농산물 상품등록 작성 화면 
	@RequestMapping(value = "/personalproduce/personalproducewrite.do", method = RequestMethod.GET)
	public void ProductWrite() {
//		System.out.println("상품등록 페이지 접속 완료");
		
	}

	
	//개인 농산물 상품등록
	@RequestMapping(value = "/personalproduce/productwrite.do", method = RequestMethod.POST)
	public String introduceWrite(@RequestParam Map<String, Object> commandMap, String farmerNo) {
		
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
		
		System.out.println("상품등록:" + commandMap);
		
		return "redirect:/personalproduce/personalproducelist.do?farmerNo=" + farmerNo;
	}
	
	//개인 농산물 리스트 화면
	@RequestMapping(value = "/personalproduce/personalproducelist.do", method = RequestMethod.GET)
	public ModelAndView personalproduceList(@RequestParam(required=false, defaultValue="1") int cPage, String farmerNo) {
//		System.out.println("개인농산물 리스트");
		
		ModelAndView mav = new ModelAndView();

		int cntPerPage = 10;
		
		System.out.println("personalproduceContorller - farmerNo: " + farmerNo);
		
		Map<String,Object> res = personalproduceService.selectProductList(cPage, cntPerPage, farmerNo);
		
		
		mav.addObject("paging", res.get("paging"));
		mav.addObject("list", res.get("fdlist"));
		mav.setViewName("personalproduce/personalproducelist");
		
		System.out.println("컨트롤러값"+res);
		System.out.println(mav);
		//		System.out.println(res);

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

>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
	
}
