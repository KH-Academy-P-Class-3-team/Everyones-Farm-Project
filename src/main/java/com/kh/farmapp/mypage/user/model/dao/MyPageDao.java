package com.kh.farmapp.mypage.user.model.dao;

import java.util.List;
import java.util.Map;

import common.dto.Farmer;
import common.dto.QuestionOneonone;
import common.dto.UserProfile;
import common.dto.UserTB;

public interface MyPageDao {

		//개인정보 수정 
		public int modifyUser(UserTB user);
		
		//개인 사진 수정
		public int modifyprofile(Map<String, Object> fileMap);
		/**
		 * 사진이 존재하는지 조회하기 
		 * @param user
		 * @return
		 */
		public UserProfile selectUserProfile(UserTB user);
		/**
		 * 사진이 없을 시 사진 삽입
		 * @param fileMap
		 * @return
		 */
		public int insertprofile(Map<String, Object> fileMap);
		
		//회원 탈퇴
		public int leave(UserTB user);
		
		//일대일 문의 전체 리스트 반환 
		//리스트 안에서 페이징 호출
		public List<Map<String, Object>> o3List(Map<String, Object> forOne);
		
		/*
		 * 페이지 부를떄 총 게시물의 개수를 구하는 메서드QuestionOneonone
		 */
		public int cntO3(UserTB user);
		
		//일대일 문의 상세보기
		public QuestionOneonone o3Detail(Map<String, Object> map);
		
		//일대일 문의 상세보기 농부
		public QuestionOneonone o3DetailFarmer(Map<String, Object> map);
		
		
		//일대일 문의 삭제
		public int o3Delete(int qNo);
		
		//개인 등록 체험활동 리스트
		//리스트 안에서 페이징 호출
		public List<Map<String, Object>> appliActList(UserTB user);
		
		
		//장바구니 목록 리스트
		//리스트 안에서 페이징 호출
		public List<Map<String, Object>> basketList(Map<String, Object> sub);

		
		//구매목록 리스트
		//리스트 안에서 페이징 호출
		public List<Map<String, Object>> orderList(Map<String, Object> sub);
		
		//구매목록 상세 페이지
		public Map<String, Object> orderDetail(Map<String, Object> map);
		
		//framer 구매목록 상세 페이지
		public Map<String, Object> orderFarmerDetail(Map<String, Object> map);
		

		/**
		 *  유저 정보를 조회한다.
		 * @param user
		 * @return
		 */
		public UserTB selectUser(UserTB user);

		/**
		 * 파머 정보 조회
		 * @param farmerNo
		 * @return
		 */
		public Farmer selectFarmer(int farmerNo);
		
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
		 * farmer O3 min max
		 * @param farmer
		 * @return
		 */
		public Map<String, Object> getO3FarmerTotal(Farmer farmer);
		
		/**
		 * 최대최소값 구해 계산 하기
		 * @param user
		 * @return
		 */
		public Map<String, Object> getOrderTotal(int orderNo);

		/**
		 * 최대최소값 구해 계산 하기
		 * @param user
		 * @return
		 */
		public Map<String, Object> getOrderTotal(Farmer farmer);
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
		 * 구매목록 조회
		 * @param farmer
		 * @return
		 */
		public List<Map<String, Object>> purchaseList(Farmer farmer);
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
		
		/**
		 * 1대1문의 답변 정보
		 * @param qUESTION_NO
		 * @return
		 */
		public Map<String, Object> getAnswer(int questionNo);

		/**
		 * 농부 사진 조회
		 * @param farmer
		 * @return
		 */
		public UserProfile selectFarmerProfile(Farmer farmer);

		/**
		 * farmer modift info
		 * @param farmer
		 * @return
		 */
		public int modifyFarmer(Farmer farmer);

		public void insertFarmerprofile(UserProfile userProf);

		public void modifFarmeryprofile(UserProfile userProf);

		/**
		 * 이메일 체크
		 * @param email
		 * @return
		 */
		public Farmer selectFarmerEmailCheck(String email);

		/**
		 * 전화번호 체크
		 * @param phone
		 * @return
		 */
		public Farmer selectFarmerPhoneCheck(String phone);

		/**
		 * 페이징 처리 위한 파머 일대일 문의 총 개수 구하기 
		 * @param farmer
		 * @return
		 */
		public int cntO3Farmer(Farmer farmer);

		/**
		 * 일대일 문의 조회
		 * @param forOne
		 * @return
		 */
		public List<Map<String, Object>> o3ListFarmer(Map<String, Object> forOne);

		/**
		 * 농부 글 작성
		 * @param o3
		 * @return
		 */
		public int writeO3Farmer(QuestionOneonone o3);

		/**
		 * 파머 activeList
		 * @param farmer
		 * @return
		 */
		public List<Map<String, Object>> appliActList(Farmer farmer);

		/**
		 * farmer activeList cnt
		 * @param farmer
		 * @return
		 */
		public int cntApli(Farmer farmer);

		/**
		 * farmer leave
		 * @param ckFarmer
		 * @return
		 */
		public int farmerLeave(Farmer ckFarmer);

		/**
		 * 장바구니 개수 세는 함수
		 * @param farmer
		 * @return
		 */
		public int cntFarmerBasket(Farmer farmer);

		/**
		 * farmer paging basketList
		 * @param sub
		 * @return
		 */
		public List<Map<String, Object>> basketFarmerList(Map<String, Object> sub);

		/**
		 * For List get total sum of order by farmer
		 * @param farmerNo
		 * @return
		 */
		public int cntFarmerOrder(int farmerNo);

		/**
		 * get List with paging
		 * @param sub
		 * @return
		 */
		public List<Map<String, Object>> orderFarmerList(Map<String, Object> sub);

		/**
		 * tb_order insert
		 * @param basket
		 * @return
		 */
		public int insertTbOrder(Map<String, Object> basket);

		/**
		 * tb_order에 넣을 price 구하기
		 * @param basket
		 * @return
		 */
		public int selectPrice(Map<String, Object> basket);

		/**
		 * farmer tb_order insert
		 * @param basket
		 * @return
		 */
		public int insertFarmerTbOrder(Map<String, Object> basket);


		
		

		

		

		

		




}
