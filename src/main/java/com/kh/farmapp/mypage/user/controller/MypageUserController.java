package com.kh.farmapp.mypage.user.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.mypage.user.model.service.MyPageService;

import common.dto.UserTB;

@Controller
public class MypageUserController {

	@Autowired
	private MyPageService mypageService;

	//마이 페이지 메인으로 보내는 메서드
	@RequestMapping("mypage/user/modify")
	public ModelAndView mypage(HttpSession session) {
		
		//테스트 데이터
		UserTB user = new UserTB();
		user.setUserNo(1);
		session.setAttribute("userInfo", user);
		
		ModelAndView mav = new ModelAndView();
		
		user = mypageService.selectUser(user);
		user.setUserName("아무개");
		user.setZoneCode("123456");
		user.setFirstAddress("none");
		System.out.println(user);
		mav.addObject("userData", user);
		mav.setViewName("mypage/user/modify");
		
		return mav;
		
	}
	
	//회원 정보를 수정한다
	@RequestMapping("/modify/userInfo")
	public String modifyPirvate(@ModelAttribute Map<String, Object> map, HttpSession session) {
		
		System.out.println("되나?");
		mypageService.modifyUser(map);
			
			
		return "mypage/user/modify";
			
		
	}
	//회원 사진을를 수정한다
	@RequestMapping("modify/userImg")
	public ModelAndView modifyImg(UserTB user, HttpSession session, @RequestParam File file){
		
		
		ModelAndView mav = new ModelAndView();
		String root = session.getServletContext().getRealPath("farmapp/");
		
		mypageService.insertFile(user, file, root);
		
		return null;
	}

	
	@RequestMapping("mypage/user/deleteId")
	public void deleteID() {
	}
	
	
	
	@RequestMapping(value = "/confirm", method=RequestMethod.POST)
	public String deleteID(
			String password,
			HttpSession session,
			Model model
			) {
		System.out.println("접속");
		UserTB user = (UserTB) session.getAttribute("userInfo");
		user.setUserPw(password);
		
		int res = mypageService.leave(user);
		
		if(res > 0) {
			//Model.addAttribute(K,V) 
			//: view에 전달할 데이터를 추가하는 메서드
			model.addAttribute("alertMsg","회원정보 수정에 성공했습니다.");
			model.addAttribute("url", "mypage.do");
		}else {
			model.addAttribute("alertMsg", "회원정보 수정에 실패했습니다.");
			model.addAttribute("url", "mypage.do");
		}
		
		return "common/result";
		
	}


	//회원 사진을 수정한다.
	@RequestMapping("mypage/user/modifyImg")
	public String modifyprofile(UserTB user, HttpSession session, Model model) {
		
		System.out.println("active");
		
		return "redirect:modify";
	}

	//회원 탈퇴 하는 메서드
	public String leave(HttpSession session,
			UserTB user, String userId) {
		return "";
	}




}
