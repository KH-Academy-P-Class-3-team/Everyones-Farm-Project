package com.kh.farmapp.mypage.user.model.dao;

import java.util.List;
import java.util.Map;

import common.dto.Application;
import common.dto.Basket;
import common.dto.EveryonesFarmFile;
import common.dto.Product;
import common.dto.QuestionOneonone;
import common.dto.TBOrder;
import common.dto.UserAddress;
import common.dto.UserProfile;
import common.dto.UserTB;
import common.util.Paging;

public interface MyPageDao {

		//개인정보 수정 
		public int modifyUser(UserTB user);
		
		//개인 사진 수정
		public int modifyprofile(Map<String, Object> fileMap);
		/**
		 * 사진이 존재하는지 조회하기 
		 * @param userNo
		 * @return
		 */
		public UserProfile selectUserProfile(int userNo);
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
		public QuestionOneonone o3Detail(int qNo);
		
		//일대일 문의 등록
		public int o3Upload(QuestionOneonone qO3);
		
		//일대일 문의 수정
		public int o3Modify(int qNo);

		//일대일 문의 삭제
		public int o3Delete(int qNo);
		
		//개인 등록 체험활동 리스트
		//리스트 안에서 페이징 호출
		public List<Map<String, Object>> appliActList(UserTB user);
		
		//개인 등록 일손돕기 리스트
		//리스트 안에서 페이징 호출
		public Application appliHelpList();
		
		//장바구니 목록 리스트
		//리스트 안에서 페이징 호출
		public List<Map<String, Object>> basketList(Map<String, Object> sub);

		//체크된 상품들의 가격을 더해서 나타내주는 메서드
		public int addProduct(Map<String , Object> map);
		
		//구매목록 리스트
		//리스트 안에서 페이징 호출
		public List<Map<String, Object>> orderList(Map<String, Object> sub);
		
		//구매목록 상세 페이지
		public Map<String, Object> orderDetail(int orderNo);
		
		//구매 상세 페이지 안에서 고객의 주소를 불러와준다.
		public UserAddress getAddress(UserTB user);

		/**
		 *  유저 정보를 조회한다.
		 * @param user
		 * @return
		 */
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




}
