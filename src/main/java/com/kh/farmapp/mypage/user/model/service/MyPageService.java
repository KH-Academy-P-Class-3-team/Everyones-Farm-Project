package com.kh.farmapp.mypage.user.model.service;

import java.io.File;
import java.util.List;
import java.util.Map;

<<<<<<< HEAD
=======
import org.springframework.web.multipart.MultipartFile;

<<<<<<< HEAD
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
=======
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
import common.dto.Application;
import common.dto.Basket;
import common.dto.Product;
import common.dto.QuestionOneonone;
import common.dto.TBOrder;
import common.dto.UserAddress;
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
import common.dto.UserProfile;
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
import common.dto.UserTB;

public  interface MyPageService {

	//개인정보 수정 
<<<<<<< HEAD
<<<<<<< HEAD
	public Map<String, Object> modifyUser(UserTB user);
	
=======
=======
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
	public int modifyUser(UserTB user, String root, MultipartFile upload);
	/**
	 * 수정페이지에 개인사진 불러오기
	 * @param user
	 * @return
	 */
	public UserProfile selectUserProfile(UserTB user);
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
	//개인 사진 수정
	public int modifyprofile(UserTB user);
	
	//회원 탈퇴
	public int leave(String userId);
	
	//일대일 문의 전체 리스트 반환 
	//리스트 안에서 페이징 호출
	public List<QuestionOneonone> o3List();
	
	//일대일 문의 상세보기
	public QuestionOneonone o3Detail(int qNo);
<<<<<<< HEAD
<<<<<<< HEAD
	
	//일대일 문의 등록
	public int o3Upload(QuestionOneonone qO3);
	
=======
	
	//일대일 문의 등록
	public int o3Upload(QuestionOneonone qO3);
	
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
=======
	
	//일대일 문의 등록
	public int o3Upload(QuestionOneonone qO3);
	
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
	//일대일 문의 수정
	public int o3Modify(int qNo);

	//일대일 문의 삭제
	public int o3Delete(int qNo);
	
	//개인 등록 체험활동 리스트
	//리스트 안에서 페이징 호출
	public Application appliActList();
	
	//개인 등록 일손돕기 리스트
	//리스트 안에서 페이징 호출
	public Application appliHelpList();
	
	//장바구니 목록 리스트
	//리스트 안에서 페이징 호출
	public Basket basketList();

	//체크된 상품들의 가격을 더해서 나타내주는 메서드
	public int addProduct(Map<String , Object> map);
	
	//구매목록 리스트
	//리스트 안에서 페이징 호출
	public TBOrder orderList();
	
	//구매목록 상세 페이지
<<<<<<< HEAD
<<<<<<< HEAD
	public Product orderDetail(int orderNo);
=======
	public Map<String, Object> orderDetail(int orderNo);
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
=======
	public Map<String, Object> orderDetail(int orderNo);
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
	
	//구매 상세 페이지 안에서 고객의 주소를 불러와준다.
	public UserAddress getAddress(UserTB user);

<<<<<<< HEAD
<<<<<<< HEAD
	/**
	 * 
	 * 파일을 전송하고 바꿔주는 메서드
	 * 
	 * @param user
	 * @param file
	 * @param root
	 */
	public void insertFile(UserTB user, File file, String root);
	
=======
=======
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
	/**
	 * 
	 * 파일을 전송하고 바꿔주는 메서드
	 * 
	 * @param user
	 * @param file
	 * @param root
	 */
	public void insertFile(UserTB user, File file, String root);

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



>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
