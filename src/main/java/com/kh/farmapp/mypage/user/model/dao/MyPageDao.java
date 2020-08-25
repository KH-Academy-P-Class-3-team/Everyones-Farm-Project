package com.kh.farmapp.mypage.user.model.dao;

import java.util.List;
import java.util.Map;

import common.dto.Application;
import common.dto.Basket;
import common.dto.Product;
import common.dto.QuestionOneonone;
import common.dto.TBOrder;
import common.dto.UserAddress;
import common.dto.UserTB;

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
		
		//일대일 문의 등록
		public int o3Upload(QuestionOneonone qO3);
		
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
		public Product orderDetail(int orderNo);
		
		//구매 상세 페이지 안에서 고객의 주소를 불러와준다.
		public UserAddress getAddress(UserTB user);

		/**
		 *  유저 정보를 조회한다.
		 * @param user
		 * @return
		 */
		public Map<String, Object> selectUser(UserTB user);
}
