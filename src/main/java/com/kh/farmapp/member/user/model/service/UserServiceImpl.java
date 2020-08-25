package com.kh.farmapp.member.user.model.service;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.kh.farmapp.member.user.model.dao.UserDao;

import common.dto.UserTB;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	JavaMailSender mailSender;
	
	@Override
	public int insertUser(UserTB user) {
		return userDao.insertUser(user);
	}
	
	@Override
	public UserTB selectUser(Map<String, Object> commandMap) {
		
//		UserTB user = userDao.selectUser(commandMap);
		return userDao.selectUser(commandMap);
	}
	
	@Override
	public void joinMailSend(UserTB user, String urlPath) {
		
		String setFrom="everyonesfarm@naver.com";
		String tomail = user.getEmail();
		String title = "모두의농장에 오신 것을 환영합니다!";
		String htmlBody = 
			"<form action='http://" + urlPath +"/user/joinimpl.do'" 
					+ "method='post'>"
					+ "<h3>회원가입을 환영합니다.</h3>"
					+ "<input type='hidden' value='"
					+ user.getUserId() + "' name='userId'>"
					+ "<input type='hidden' value='"
					+ user.getUserPw() + "' name='userPw'>"
					+ "<input type='hidden' value='"
					+ user.getUserName() + "' name='userName'>"
					+ "<input type='hidden' value='"
					+ user.getPhone() + "' name='phone'>"
					+ "<input type='hidden' value='"
					+ user.getEmail() + "' name='email'>"
					+ "<input type='hidden' value='"
					+ user.getZoneCode() + "' name='zoneCode'>"
					+ "<input type='hidden' value='"
					+ user.getFirstAddress() + "' name='firstAddress'>"
					+ "<input type='hidden' value='"
					+ user.getSecondAddress() + "' name='secondAddress'>"		
					+ "<button type='submit'>가입확인</button></form>";
		
		try {
			mailSender.send(new MimeMessagePreparator() {
			   public void prepare(MimeMessage mimeMessage) throws MessagingException {
			     MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			     message.setFrom(setFrom);
			     message.setTo(tomail);
			     message.setSubject(title);
			     
			     //setText(htmlBody, true)
			     //두번째 매개변수로 html여부를 지정
			     //	true면 html, false면 텍스트
			     message.setText(htmlBody, true);
			   }
		});
		} catch(Exception e) {
		}

	}
	
	@Override
	public UserTB findId(UserTB user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public UserTB findPw(UserTB user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public UserTB findUserId(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void findPwMailSend(UserTB user, String urlPath) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean updatePw(UserTB user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public int selectIdCheck(String userId) {
		return userDao.selectIdCheck(userId);
	}
	
}
