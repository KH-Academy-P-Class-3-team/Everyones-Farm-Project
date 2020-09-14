package com.kh.farmapp.findfarm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.findfarm.model.service.FindFarmService;

import common.dto.test.FarmSearchCriteria;

@Controller
public class FindFarmController {

	@Autowired
	private FindFarmService findFarmService;

	/**
	 * 농장 목록 조회 및 검색
	 * @param cPage - 현재 페이지
	 * @param fsc - 검색 설정을 담고있는 FarmSearchCriteria 객체 
	 * @return mav - 조회된 농장 목록과 페이지네이션, View 전달
	 */
	@RequestMapping("findfarm/farmList")
	public ModelAndView farmList(@RequestParam(required=false, defaultValue="1") int cPage,
			FarmSearchCriteria fsc) {
		
		ModelAndView mav = new ModelAndView();
		
		int cntPerPage = 9;

		Map<String, Object> commandMap = findFarmService.selectFarmList(cPage, cntPerPage, fsc);

		if(((List<Map<String, Object>>)commandMap.get("farmList")).isEmpty()) {
			mav.addObject("alertMsg", "조회된 결과가 없습니다.");
			mav.addObject("url", "farmList");
			mav.setViewName("common/result");
		} else {
			mav.addObject("sc", fsc);
			mav.addObject("paging", commandMap.get("paging"));
			mav.addObject("farmList", commandMap.get("farmList"));
			mav.addObject("fileList", commandMap.get("fileList"));
			mav.setViewName("findfarm/farmList");
		}
		
		return mav;
	}
	
	
}
