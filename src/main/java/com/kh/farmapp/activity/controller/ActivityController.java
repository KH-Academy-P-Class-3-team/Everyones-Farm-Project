package com.kh.farmapp.activity.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.activity.model.service.ActivityService;

import common.dto.Application;
import common.dto.Farm;
import common.dto.FarmActivity;
import common.dto.FarmActivitySchedule;
import common.dto.Farmer;
import common.dto.UserTB;

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
		
		for(int i=0; i<timeArray.length; i++) {
			FarmActivitySchedule schedule = new FarmActivitySchedule();
			schedule.setTime(timeArray[i]);
			schedule.setContent(contentArray[i]);
			schedule.setEtc(etcArray[i]);
			scheduleList.add(schedule);
		}
		
		
		Farmer farmer = (Farmer)session.getAttribute("farmerInfo");
		
		//테스트용 Farm 객체
//		Farmer farmer = new Farmer();
//		farmer.setFarmerNo(1);

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
		
//		Farmer farmer = (Farmer)session.getAttribute("farmerInfo");

		//테스트용 Farmer 객체
		Farmer farmer = new Farmer();
		farmer.setFarmerNo(1);
		farmer.setFarmerId("suzzung");
		
		Farm farm = activityService.selectFarmByFarmerNo(farmer);
		
		Map<String, Object> commandMap = activityService.selectActivityListByFarmNo(farm); 
		
		//테스트용 Farmer
		mav.addObject("farmerInfo", farmer);
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
	public ModelAndView activityDetail(HttpSession session, int activityNo) {
		
		Farmer farmer = (Farmer)session.getAttribute("farmerInfo");
		
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> commandMap = activityService.selectActivityDetail(activityNo);

		mav.addObject("farmerInfo", farmer);
		mav.addObject("fileList", commandMap.get("fileList"));
		mav.addObject("schedule", commandMap.get("schedule"));
		mav.addObject("data", commandMap);
		mav.setViewName("activity/activityDetail");
		
		return mav;
		
	}
	
	
	@RequestMapping("/activity/activityDelete.do")
	public ModelAndView activityDelete(HttpServletRequest request, int activityNo) {
		
		int res = activityService.activityDelete(activityNo);
		
		ModelAndView mav = new ModelAndView();
		
		if(res > 0) {
			mav.addObject("msg", "체험 활동이 정상적으로 삭제되었습니다");
		} else {
			mav.addObject("msg", "체험 활동 삭제 실패");
		}

		mav.addObject("url", "activityList.do");
		mav.setViewName("activity/result");
		
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
	 * 체험활동 신청 폼 이동 [GET]
	 * @param activityNo - 활동 번호
	 * @return ModelAndView - Activity, View
	 */
	@RequestMapping(value = "/activity/activityApplication.do", method = RequestMethod.GET)
	public ModelAndView activityApplicationForm(HttpSession session, int activityNo, int isHelp) {
		
		UserTB user = (UserTB)session.getAttribute("userInfo");
		Farmer farmer = (Farmer)session.getAttribute("farmerInfo");
		
		FarmActivity activity = activityService.selectActivityByActivityNo(activityNo);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("activity", activity);
		
		if(user == null && farmer == null) {
			mav.addObject("msg", "로그인 후 신청 가능합니다");
			mav.addObject("url", "experienceList.do");
			mav.setViewName("activity/result");
		} else {
			
			if(isHelp == 0) {
				mav.setViewName("activity/experienceApplication");
			} else {
				mav.setViewName("activity/helpApplication");
			}
			
		}
		
		return mav;
		
	}

	
	/**
	 * 활동 신청서 제출 [POST]
	 * @param application - 활동 신청 정보 객체
	 * @return ModelAndView - View
	 */
	@RequestMapping(value = "/activity/activityApplication.do", method = RequestMethod.POST)
	public ModelAndView activityApplicationSubmit(HttpSession session, Application application, String date) {
		
		UserTB user = (UserTB)session.getAttribute("userInfo");
		
		//테스트용 user 객체
//		UserTB user = new UserTB();
//		user.setUserNo(1);

		application.setUserNo(user.getUserNo());
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			
			// String 타입 날짜를 java.util.Date 타입으로 변환
			Date activityDate = sdf.parse(date);

			application.setActivityDate(activityDate);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		int res = activityService.insertApplication(application);
		
		ModelAndView mav = new ModelAndView();
		
		if(res > 0) {
			mav.addObject("msg", "체험 활동 신청이 완료되었습니다.");
		} else {
			mav.addObject("msg", "체험 활동 신청에 실패하였습니다.");
		}

		mav.addObject("url", "experienceList.do");
		mav.setViewName("activity/result");
		
		return mav;

	}
	
	
}
