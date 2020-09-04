package com.kh.farmapp.farmpersonalpage.personalproduce.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import common.dto.Product;
import common.dto.ProductOption;

public interface PersonalProduceService {
	
	//게시글 목록
	public List<Map<String, Object>> selectAllProductList(//현재 페이지
															int currentPage,
															//페이지당 노출할 게시굴 수
															int cntPerPag); 
	
	//상품등록
	public void writeProduct(Product product);
	
	//상품옵션 등록
	public void writeProductOption(ProductOption productoption);
	
	//상품등록
	public int registrationProduct();
}
