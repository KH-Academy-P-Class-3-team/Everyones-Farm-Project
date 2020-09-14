package com.kh.farmapp.mypage.user.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.kh.farmapp.admin.notice.controller.AdminNoticeController;
import com.kh.farmapp.mypage.user.model.service.MyPageService;

import common.dto.AnsweredOneonone;
import common.dto.QuestionOneonone;
import common.dto.UserTB;

@Controller
public class MypageO3Controller {

	// log 를 남기기 위한 Logger 객체
	private static final Logger logger = LoggerFactory.getLogger(AdminNoticeController.class);

	@Autowired
	private MyPageService mypageService;

	//일대일 문의 질문 리스트
	@RequestMapping("mypage/user/mypageO3List")
	public ModelAndView o3List(@RequestParam(required=false, defaultValue="1")int cPage, HttpSession session) {

		UserTB user = (UserTB) session.getAttribute("userInfo");
		ModelAndView mav = new ModelAndView();
		

		if( user == null) {
			mav.addObject("alertMsg", "로그인이 필요합니다.");
			mav.addObject("url", "../../user/login.do");
			mav.setViewName("common/result");
			return mav;
		}
		
		int cntPerPage = 10;
		Map<String, Object> o3pList = mypageService.o3List(cPage, cntPerPage, user);

		System.out.println(o3pList.toString());

		mav.addObject("page", o3pList.get("page"));
		mav.addObject("list", o3pList);
		mav.setViewName("mypage/user/mypageO3List");

		return mav;
	}

	//일대일 문의 디테일 보기
	@RequestMapping("mypage/user/mypageO3Detail")
	public ModelAndView o3Detail(int QUESTION_NO, HttpSession session) {

		UserTB user = (UserTB) session.getAttribute("userInfo");
		ModelAndView mav = new ModelAndView();
		

		//디테일 페이지 정보
		QuestionOneonone o3 = mypageService.o3Detail(QUESTION_NO, user.getUserNo());
		System.out.println(o3);
		//답변 정보 
		AnsweredOneonone answer = mypageService.answerDetail(QUESTION_NO);

		//게시물 수 구하기
		Map<String, Object> total = mypageService.getTotal(user);

		int max = Integer.parseInt(String.valueOf(total.get("MAX")));
		int min = Integer.parseInt(String.valueOf(total.get("MIN")));
		//위아래 페이지로 넘어가기
		QuestionOneonone down = new QuestionOneonone();
		int forDown = QUESTION_NO;
		while( min <= forDown) {
			--forDown;
			down = mypageService.o3Detail(forDown, user.getUserNo());
			
			if(down != null)
			break;
		}

		QuestionOneonone up = new QuestionOneonone();
		int forUp = QUESTION_NO;
		while( max >= forUp) {
			++forUp;
			up = mypageService.o3Detail(forUp, user.getUserNo());
			
			if(up != null)
			break;
		}
		mav.addObject("up", up);
		mav.addObject("down", down);
		mav.addObject("total", total);
		mav.addObject("one", o3);
		mav.addObject("answer", answer);
		mav.setViewName("mypage/user/mypageO3Detail");

		return mav;

	}
	@RequestMapping("mypage/user/mypageO3Write")
	public ModelAndView o3Write(HttpSession session) {

		UserTB user = (UserTB) session.getAttribute("userInfo");
		ModelAndView mav = new ModelAndView();
		

		if( user == null) {
			mav.addObject("alertMsg", "로그인이 필요합니다.");
			mav.addObject("url", "../../user/login.do");
			mav.setViewName("common/result");
			return mav;
		}
		
		mav.setViewName("mypage/user/mypageO3Write");
		return mav;
		
		
	}

	
	//일대일 문의 작성
	@RequestMapping(value = "/mypage/user/write", method = RequestMethod.POST)
	public String adminNoticeWriteProc(
				@ModelAttribute QuestionOneonone question
				, HttpSession session
				, Model model
			) {
		// 로그인이 안되어 있을 경우, 바로 로그인 페이지로 이동
		UserTB user = (UserTB) session.getAttribute("userInfo");
		
		// logger 찍기 - 현재 어디 method 인지
		logger.info("/adminnotice/write - [POST] 요청");
		
		// RequestParam question_oneonone 객체 테스트 출력
		logger.debug("notice: " + question.toString());
		
		// quesion_oneonone 객체의 userNo set 하기
		question.setUserNo(user.getUserNo());
		
		int res = mypageService.wirteO3(question);
		
		if(res > 0) {
			logger.info("공지사항 작성 성공~");
			
			// 리스트 화면으로 이동
			model.addAttribute("alertMsg", "공지사항이 성공적으로 작성됐습니다.");
			model.addAttribute("url", "mypageO3List");
		} else {
			logger.info("공지사항 작성 실패...");
			model.addAttribute("alertMsg", "공지사항 작성이 실패했습니다...");
			model.addAttribute("url", "mypageO3List");
		}
		
		return "common/result";
	}
	
	// 일대일 문의 이미지 업로드
	@RequestMapping(value = "/mypage/user/fileupload", method = RequestMethod.POST)
	@ResponseBody
	public String adminNoticeImgUpload(
			HttpServletRequest req
			, HttpServletResponse resp
			, MultipartHttpServletRequest multiFile
			){
		
		JsonObject json = new JsonObject();
		PrintWriter pw = null;
		OutputStream out = null;
		MultipartFile file = multiFile.getFile("upload");
		
		if( file != null ) {
			
			if( file.getSize() > 0 && StringUtils.isNotBlank(file.getName()) ) {
				
				if( file.getContentType().toLowerCase().startsWith("image/") ) {
					
					try {
						
						String fileName = file.getName();
						byte[] bytes = file.getBytes();
						String uploadPath = req.getServletContext().getRealPath("/resources") + "/ckimg";
//						logger.debug(uploadPath);
						File uploadFile = new File(uploadPath);
						
						if(!uploadFile.exists()) {
							
							uploadFile.mkdirs();
							
						}
						
						fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
						uploadPath = uploadPath + "/" + fileName;
//						logger.debug(uploadPath);
						out = new FileOutputStream(new File(uploadPath));
						out.write(bytes);
						out.flush();
						
						pw = resp.getWriter();
						resp.setContentType("text/html");
						String fileUrl = req.getContextPath() + "/resources/ckimg/" + fileName;
//						logger.debug(fileUrl);
						
						//json 데이터로 등록
						json.addProperty("uploaded", 1);
						json.addProperty("fileName", fileName);
						json.addProperty("url", fileUrl);
						
						pw.println(json);
						pw.flush();
						
					} catch (IOException e) {
					
						e.printStackTrace();
						
					} finally {
						
						try {
							if(out != null) {
								out.close();
							}
							if(pw != null) {
								pw.close();
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
					
				}
				
			}
			
		}
		
		return null;
	}

	
	
	
	
	
	

	//일대일 문의 삭제
	@RequestMapping("mypage/user/deleteO3")
	public ModelAndView o3Delete(int QUESTION_NO) {
		
		ModelAndView mav = new ModelAndView();
		int res = mypageService.o3Delete(QUESTION_NO);
		
		if(res > 0) {
			mav.addObject("alertMsg", "삭제되었습니다");
			mav.addObject("url", "/farmapp/mypage/user/mypageO3List");
			mav.setViewName("common/result");
		}else {
			mav.addObject("alertMsg", "삭제 거부되었습니다.");
			mav.addObject("url", "/farmapp/mypage/user/mypageO3Detail?QUESTION_NO="+QUESTION_NO);
			mav.setViewName("common/result");
		}
		
		return mav;
	}


}


