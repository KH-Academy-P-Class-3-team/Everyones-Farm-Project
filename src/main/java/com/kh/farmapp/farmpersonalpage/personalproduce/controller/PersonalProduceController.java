package com.kh.farmapp.farmpersonalpage.personalproduce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.farmpersonalpage.personalproduce.model.service.PersonalProduceService;

@Controller
public class PersonalProduceController {

	@Autowired
	private PersonalProduceService personalproduceService; 

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
