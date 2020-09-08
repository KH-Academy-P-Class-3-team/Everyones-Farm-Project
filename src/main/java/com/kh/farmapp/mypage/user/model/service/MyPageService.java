package com.kh.farmapp.mypage.user.model.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import common.dto.Application;
import common.dto.Basket;
import common.dto.Product;
import common.dto.QuestionOneonone;
import common.dto.TBOrder;
import common.dto.UserAddress;
import common.dto.UserProfile;
import common.dto.UserTB;

public  interface MyPageService {

	//개인정보 수정 
	public int modifyUser(UserTB user, String root, MultipartFile upload);
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
	public Map<String, Object> basketList(int userNo, int cPage, int cntPerPage);

	//체크된 상품들의 가격을 더해서 나타내주는 메서드
	public int addProduct(Map<String , Object> map);
	
	//구매목록 리스트
	//리스트 안에서 페이징 호출
	public Map<String, Object> orderList(int userNo, int cPage, int cntPerPage);
	
	//구매목록 상세 페이지
	public Map<String, Object> orderDetail(int orderNo);
	
	//구매 상세 페이지 안에서 고객의 주소를 불러와준다.
	public UserAddress getAddress(UserTB user);

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
	 * 최대최소값 구해 계산 하기
	 * @param user
	 * @return
	 */
	public Map<String, Object> getTotal(UserTB user);



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
