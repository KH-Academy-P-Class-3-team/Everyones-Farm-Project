package com.kh.farmapp.mypage.user.model.dao;

import java.util.List;
import java.util.Map;

import common.dto.Application;
import common.dto.Basket;
<<<<<<< HEAD
=======
import common.dto.EveryonesFarmFile;
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
import common.dto.Product;
import common.dto.QuestionOneonone;
import common.dto.TBOrder;
import common.dto.UserAddress;
<<<<<<< HEAD
=======
import common.dto.UserProfile;
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
import common.dto.UserTB;
import common.util.Paging;

public interface MyPageDao {

		//개인정보 수정 
		public int modifyUser(UserTB user);
		
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
		
		//일대일 문의 등록
		public int o3Upload(QuestionOneonone qO3);
		
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
		public Product orderDetail(int orderNo);
=======
		public Map<String, Object> orderDetail(int orderNo);
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
		
		//구매 상세 페이지 안에서 고객의 주소를 불러와준다.
		public UserAddress getAddress(UserTB user);

		/**
		 *  유저 정보를 조회한다.
		 * @param user
		 * @return
		 */
<<<<<<< HEAD
		public Map<String, Object> selectUser(UserTB user);
=======
		public UserTB selectUser(UserTB user);

		/*
		 * 내 농촌활동 지원 개수
		 */
		public int cntApli(UserTB user);

		/*
		 * 내 주문내역 총 개수 조회
		 */
		public int cntOrder(int userNo);

		/*
		 * 내 장바구니 내역 확인
		 */
		public int cntBasket(int userNo);

		/*
		 * 장바구니 지우기
		 */
		public int deleteBasket(int[] arr);
		/**
		 * 최대최소값 구해 계산 하기
		 * @param user
		 * @return
		 */
		public Map<String, Object> getTotla(UserTB user);

		/**
		 * 최대최소값 구해 계산 하기
		 * @param user
		 * @return
		 */
		public Map<String, Object> getOrderTotal(int orderNo);

		/**
		 * o3작성하기
		 * @param o3
		 * @return
		 */
		public int writeO3(QuestionOneonone o3);
	
		/**
		 * 수정시 DB에서 EMAIL중복 확인
		 * @param email
		 * @return
		 */
		public UserTB selectEmailCheck(String email);
		
		/**
		 * 수정 시 DB에서 PHONE 중복 확인
		 * @param phone
		 * @return
		 */
		public UserTB selectPhoneCheck(String phone);

		/**
		 * purchase 삽입을 위한 
		 * basket조회
		 * @param arr
		 * @return
		 */
		public List<Map<String, Object>> selectBasket(int[] arr);

		/**
		 * option테이블 에서 amount를 줄이는 메서드
		 * @param optionNo
		 * @return
		 */
		public int subAmount(int optionNo);

		/**
		 * 장바구니 구매 컬럼 수정
		 * @param basketNo
		 * @return
		 */
		public int insertPurchase(int basketNo);

		/**
		 * 구매목록 조회
		 * @param userNo
		 * @return
		 */
		public List<Map<String, Object>> purchaseList(int userNo);

		/**
		 * amount 다시 돌려놓는 메서드
		 * @param i 
		 */
		public void addAmount(int optionNo);
		/**
		 * purchase를 0으로 다시 만드는 메서드
		 * @param arr
		 * @return 
		 */
		public int subPurchase(int basketNo);




>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
}
