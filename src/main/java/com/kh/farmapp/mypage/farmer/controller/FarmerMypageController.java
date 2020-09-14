package com.kh.farmapp.mypage.farmer.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.mypage.farmer.model.service.FarmerMypageService;

import common.dto.Application;
import common.dto.Farmer;
import common.dto.FarmingDailylog;
import common.dto.TBOrder;
import common.dto.page.Criteria;
import common.dto.page.PageMaker;

@Controller
public class FarmerMypageController {
	@Autowired
	private FarmerMypageService farmerMypageService;

	// 영농일지 작성 폼 화면
	@RequestMapping(value = "/mypage/dailyLogWrite", method = RequestMethod.GET)
	public ModelAndView dailyLog(HttpSession session, HttpServletRequest request) {
		
		Farmer farmer = (Farmer)session.getAttribute("farmerInfo");
		ModelAndView mav = new ModelAndView();
		 
		if(farmer == null) {
			mav.addObject("alertMsg", "로그인 후 이용 가능합니다");
			mav.addObject("url", request.getContextPath() + "/farmer/login.do");
			mav.setViewName("common/result");
		} else {
			mav.setViewName("/mypage/dailyLogWrite");
		}
		
		return mav;
	}

	// 영농일지 글 작성 삽입
	@RequestMapping(value = "/mypage/dailyLogwrite", method = RequestMethod.POST)
	public String write(FarmingDailylog farmingDailylog) {

		farmerMypageService.writeDailylog(farmingDailylog);
		System.out.println("삽입완료");

		return "redirect:/mypage/dailyLoglist";

	}

	// 영농일지 리스트 목록 조회
	@RequestMapping(value = "/mypage/dailyLoglist", method = RequestMethod.GET)
	public String dailyLoglist(Model model, Criteria cri,HttpServletRequest request,HttpSession session) {

		
		Farmer farmer = (Farmer)session.getAttribute("farmerInfo");
		List<Map<String, Object>> dailyList = farmerMypageService.dailyLoglist(cri, farmer);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(farmerMypageService.listCount());
		
		model.addAttribute("list", dailyList);
		model.addAttribute("pageMaker", pageMaker);

		return "/mypage/dailyLoglist";
	}
	
	
	@RequestMapping(value = "/mypage/dailyLogReadView", method = RequestMethod.GET)
	public String read(FarmingDailylog farmingDailylog , Model model) {
		model.addAttribute("read",farmerMypageService.read(farmingDailylog.getDailylogNo()));
		System.out.println(farmingDailylog.getDailylogNo());
		return "mypage/dailyLogReadView";
	}
	

	@RequestMapping(value ="/mypage/delete", method= RequestMethod.POST)
	public String delete(FarmingDailylog farmingDailylog) {
		farmerMypageService.delete(farmingDailylog.getDailylogNo());
		System.out.println("삭제요청");
		return "redirect:/mypage/dailyLoglist";
	}
	
	
	@RequestMapping(value = "/mypage/activityFarm", method = RequestMethod.GET)
	public String activityFarm(Model model, Criteria cri , HttpSession session) {
    
		System.out.println("농장체험 접속완료");
		Farmer farmer = (Farmer)session.getAttribute("farmerInfo");
		
		// 농장체험 리스트
		List<Map<String, Object>> farmActive = farmerMypageService.activitylist(cri, farmer);
		
		//농장체험
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(farmerMypageService.listCount2(farmer));

		//농부 객체
		model.addAttribute("farmerInfo",farmer);
	
		//농장체험
		model.addAttribute("list", farmActive);
		model.addAttribute("pageMaker", pageMaker);
		
		return "mypage/activityFarm";
	}
	@RequestMapping(value = "/mypage/activityWork", method = RequestMethod.GET)
	public String activityWork(Model model, Criteria cri , HttpSession session) {
	
		System.out.println("일손체험 접속완료");
		Farmer farmer = (Farmer)session.getAttribute("farmerInfo");
		//일손체험
		List<Map<String, Object>> workActive = farmerMypageService.activitylist3(cri,farmer);
		
		//일손체험
		PageMaker pageMaker3 = new PageMaker();
		pageMaker3.setCri(cri);
		pageMaker3.setTotalCount(farmerMypageService.listCount3(farmer));
		//농부 객체
		model.addAttribute("farmerInfo",farmer);
		
		//일손체험
		model.addAttribute("list3",workActive);
		model.addAttribute("pageMaker3",pageMaker3);

		return "mypage/activityWork";

		
	}
	
	// 농장 체험 리스트 목록 조회
	@RequestMapping(value = "/mypage/activitylist", method = RequestMethod.GET)
	public ModelAndView activitylist(Model model, Criteria cri,HttpSession session,HttpServletRequest request) {


		Farmer farmer = (Farmer)session.getAttribute("farmerInfo");
		
//		List <Map<String,Object>> testMap = (List<Map<String, Object>>)model.addAttribute("list", farmerMypageService.activitylist(cri));

		ModelAndView mav = new ModelAndView();
		 
		if(farmer == null) {
			mav.addObject("alertMsg", "로그인 후 이용 가능합니다");
			mav.addObject("url", request.getContextPath() + "/farmer/login.do");
			mav.setViewName("common/result");
		} else {
			mav.setViewName("/mypage/activitylist");
		}
		return mav;
	}
	

	/**
	 * controller 승인 미승인 업데이트 하기
	 * 
	 * @param application 신청내역 객체
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/mypage/activitylist2", method = RequestMethod.GET)
	public String updateIsApproval(int applicationNo) {

		Application app = new Application();
		app.setApplicationNo(applicationNo);

		return Integer.toString(farmerMypageService.updateIsApproval(app));

	}
	
	// 판매 페이지 리스트
	@RequestMapping(value = "/mypage/selllist", method = RequestMethod.GET)
	public String selllist(Model model, Criteria cri, HttpSession session, HttpServletRequest request) {
		Farmer farmer = (Farmer)session.getAttribute("farmerInfo");
		System.out.println("판매 페이지 접속완료");
		List<Map<String, Object>> sellMap = farmerMypageService.selllist(cri,farmer);
		System.out.println(sellMap);
//		잘 나오는지 테스트하기
		for (int i = 0; i < sellMap.size(); i++) {
			System.out.println("컨트롤러"+sellMap.get(i).toString());
		}
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(farmerMypageService.listCount4(farmer));
		
		//농부 객체
		model.addAttribute("farmerInfo",farmer);
				
		model.addAttribute("list", sellMap);
		model.addAttribute("pageMaker", pageMaker);
		
		return "/mypage/selllist";
	
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/mypage/cal", method = RequestMethod.GET)
	public List<Map<String, Object>> cal(String date,HttpSession session) {
		
		List<Map<String, Object>> res = farmerMypageService.datelist(date);
		System.out.println(res);
		return res;
	}
	
	/**
	 * controller 결제 처리 업데이트 하기
	 * 
	 * @param  결제내역 객체
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/mypage/selllist2", method = RequestMethod.GET)
	public String updatePayment(int orderNo) {

		TBOrder order = new TBOrder();
		order.setOrderNo(orderNo);
		System.out.println(order);
		return Integer.toString(farmerMypageService.updatePayment(order));

	}
	
	@RequestMapping(value = "/mypage/cal23", method = RequestMethod.GET)
	public String cal2() {
		System.out.println("접속");
		return "mypage/cal23";
	}
}
