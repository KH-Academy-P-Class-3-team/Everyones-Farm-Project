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
	
	@Override
	public List<Map<String, Object>> selectAllProduct(AdminPaging apaging) {
		return adminProductDao.selectAllProduct(apaging);
	}

	@Override
	public int approveProduct(Product approve) {
		return adminProductDao.updateProductSas(approve);
	}

	@Override
	public int putProductOnHold(Product cancel) {
		return adminProductDao.updateProductSasIsCancel(cancel);
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
