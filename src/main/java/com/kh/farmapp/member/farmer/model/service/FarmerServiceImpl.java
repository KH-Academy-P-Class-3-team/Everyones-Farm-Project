package com.kh.farmapp.member.farmer.model.service;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.farmapp.member.farmer.model.dao.FarmerDao;

import common.dto.Farm;
import common.dto.Farmer;

@Service
public class FarmerServiceImpl implements FarmerService {

	@Autowired
	private FarmerDao farmerDao;
	
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder; 
	
	@Override 
	public int insertFarmer(Farmer farmer) { 
		String password = farmer.getFarmerPw();
		password = passwordEncoder.encode(password);
		
		farmer.setFarmerPw(password);
		return farmerDao.insertFarmer(farmer); 
	}
	  
	@Override 
	public int insertFarm(Farm farm) { 
		return farmerDao.insertFarm(farm); 
	}

	@Override
	public Farmer selectFarmer(Map<String, Object> commandMap) {
		
		String password = (String)commandMap.get("farmerPw");
		Farmer farmer = farmerDao.selectFarmer(commandMap);
		
		if(passwordEncoder.matches(password, farmer.getFarmerPw())) {
			farmer.setFarmerPw(password);
			return farmer;
		} else {
			return null;
		}
	}

	@Override
	public Farmer findId(Map<String, Object> commandMap) {
		return farmerDao.findFarmerId(commandMap);
	}

	@Override
	public Farmer findPw(Map<String, Object> commandMap) {
		return farmerDao.findFarmerPw(commandMap);
	}

	@Override
	public Farmer findFarmerId(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void findPwMailSend(Farmer farmer, String urlPath) {

		String setFrom="everyonesfarm@naver.com";
		String tomail = farmer.getEmail();
		String title = "[모두의농장]비밀번호를 변경해주세요!";
		String htmlBody = 
			"<form action='http://" + urlPath +"/farmer/pwchangeform.do'" 
					+ "method='post'>"
					+ "<h3>비밀번호를 변경해주세요</h3>"
					+ "<input type='hidden' value='"
					+ farmer.getFarmerId() + "' name='farmerId'>"
					+ "<input type='hidden' value='"
					+ farmer.getEmail() + "' name='email'>"
					+ "<button type='submit' style='background-color: #D1E9CA;border-color: #D1E9CA;box-sizing: border-box;border-radius: 5px;width: 200px;'>비밀번호 변경하기</button></form>";
		
		try {
			mailSender.send(new MimeMessagePreparator() {
			   public void prepare(MimeMessage mimeMessage) throws MessagingException {
			     MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			     message.setFrom(setFrom);
			     message.setTo(tomail);
			     message.setSubject(title);
			     
			     message.setText(htmlBody, true);
			   }
		});
		} catch(Exception e) {
		}
	}

	@Override
	public int updatePw(Farmer farmer) {
		String password = farmer.getFarmerPw();
		password = passwordEncoder.encode(password);
		
		farmer.setFarmerPw(password);
		return farmerDao.updatePw(farmer);
	}
	
	@Override
	public int selectIdCheck(String farmerId) {
		return farmerDao.selectIdCheck(farmerId);
	}
	
	@Override
	public int selectEmailCheck(String email) {
		return farmerDao.selectEmailCheck(email);
	}
	
	@Override
	public int selectPhoneCheck(String phone) {
		return farmerDao.selectPhoneCheck(phone);
	}
	
	@Override
	public int selectfarmPhoneCheck(String phone) {
		return farmerDao.selectfarmPhoneCheck(phone);
	}
	
}
