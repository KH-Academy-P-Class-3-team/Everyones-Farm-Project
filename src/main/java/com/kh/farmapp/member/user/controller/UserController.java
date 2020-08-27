package com.kh.farmapp.member.user.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.member.user.model.service.UserService;

import common.dto.UserTB;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	// 임시 로그아웃 method
	@RequestMapping(value = "/logout")
	public String logoutProc(
				HttpServletRequest req
				, HttpSession session
			) {
		
		// session 영역에 일반 사용자의 로그인 정보가 있을 때
		if(session.getAttribute("userInfo") != null) {
			// session 영역에 'userInfo' 정보를 삭제함으로써 로그아웃 함!
			session.removeAttribute("userInfo");
		}
		
		return "redirect:/";
	}
	
	//로그인 메인 창 띄우기
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {
		
		return "member/login";
	}
	
	//일반 회원 로그인 창
	@RequestMapping(value="/userlogin.do", method=RequestMethod.GET)
	public String userlogin() {
		
		return "member/userlogin";
	}
	
	//회원 정보 찾기 메인
	@RequestMapping(value="/findmember.do")
	public String findMember() {
		
		return "member/findmember";
	}
	
	//아이디 찾기 창
	@RequestMapping(value="/findid.do")
	public String findId() {
		
		return "member/findId";
	}
	
	//회원가입 창 띄우기
	@RequestMapping(value="/userjoin.do")
	public String join() {
		return "member/userjoin";
	}
	
	//이용약관 창 띄우기
	@RequestMapping(value="/usertos.do")
	public String tos() {
		return "member/usertos";
	}
	
	//회원가입
	@RequestMapping("/joinimpl.do")
	public String joinImpl(
		@ModelAttribute UserTB user
		, Model model
		, HttpServletRequest req
			) {
		
		String root = req.getContextPath();
		int res = userService.insertUser(user);
		if(res>0) {
			//addAttribute : ModelAndView의 addObject와 같다
			model.addAttribute("alertMsg", "회원가입에 성공했습니다");
			model.addAttribute("url", root+"/user/userlogin.do");
		} else {
			model.addAttribute("alertMsg", "회원가입에 실패했습니다");
			model.addAttribute("url", root+"/user/userjoin.do");
		}
		
		return "common/result";
	}
	
	//로그인
	@RequestMapping("/loginimpl.do")
	public String loginImpl(
		@RequestParam Map<String,Object> commandMap
		, HttpSession session
		, Model model
		, HttpServletRequest req
			) {
		
		UserTB res = userService.selectUser(commandMap);
		if(res!=null) {
			session.setAttribute("userInfo", res);
			model.addAttribute("alertMsg", "환영합니다");
			// 메인화면으로 이동
			model.addAttribute("url", req.getContextPath());
//			model.addAttribute("url", "userlogin.do");
		} else {
			model.addAttribute("alertMsg", "로그인에 실패하였습니다");
			model.addAttribute("url", "userlogin.do");
		}
		
		return "common/result";
	}
	
	//아이디 중복 체크
	@RequestMapping("idcheck.do")
	@ResponseBody
	public String idCheck(String userId) {
		
		int res = userService.selectIdCheck(userId);
		
		if(res>0) {
			return userId;
		} else {
			return "";
		}
	}
	
	//가입 이메일 보내기
	@RequestMapping("joinemailcheck.do")
	public ModelAndView joinEmailCheck(
			UserTB user
			, HttpServletRequest request
			) {
		ModelAndView mav = new ModelAndView();
		
		String urlPath = request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		
		userService.joinMailSend(user, urlPath);

		mav.addObject("alertMsg", "이메일로 회원 가입 메일을 전송하였습니다");
		mav.addObject("url", "login.do");
		mav.setViewName("common/result");
		
		return mav;
	}
//	
//	//비밀번호 찾기 이메일 보내기
//	@RequestMapping
//	public ModelAndView findPwEmail() {
//		ModelAndView mav = new ModelAndView();
//		return mav;
//	}
//	
//	//로그아웃
//	public void logout(HttpSession session, HttpServletResponse response) {
//		
//	}
}
