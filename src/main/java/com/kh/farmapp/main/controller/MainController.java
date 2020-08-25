package com.kh.farmapp.main.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.farmapp.main.model.service.MainService;

import common.dto.Application;

@Controller
public class MainController {

	// log 를 남기기 위한 Logger 객체
	// log 는 추후에 추가하기
//	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	// Service 객체
	@Autowired
	private MainService mainService;
	
	/**
	 * '모두의 농장' 메인 홈페이지
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
	
		// 조인 연산된 결과 콘솔에 찍기 -- test 용
//		List<Map<String, Object>> testMap = mainService.selectTest();
//		for(int i = 0; i < testMap.size(); i++) {
//			System.out.println(testMap.get(i).toString());
//		}

		// 이달의 농장 top 3 불러오기
		// outer join 을 했는데 null 값인 아이들은 불러오지 조차 못한다. 어째서인지 질문!!!
		List<Map<String, Object>> farmTop3 = mainService.selectTop3Farm();
		for(Map<String, Object> m : farmTop3) {
			System.out.println(m);
		}
		
		model.addAttribute("farmlist", farmTop3);
  
		return "/main/index";
	}
	
	
}
