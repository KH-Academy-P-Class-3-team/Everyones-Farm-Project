package com.kh.farmapp.activity.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.activity.model.service.ActivityService;

import common.dto.Farm;
import common.dto.FarmActivity;
import common.dto.FarmActivitySchedule;
import common.dto.Farmer;

@Controller
public class ActivityController {

	@Autowired
	private ActivityService activityService;
	
	/**
	 * 체험활동 목록 조회
	 * @param cPage - 현재 페이지
	 * @return ModelAndView - farm, paging, activityList, fileList
	 */
	@RequestMapping("/activity/experienceList.do")
	public ModelAndView experienceList(@RequestParam(required=false, defaultValue="1") int cPage) {
		
		ModelAndView mav = new ModelAndView();
		
		int cntPerPage = 9;
		
		Map<String, Object> commandMap = activityService.selectActivityList(cPage, cntPerPage, 0);
		
		mav.addObject("farm", activityService.selectFarmList());
		mav.addObject("paging", commandMap.get("paging"));
		mav.addObject("activityList", commandMap.get("activityList"));
		mav.addObject("fileList", commandMap.get("fileList"));
		
		return mav;
	}
	
	
	/**
	 * 일손돕기 목록 조회
	 * @param cPage - 현재 페이지
	 * @return ModelAndView - farm, paging, activityList, fileList
	 */
	@RequestMapping("/activity/helpList.do")
	public ModelAndView helpList(@RequestParam(required=false, defaultValue="1") int cPage) {
		
		ModelAndView mav = new ModelAndView();
		
		int cntPerPage = 9;

		Map<String, Object> commandMap = activityService.selectActivityList(cPage, cntPerPage, 1);
		
		mav.addObject("farm", activityService.selectFarmList());
		mav.addObject("paging", commandMap.get("paging"));
		mav.addObject("activityList", commandMap.get("activityList"));
		mav.addObject("fileList", commandMap.get("fileList"));
		
		return mav;
	}
	
	
	
	/**
	 * 체험활동 등록 폼 이동 [GET]
	 */
	@RequestMapping(value = "activity/activityForm.do", method = RequestMethod.GET)
	public void activityForm() { }
	
	
	/**
	 * 체험활동 등록 [POST]
	 * @param farmActivity - 입력한 활동 정보
	 * @param files - 업로드한 활동 파일(사진)
	 * @param timeArray - 일정 시간
	 * @param contentArray - 일정 내용
	 * @param etcArray - 일정 비고
	 * @param session - servletContext 경로를 가지고있는 session 객체
	 * @return ModelAndView - 등록 여부 메시지, View(result.jsp)
	 */
	@RequestMapping(value = "activity/activityForm.do", method = RequestMethod.POST)
	public ModelAndView activityFormSubmit(
			FarmActivity farmActivity
			, @RequestParam List<MultipartFile> files
			, @RequestParam("time") String[] timeArray
			, @RequestParam("table-content") String[] contentArray
			, @RequestParam("etc") String[] etcArray
			, HttpSession session
			) {
		
		ModelAndView mav = new ModelAndView();
		
		String root  = session.getServletContext().getRealPath("/");
		
		
		List<FarmActivitySchedule> scheduleList = new ArrayList<FarmActivitySchedule>();
		
		System.out.println("Activity Controller 활동 등록 - timeArray: " + Arrays.toString(timeArray));
		
		for(int i=0; i<timeArray.length; i++) {
			FarmActivitySchedule schedule = new FarmActivitySchedule();
			schedule.setTime(timeArray[i]);
			schedule.setContent(contentArray[i]);
			schedule.setEtc(etcArray[i]);
			scheduleList.add(schedule);
		}
		
		
//		Farmer farmer = (Farmer)session.getAttribute("FarmerInfo");
		
		//테스트용 Farm 객체
		Farmer farmer = new Farmer();
		farmer.setFarmerNo(1);

		Farm farm = activityService.selectFarmByFarmerNo(farmer);
		
		farmActivity.setFarmNo(farm.getFarmNo());
		
		int res = activityService.insertActivity(farmActivity, files, root, scheduleList);
		
		if(res > 0) {
			mav.addObject("msg", "체험 활동이 정상적으로 등록되었습니다.");
		} else {
			mav.addObject("msg", "체험 활동 등록에 실패하였습니다.");
		}

		mav.addObject("url", "activityList.do");
		mav.setViewName("activity/result");
		
		return mav;
		
	}
	
	
	/**
	 * 농장 내 활동 목록 조회
	 * @param session - farmer 정보를 저장하고있는 session 객체
	 * @return ModelAndView - commandMap(activity, activityFile), farmerInfo, View(activityList.jsp)
	 */
	@RequestMapping("activity/activityList.do")
	public ModelAndView activityList(HttpSession session) {

		ModelAndView mav = new ModelAndView();
		
//		Farmer farmer = (Farmer)session.getAttribute("FarmerInfo");

		//테스트용 Farmer 객체
		Farmer farmer = new Farmer();
		farmer.setFarmerNo(1);
		
		Farm farm = activityService.selectFarmByFarmerNo(farmer);
		
		Map<String, Object> commandMap = activityService.selectActivityListByFarmNo(farm); 
		
//		mav.addObject("farmerInfo", farmer);
		mav.addObject("farmerInfo", "suzzung");
		mav.addObject("paging", commandMap.get("paging"));
		mav.addObject("data", commandMap);
		mav.setViewName("/activity/activityList");
		
		return mav;
		
	}

	

	/**
	 * 체험활동 상세보기
	 * @param activityNo - 활동 번호
	 * @return ModelAndView - Activity, view
	 */
	@RequestMapping("/activity/activityDetail.do")
	public ModelAndView activityDetail(int activityNo) {
		
		ModelAndView mav = new ModelAndView();
		
		System.out.println("activityNo : " + activityNo);
		
		Map<String, Object> commandMap = activityService.selectActivityDetail(activityNo);
		
		mav.addObject("data" + commandMap);
		mav.setViewName("/acivity/activityDetail");
		
		return mav;
		
	}
	
	/**
	 * 활동 검색
	 * @param isHelp - 일손돕기인지 여부
	 * @param title - 활동명
	 * @param filter - 활동명 또는 농장명
	 * @return ModelAndView - List, View
	 */
	@RequestMapping("/activity/searchActivity.do")
//	@ResponseBody
	public ModelAndView searchActivity(int isHelp, String title, String filter
			, @RequestParam(required=false, defaultValue="1") int cPage) {
		
		int cntPerPage = 9;
		
		Map<String, Object> commandMap = activityService.selectActivitySearch(cPage, cntPerPage, isHelp, title, filter);
		
		ModelAndView mav = new ModelAndView();
		
		if(((List<FarmActivity>)commandMap.get("activityList")).isEmpty()) {
			mav.addObject("msg", "조회된 결과가 없습니다.");
			
			if(isHelp == 0) {
				mav.addObject("url", "experienceList.do");
			} else {
				mav.addObject("url", "helpList.do");
			}
			mav.setViewName("activity/result");
			
		} else {
			mav.addObject("farm", activityService.selectFarmList());
			mav.addObject("paging", commandMap.get("paging"));
			mav.addObject("activity", commandMap.get("activityList"));
			mav.addObject("file", commandMap.get("fileList"));

			if(isHelp == 0) {
				mav.setViewName("activity/experienceResult");
			} else {
				mav.setViewName("activity/helpResult");
			}
			
		}
		
		return mav;
		
	}
	
	/**
	 * 농장체험 신청 폼
	 * @param activityNo - 활동 번호
	 * @return ModelAndView - Activity, View
	 */
//	@RequestMapping("/activity/experienceapplicationForm.do")
//	public ModelAndView experienceApplicationForm(int activityNo) {
//		
//		ModelAndView mav = new ModelAndView();
//		
//		return mav;
//		
//	}

	/**
	 * 일손돕기 신청 폼
	 * @param activityNo - 활동 번호
	 * @return ModelAndView - Activity, View
	 */
//	@RequestMapping("/activity/helpapplicationForm.do")
//	public ModelAndView helpApplicationForm(int activityNo) {
//		
//		ModelAndView mav = new ModelAndView();
//		
//		return mav;
//		
//	}
	
	/**
	 * 활동 신청서 제출
	 * @param application - 활동 신청 정보 객체
	 * @return ModelAndView - View
	 */
//	@RequestMapping("/activity/applicationSubmit.do")
//	public ModelAndView activityApplicationSubmit(Application application) {
//		
//		ModelAndView mav = new ModelAndView();
//		
//		return mav;
//
//	}
	
	
}
