package com.kh.farmapp.farmpersonalpage.personalproduce.model.dao;

import java.util.List;
import java.util.Map;

import common.dto.Product;
import common.dto.ProductOption;
import common.util.Paging;

public interface PersonalProduceDao {
		
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
}
