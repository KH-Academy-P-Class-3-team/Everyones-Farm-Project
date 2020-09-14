package com.kh.farmapp.admin.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.farmapp.admin.model.dao.AdminProductDao;

import common.dto.Product;
import common.util.AdminPaging;

/**
 * AdminProductService 를 상속 받는 클래스
 * AdminProductService 를 구현 하는 클래스
 */
@Service
public class AdminProductServiceImpl implements AdminProductService{

	@Autowired
	private AdminProductDao adminProductDao;
	
	// 판매 상품 목록 조회
	@Override
	public List<Map<String, Object>> selectAllProduct(AdminPaging apaging) {
		return adminProductDao.selectAllProduct(apaging);
	}
	
	// 판매 상품 승인
	@Override
	public int approveProduct(List<String> productNoList) {
		return adminProductDao.approveProduct(productNoList);
	}

	// 판매 상품 보류
	@Override
	public int putProductOnHold(List<String> productNoList) {
		return adminProductDao.putProductOnHold(productNoList);
	}
	
	// 페이징 설정
	@Override
	public AdminPaging getPaging(Map<String, Object> pagingConfig) {
		
		// 현재 페이지
		String curPage = (String) pagingConfig.get("curPage");
		// 검색어
		String search = (String) pagingConfig.get("search");
		
		// curPage 초기화, curPageNo 은 현재 페이지 번호를 뜻함!
		int curPageNo = 0;
		if( curPage != null && !"".equals(curPage) ) {
			curPageNo = Integer.parseInt(curPage);
		}
		
		// 문의 테이블의 총 게시글 수를 조회
		int totalCount = adminProductDao.selectCntAllProduct(search);
		
		// AdminPaging 객체 생성 - 현재 페이지(curPage), 총 게시글 수 (totalCount) 활용
		AdminPaging paging = new AdminPaging(totalCount, curPageNo);
		// 검색어 AdminPaging 객체에 넣어주기
		paging.setSearch(search);
		
		// 설정한 페이징 반환
		return paging;
	}

}
