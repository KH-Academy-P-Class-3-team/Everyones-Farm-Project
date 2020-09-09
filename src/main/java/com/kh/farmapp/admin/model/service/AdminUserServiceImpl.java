package com.kh.farmapp.admin.model.service;

import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.kh.farmapp.admin.model.dao.AdminUserDao;

import common.dto.Farmer;
import common.dto.UserTB;
import common.util.AdminPaging;
/**
 * AdminUserSerivce 를 상속 받는 클래스
 * AdminUserService 구현 클래스
 */
@Service
public class AdminUserServiceImpl implements AdminUserService{

	@Autowired
	private AdminUserDao adminUserDao;
	
	@Autowired
	JavaMailSender mailSender;
	
	// pagingConfig 상수
	private static final int USER_CODE = 0;
	private static final int FARMER_CODE = 1;
	private static final int FARM_APPLICATION_CODE = 2;
	
	@Override
	public List<Map<String, Object>> selectAllFarmerApplicationList() {
		return adminUserDao.selectAllFarmerApplicationList();
	}

	@Override
	public List<Map<String, Object>> selectFarmerApplicationByFarmerNo(Farmer farmerNo) {
		return adminUserDao.selectFarmerApplicationByFarmerNo(farmerNo);
	}

	@Override
	public int putFarmerApplicationOnHold(Farmer farmer) {
		return adminUserDao.updateIsConfirmToNo(farmer);
	}

	// 회원 페이징 처리
	@Override
	public AdminPaging getPaging(Map<String, Object> pagingConfig) {
		
		String curPage = (String) pagingConfig.get("curPage");
		String search = (String) pagingConfig.get("search");
		int listCode = (int) pagingConfig.get("listCode");
		
		// curPageNo 초기화, curPageNo 은 현재 페이지 번호를 뜻함!
		int curPageNo = 0;
		if( curPage != null && !"".equals(curPage) ) {
			curPageNo = Integer.parseInt(curPage);
		}
		
		// NOTICE 테이블의 총 게시글 수를 조회한다.
		int totalCount = 0;
		// 검색어가 없을 경우, null일 경우
		if( search == null || "".equals(search) ) {
			
			switch (listCode) {
			case USER_CODE:
				totalCount = adminUserDao.selectCntAllUserList();
				break;
			case FARMER_CODE:
				totalCount = adminUserDao.selectCntAllFarmerList();
				break;
			case FARM_APPLICATION_CODE:
				totalCount = adminUserDao.selectCntAllFarmApplicationList();
				break;
			}
			
		} else { // 검색어가 있을 경우
			
			switch (listCode) {
			case USER_CODE:
				totalCount = adminUserDao.selectCntUserBySearch(search);
				break;
			case FARMER_CODE:
				totalCount = adminUserDao.selectCntFarmerBySearch(search);
				break;
			case FARM_APPLICATION_CODE:
				totalCount = adminUserDao.selectCntFarmApplicationBySearch(search);
				break;
			}
			
		}
		
		// AdminPaging 객체 생성 - 현재 페이지(curPage), 총 게시글 수(totalCount) 활용
		AdminPaging paging = new AdminPaging(totalCount, curPageNo);
		// 검색어 AdminPaging 객체에 넣어주기
		paging.setSearch(search);
		
		return paging;
	}
	
	// 페이징에 의한 회원 조회
	@Override
	public List<Map<String, Object>> selectAllUserByPaging(AdminPaging apaging) {
		return adminUserDao.selectAllUserByPaging(apaging);
	}
	
	// 선택된 회원들 탈퇴시키기
	@Override
	public int deleteUserByUserNo(List<String> userNoList) {
		return adminUserDao.deleteUserByUserNo(userNoList);
	}
	
	// 선택된 회원 탈퇴 취소
	@Override
	public int delCancelUserByUserNo(List<String> userNoList) {
		return adminUserDao.delCancelUserByUserNo(userNoList);
	}
	
	// 페이징 처리된 farmer 회원 목록
	@Override
	public List<Map<String, Object>> selectFarmerByPaging(AdminPaging apaging) {
		return adminUserDao.selectFarmerByPaging(apaging);
	}
	
	// 농업인 회원 탈퇴 처리
	@Override
	public int deleteFarmerByFaremrNo(List<String> farmerNoList) {
		return adminUserDao.deleteFarmerByFarmerNo(farmerNoList);
	}
	
	// 농업인 회원 탈퇴 취소 처리
	@Override
	public int delCancelFarmerByFarmerNo(List<String> farmerNoList) {
		return adminUserDao.delCancelFarmerByFarmerNo(farmerNoList);
	}

	// 농장 입점 신청 목록 조회
	@Override
	public List<Map<String, Object>> selectFarmApplicationByPaging(AdminPaging apaging) {
		return adminUserDao.selectFarmApplicationByPaging(apaging);
	}
	
	// 농장 입점 신청 승인 요청
	@Override
	public int approveFarmerApplication(List<String> farmerNoList) {
		return adminUserDao.approveFarmerApplication(farmerNoList);
	}
	
	// 농장 입점 신청 목록에서 선택된 회원들의 메일 조회
	@Override
	public List<Farmer> selectFarmerMailByFarmerNo(List<String> farmerNoList) {
		return adminUserDao.selectFarmerMailByFarmerNo(farmerNoList);
	}
	
	// 농장 입점 신청 메일 발송
	@Override
	public void approveMailSend(Farmer mailRecipient, String urlPath) {
		
		// 메일 보내는 사람
		String setFrom="everyonesfarm@naver.com";
		// 메일 받는 사람
		String tomail = mailRecipient.getEmail();
		// 메일 제목
		String title = mailRecipient.getFarmerId() + "님, [모두의 농장] 회원이 되신걸 축하드립니다!";
		// 메일 내용
		String htmlBody = 
			"<h2>" +mailRecipient.getFarmerId() + "님!!! [모두의 농장] 회원 승인이 완료됐습니다!</h2>"
			+ "<h3>모두의 농장에 접속하여 농장, 농작물 홍보 및 판매 상품을 등록해보세요!</h3>"
			+ "<a href='http://"+ urlPath + "'>모두의 농장 바로가기</a>";
		
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
			e.printStackTrace();
		}
	}
	
	// 농장 입점 신청 보류
	@Override
	public int holdFarmerApplication(List<String> farmerNoList) {
		return adminUserDao.holdFarmerApplication(farmerNoList);
	}
	
	// 농장 입점 신청 보류 메일 발송
	@Override
	public void holdMailSend(Farmer mailRecipient, String urlPath) {
		
		// 메일 보내는 사람
		String setFrom="everyonesfarm@naver.com";
		// 메일 받는 사람
		String tomail = mailRecipient.getEmail();
		// 메일 제목
		String title = mailRecipient.getFarmerId() + "님, 안타깝게도 [모두의 농장] 입점 신청 심사에서 보류대상이 됐습니다.";
		// 메일 내용
		String htmlBody = 
			"<h2>" +mailRecipient.getFarmerId() + "님, [모두의 농장] 회원 신청이 보류됐습니다.</h2>"
			+ "<h3>모두의 농장에서 좀 더 많은 농업인 분들을 입점시키고 싶지만 아직은 많이 크지 않아 "+ mailRecipient.getFarmerId() +"님은 입점 신청 심사에 보류됐습니다. </h3>"
			+ "<h3>모두의 농장에서 귀하의 입점을 승인할 수 있는 큰 회사가 되도록 노력하겠습니다.";
		
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
			e.printStackTrace();
		}
		
	}
	
	
}
