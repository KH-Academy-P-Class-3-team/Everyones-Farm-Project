package com.kh.farmapp.farmpersonalpage.personalproduce.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import common.dto.Product;
import common.dto.ProductOption;

public interface PersonalProduceService {
	
	//게시글 목록
	public Map<String, Object> selectProductList(int currentPage, int cntPerPage); 
	
	//상품등록
	public void writeProduct(Map<String, Object> commandMap);
	
	//상품옵션 등록
	public void writeProductOption(Map<String, Object> commandMap);
	
	//게시글 상세 조회 메소드
	public Map<String, Object> selectProductDetail(int productNo);

}
