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
	public UserTB findId(Map<String, Object> commandMap) {
		return userDao.findUserId(commandMap); 
	}
	
	@Override
	public UserTB findPw(Map<String, Object> commandMap) {
		return userDao.findUserPw(commandMap);
	}
	
	@Override
	public void findPwMailSend(UserTB user, String urlPath) {
		
		String setFrom="everyonesfarm@naver.com";
		String tomail = user.getEmail();
		String title = "[모두의농장]비밀번호를 변경해주세요!";
		String htmlBody = 
			"<form action='http://" + urlPath +"/user/pwchangeform.do'" 
					+ "method='post'>"
					+ "<h3>비밀번호를 변경해주세요</h3>"
					+ "<input type='hidden' value='"
					+ user.getUserId() + "' name='userId'>"
					+ "<input type='hidden' value='"
					+ user.getEmail() + "' name='email'>"
					+ "<button type='submit' style='padding: 10px 0px;background-color: #D1E9CA;border-color: #D1E9CA;box-sizing: border-box;border-radius: 5px;width: 200px;margin-top: 5px;'>비밀번호 변경하러 가기</button></form>";
		
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
	public int updatePw(UserTB user) {
		return userDao.updatePw(user);
	}
	
	@Override
	public int selectIdCheck(String userId) {
		return userDao.selectIdCheck(userId);
	}
	
	@Override
	public int selectEmailCheck(String email) {
		return userDao.selectEmailCheck(email);
	}
	
	@Override
	public int selectPhoneCheck(String phone) {
		return userDao.selectPhoneCheck(phone);
	}
	
}
