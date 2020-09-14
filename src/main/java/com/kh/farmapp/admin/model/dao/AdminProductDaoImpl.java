package com.kh.farmapp.admin.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.dto.Farmer;
import common.dto.Product;
import common.util.AdminPaging;

/**
 * AdminProductDao 을 상속 받는 클래스
 * AdminProductDao 를 구현 하는 클래스
 */
@Repository
public class AdminProductDaoImpl implements AdminProductDao{

	@Autowired
	private SqlSessionTemplate session;
	
	// 판매 상품 관리 리스트 조회
	@Override
	public List<Map<String, Object>> selectAllProduct(AdminPaging apaging) {
		return session.selectList("ADMINPRODUCT.selectAllProduct", apaging);
	}

	// 판매 상품 승인
	@Override
	public int approveProduct(List<String> productNoList) {
		return session.update("ADMINPRODUCT.approveProduct", productNoList);
	}
	
	// 판매 상품 보류
	@Override
	public int putProductOnHold(List<String> productNoList) {
		return session.update("ADMINPRODUCT.putProductOnHold", productNoList);
	}
	
	// 판매 상품 총 갯수 조회
	@Override
	public int selectCntAllProduct(String search) {
		return session.selectOne("ADMINPRODUCT.selectCntAllProduct", search);
	}

}
