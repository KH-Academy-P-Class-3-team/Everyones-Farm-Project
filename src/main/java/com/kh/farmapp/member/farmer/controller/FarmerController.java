package com.kh.farmapp.member.farmer.controller;

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

import com.kh.farmapp.member.farmer.model.service.FarmerService;

import common.dto.Farm;
import common.dto.Farmer;
import common.dto.UserTB;

@Controller
@RequestMapping("/farmer")
public class FarmerController {

	@Autowired
	private FarmerService farmerService;
	
	//로그인 메인창
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {
		
		return "member/login";
	}
	
	//농부 로그인 창
	@RequestMapping(value="/farmerlogin.do",  method=RequestMethod.GET)
	public String farmerlogin() {
		
		return "member/farmerlogin";
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
	
	//회원가입 창
	@RequestMapping(value="farmerjoin.do")
	public String join() {
		return "member/farmerjoin";
	}
	
	//이용약관 창 띄우기
	@RequestMapping(value="/farmertos.do")
	public String tos() {
		return "member/farmertos";
	}
	
	//회원가입
	@RequestMapping("/joinimpl.do")
	public String joinImpl(
			Farmer farmer
			, Farm farm
			, @RequestParam Map<String, Object> commandMap
			, Model model
			, HttpServletRequest req
			) {
		
		String root = req.getContextPath();
		
		farmer.setZonecode((String) commandMap.get("zonecode"));
		
		int farmerres = farmerService.insertFarmer(farmer); 
		
		farm.setPhone((String) commandMap.get("farmphone"));
		farm.setZonecode((String) commandMap.get("farmzonecode"));
		farm.setFirstAddress((String) commandMap.get("farmfirstAddress"));
		farm.setSecondAddress((String) commandMap.get("farmsecondAddress"));
		
		int farmres = farmerService.insertFarm(farm);
		
		System.out.println(commandMap);
		System.out.println(farm.getZonecode());
		
		
		if(farmerres>0 && farmres>0 ) {
			model.addAttribute("alertMsg", "관리자에게 회원가입을 요청하였습니다");
			model.addAttribute("url", root+"/farmer/farmerlogin.do");
		} else {
			model.addAttribute("alertMsg", "회원가입에 실패했습니다");
			model.addAttribute("url", root+"/farmer/farmerjoin.do");
		}
		
		return "common/result";
		
	}
	
	//관리자에게 승인확인 보내기
	@RequestMapping("/sendmanager")
	public String SendManager() {
		return "member/farmersend";
	}
	
	//로그인
	@RequestMapping("/loginimpl.do")
	public String loginImpl(
		@RequestParam Map<String,Object> commandMap
		, HttpSession session
		, Model model) {
		
		Farmer res = farmerService.selectFarmer(commandMap);
		
		if(res!=null) {
			session.setAttribute("farmerInfo", res);
			model.addAttribute("alertMsg", "로그인 성공");
			model.addAttribute("url", "login.do");
		} else {
			model.addAttribute("alertMsg", "로그인 실패");
			model.addAttribute("url", "farmerlogin.do");
		}
		
		return "common/result";
	}
	
	//아이디 중복 체크
	@RequestMapping("idcheck.do")
	@ResponseBody
	public String idCheck(String farmerId) {
		
		int res = farmerService.selectIdCheck(farmerId);
		
		if(res>0) {
			return farmerId;
		} else {
			return "";
		}
	}
	
	//이메일 중복 체크
	@RequestMapping("emailcheck.do")
	@ResponseBody
	public String emailCheck(String email) {
		int res = farmerService.selectEmailCheck(email);
		
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
		int res = farmerService.selectPhoneCheck(phone);
		
		if(res>0) {
			return phone;
		} else {
			return "";
		}
	}
	
	//농장전화번호 중복 체크
	@RequestMapping("farmphonecheck.do")
	@ResponseBody
	public String farmphoneCheck(String phone) {
		int res = farmerService.selectfarmPhoneCheck(phone);
		
		if(res>0) {
			return phone;
		} else {
			return "";
		}
	}
	
	//아이디 찾기
	@RequestMapping("findinfo.do")
	public String findinfo(
			@RequestParam Map<String, Object> commandMap
			, Model model
			, HttpServletRequest req) {
		Farmer res = farmerService.findId(commandMap);
		if(res!=null) {
			req.setAttribute("farmerInfo", res);
			return "member/findIdResult";
		} else {
			return "member/findError";
		}
	}

	//비밀번호 찾기 이메일 보내기
	@RequestMapping("pwchangemail.do")
	public String findPwEmail(
			Farmer farmer
			, HttpServletRequest req
			, @RequestParam Map<String, Object> commandMap) {
		
		Farmer res = farmerService.findPw(commandMap);
		
		String urlPath = req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
		
		if(res!=null) {
			farmerService.findPwMailSend(farmer, urlPath);
			req.setAttribute("farmerInfo", res);
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
			, Farmer farmer) {
		Farmer res = farmerService.findPw(commandMap);
		if(res!=null) {
			req.setAttribute("farmerInfo", res);
			return "member/changePwfarmer";
		} else {
			return "member/findError";
		}
	}
	
	//비밀번호 변경
	@RequestMapping("pwchange.do")
	public String pwchange(
			Farmer farmer
			, HttpServletRequest req
			, @RequestParam Map<String, Object> commandMap
			, Model model) {
		
		int isupdate = farmerService.updatePw(farmer);
		
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
		session.invalidate();
		return "main/index"; 
	}
}
