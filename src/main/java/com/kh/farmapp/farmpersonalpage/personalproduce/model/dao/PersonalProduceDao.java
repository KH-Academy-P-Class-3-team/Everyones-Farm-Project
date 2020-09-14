package com.kh.farmapp.farmpersonalpage.personalproduce.model.dao;

import java.util.List;

import common.dto.Product;

public interface PersonalProduceDao {
<<<<<<< HEAD
	
	//게시글 삽입
	public int insertProduct();
	
	//게시글 목록
	public List<Product> selectProductList();
=======
		
	//상품등록 메소드
	public int insertProduct(Map<String, Object> commandMap);
	
	//상품옵션등록 메소드
	public int insertProductOption(Map<String, Object> commandMap);
	
	//게시글 목록
	public List<Product> selectProductList(Map<String, Object> map);
	
	//게시글 숫자
	public int contentCnt();
	
	//게시글 상세 조회 메소드
	public Map<String, Object> selectProductDetail(int productNo);
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
}
