package com.kh.farmapp.member.user.model.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
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

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kh.farmapp.member.user.model.dao.UserDao;

import common.dto.UserTB;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public int insertUser(UserTB user) {
		
		String password = user.getUserPw();
		password = passwordEncoder.encode(password);
		
		user.setUserPw(password);
		return userDao.insertUser(user);
	}
	
	@Override
	public UserTB selectUser(Map<String, Object> commandMap) {
		
		String password = (String) commandMap.get("userPw");
		UserTB user = userDao.selectUser(commandMap);
		
		if(passwordEncoder.matches(password, user.getUserPw())) {
			user.setUserPw(password);
			return user;
		} else {
			return null;
		}
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
					+ user.getZoneCode() + "' name='zonecode'>"
					+ "<input type='hidden' value='"
					+ user.getFirstAddress() + "' name='firstAddress'>"
					+ "<input type='hidden' value='"
					+ user.getSecondAddress() + "' name='secondAddress'>"		
					+ "<button type='submit' style='background-color: #D1E9CA;border-color: #D1E9CA;box-sizing: border-box;border-radius: 5px;width: 200px;'>가입확인</button></form>";
		
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
	public int updatePw(UserTB user) {
		String password = user.getUserPw();
		password = passwordEncoder.encode(password);
		
		user.setUserPw(password);
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
	
	@Override
	public String getAccessToken(String code) {
		
		String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();


            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //    POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=9e026a9e81698d2522ecd927296dfadd");  //본인이 발급받은 key
            sb.append("&redirect_uri=http://localhost:8012/farmapp/user/kakaologin.do");     // 본인이 설정해 놓은 경로
            sb.append("&code=" + code);
            bw.write(sb.toString());
            bw.flush();

            System.out.println(conn.getURL() + sb.toString());
            //    결과 코드가 200이라면 성공
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            //    요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            //    Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            access_Token = element.getAsJsonObject().get("access_token").getAsString();
            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

            System.out.println("access_token : " + access_Token);
            System.out.println("refresh_token : " + refresh_Token);

            br.close();
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return access_Token;
		
	}
	
	@Override
	public HashMap<String, Object> getUserInfo(String accessToken) {
		
		//    요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
        HashMap<String, Object> userInfo = new HashMap<>();
        String reqURL = "https://kapi.kakao.com/v2/user/me";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            //    요청에 필요한 Header에 포함될 내용
            conn.setRequestProperty("Authorization", "Bearer " + accessToken);

            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
            JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

            String nickname = properties.getAsJsonObject().get("nickname").getAsString();
            String profile_image = properties.getAsJsonObject().get("profile_image").getAsString();
            String email = kakao_account.getAsJsonObject().get("email").getAsString();

            userInfo.put("nickname", nickname);
            userInfo.put("email", email);
            userInfo.put("profile_image", profile_image);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return userInfo;
	}
	
}
