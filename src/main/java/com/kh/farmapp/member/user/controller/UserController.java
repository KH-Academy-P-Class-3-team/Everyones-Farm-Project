package com.kh.farmapp.member.user.controller;

import java.util.HashMap;
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
	
	//로그인 메인 창 띄우기
	@RequestMapping(value="/login.do")
	public String login() {
		
		return "member/login";
	}
	
	//회원가입 메인 창 띄우기
	@RequestMapping(value="/join.do")
	public String join() {
		
		return "member/join";
	}
	
	//일반 회원 로그인 창
	@RequestMapping(value="/userlogin.do")
	public String userlogin(
			) {
		return "member/userlogin";
	}
	
	//일반 회원 카카오 로그인 창
	@RequestMapping(value="/kakaologin.do")
	public String kakaologin(
			@RequestParam(value="code", required = false) String code
			, HttpSession session
			, HttpServletRequest req
			, Model model
			) throws Exception{
		System.out.println("#########" + code);
		String accessToken = userService.getAccessToken(code);
		System.out.println(accessToken);
		HashMap<String, Object> userIn = userService.getUserInfo(accessToken);
		if(userIn != null) {
			session.setAttribute("kakaoInfo", userIn);
			model.addAttribute("alertMsg", "로그인 되었습니다");
			model.addAttribute("url", req.getContextPath());
		} else {
			model.addAttribute("alertMsg", "회원가입에 실패했습니다");
			model.addAttribute("url", req.getContextPath()+"/user/userjoin.do");
		}
		System.out.println(userIn.get("email"));
		return "common/result";
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
	
	//비밀번호 찾기 창
	@RequestMapping(value="/findpw.do")
	public String findPw() {
		return "member/findPw";
	}
	
	//회원가입 창 띄우기
	@RequestMapping(value="/userjoin.do")
	public String userjoin() {
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
			model.addAttribute("alertMsg", "로그인 성공");
			// main 페이지로 가게 만들어 놓을게요!
//			model.addAttribute("url", "login.do");
			model.addAttribute("url", req.getContextPath());
		} else {
			model.addAttribute("alertMsg", "로그인 실패");
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
	
	//이메일 중복 체크
	@RequestMapping("emailcheck.do")
	@ResponseBody
	public String emailCheck(String email) {
		int res = userService.selectEmailCheck(email);
		
		if(res>0) {
			return email;
		} else {
			return "";
		}
	}
	
	//전화번호 중복 체크
	@RequestMapping("phonecheck.do")
	@ResponseBody
	public String phoneCheck(String phone) {
		int res = userService.selectPhoneCheck(phone);
		
		if(res>0) {
			return phone;
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
	
	//아이디 찾기
	@RequestMapping("findinfo.do")
	public String findinfo(
			@RequestParam Map<String, Object> commandMap
			, Model model
			, HttpServletRequest req) {
		UserTB res = userService.findId(commandMap);
		if(res!=null) {
			req.setAttribute("userId", res);
			return "member/findIdResult";
		} else {
			return "member/findError";
		}
	}
	
	//비밀번호 찾기 이메일 보내기
	@RequestMapping("pwchangemail.do")
	public String findPwEmail(
			UserTB user
			, HttpServletRequest req
			, @RequestParam Map<String, Object> commandMap) {
		
		UserTB res = userService.findPw(commandMap);
		
		String urlPath = req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
		
		if(res!=null) {
			userService.findPwMailSend(user, urlPath);
			req.setAttribute("userPw", res);
			return "member/findPwResult";
		} else {
			return "member/findError";
		}
		
	}
	
	//비밀번호 변경화면창
	@RequestMapping("pwchangeform.do")
	public String pwchangeform(
			HttpServletRequest req
			, @RequestParam Map<String, Object> commandMap
			, UserTB user) {
		UserTB res = userService.findPw(commandMap);
		if(res!=null) {
			req.setAttribute("userPw", res);
			return "member/changePw";
		} else {
			return "member/findError";
		}
	}
	
	//비밀번호 변경
	@RequestMapping("pwchange.do")
	public String pwchange(
			UserTB user
			, HttpServletRequest req
			, @RequestParam Map<String, Object> commandMap
			, Model model) {
		
		int isupdate = userService.updatePw(user);
//		if(isupdate>0) {
//			return "member/login";
//		} else {
//			return "member/findmember";
//		}
		
		if(isupdate>0) {
			model.addAttribute("alertMsg", "비밀번호가 변경되었습니다");
			model.addAttribute("url", "login.do");
		} else {
			model.addAttribute("alertMsg", "비밀번호가 변경 실패");
			model.addAttribute("url", "findmember.do");
		}
		
		return "common/result";
	}
	
	
	//로그아웃
	@RequestMapping("logout")
	public String logout(HttpSession session, HttpServletResponse response) {

		// session 에 저장하는 정보가 많을 경우 전부다 삭제 되므로 안전하게 removeAttribute 를 사용해서 로그아웃 기능을 구현하도록 하겠습니다.
//		session.invalidate();
		if( session.getAttribute("userInfo") != null) {
			session.removeAttribute("userInfo");
		}
		
		return "redirect:/"; 
	}
	
	//카카오 로그아웃
	@RequestMapping("kakaologout")
	public String kakaologout(HttpSession session) {

		if( session.getAttribute("kakaoInfo") != null) {
			session.removeAttribute("kakaoInfo");
			session.removeAttribute("accessToken");
		}
    
		return "redirect:/";
	}
}
