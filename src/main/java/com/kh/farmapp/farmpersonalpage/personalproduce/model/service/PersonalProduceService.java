package com.kh.farmapp.farmpersonalpage.personalproduce.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

public interface PersonalProduceService {
	
	//게시글 목록
	public Map<String, Object> selectProductList(int currentPage, int cntPerPage, String farmerNo); 
	
<<<<<<< HEAD
	//상품추가
	public int addProduct();
=======
	//상품등록
	public void writeProduct(Map<String, Object> commandMap);
	
	//상품옵션 등록
	public void writeProductOption(Map<String, Object> commandMap);
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
	
	//게시글 상세 조회 메소드
	public Map<String, Object> selectProductDetail(int productNo);

}
