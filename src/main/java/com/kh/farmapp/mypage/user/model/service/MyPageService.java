package com.kh.farmapp.mypage.user.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import common.dto.AnsweredOneonone;
import common.dto.QuestionOneonone;
import common.dto.UserProfile;
import common.dto.UserTB;

public  interface MyPageService {

	//개인정보 수정 
	public int modifyUser(UserTB user);
	/**
	 * 수정페이지에 개인사진 불러오기
	 * @param user
	 * @return
	 */
	public UserProfile selectUserProfile(UserTB user);
	//개인 사진 수정
	public int modifyprofile(UserTB user, MultipartFile file, String root);
	
	//회원 탈퇴
	public int leave(UserTB user);
	
	//일대일 문의 전체 리스트 반환 
	//리스트 안에서 페이징 호출
	public Map<String, Object> o3List(int cPage, int cntPerPage, UserTB user);
	
	//일대일 문의 상세보기
	public QuestionOneonone o3Detail(int qNo, int userNo);
	

	//일대일 문의 삭제
	public int o3Delete(int qNo);
	
	//개인 등록 체험활동 리스트
	//리스트 안에서 페이징 호출
	public List<Map<String, Object>> appliActList(UserTB user);
	
	
	//장바구니 목록 리스트
	//리스트 안에서 페이징 호출
	public Map<String, Object> basketList(int userNo, int cPage, int cntPerPage);

	
	//구매목록 리스트
	//리스트 안에서 페이징 호출
	public Map<String, Object> orderList(int userNo, int cPage, int cntPerPage);
	
	//구매목록 상세 페이지
	public Map<String, Object> orderDetail(int orderNo, int userNo);
	


	/*
	 * 개인정보 불러오기
	 * 
	 */
	public UserTB selectUser(UserTB user);

	/**
	 *  게시물의 총 개수를 구해온다.
	 * @param user 
	 * @return
	 */
	public int getCount(UserTB user);

	/*
	 * 나의 지원 개수 파악
	 */
	public int cntApli(UserTB user);

	/*
	 * Basket 지우기
	 */
	public int deleteBasket(int[] arr);
	
	/**
	 * 일대일 문의 최대최소값 구해 계산 하기
	 * @param user
	 * @return
	 */
	public Map<String, Object> getTotal(UserTB user);
	
	/**
	 *  주문 내역 최대 최소값 구하기
	 * @param orderNo
	 * @return
	 */
	public Map<String, Object> getOrderTotal(int orderNo);
	
	/**
	 * o3 페이지 작성하기
	 * @param o3
	 * @return
	 */
	public int wirteO3(QuestionOneonone o3);
	
	/**
	 * 수정시 DB에서 EMAIL중복 확인
	 * @param email
	 * @param user 
	 * @return
	 */
	public int selectEmailCheck(String email, UserTB user);
	
	/**
	 * 수정 시 DB에서 PHONE 중복 확인
	 * @param phone
	 * @param user 
	 * @return
	 */
	public int selectPhoneCheck(String phone, UserTB user);
	
	/**
	 * select basketLiser forPurchase
	 * @param arr
	 * @return
	 */
	public int insertPurchase(int[] arr);
	
	/**
	 * 구매대기 목록 
	 * @param userNo
	 * @return
	 */
	public Map<String, Object> basketListPur(int userNo);
	/**
	 * option의 AMOUNT 수량을 다시 더하고 장바구니 에서 purchase컬럼 다시 0으로 바꾸는 메서드
	 * @param arr
	 */
	public int canclePurchase(int[] arr);
	
	/**
	 * 일대일 문의 답변 정보를 얻어오는 메서드
	 * @param qUESTION_NO
	 * @return
	 */
	public AnsweredOneonone answerDetail(int questionNo);
	
	/**
	 * 유저 사진만 변경하는 메서드
	 * @param user
	 * @param root
	 * @param upload
	 */
	public void modifyUserProfile(UserTB user, String root, MultipartFile upload);



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
