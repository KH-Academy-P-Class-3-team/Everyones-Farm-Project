package com.kh.farmapp.farmpersonalpage.personalproduce.model.dao;

import java.util.List;
import java.util.Map;

import common.dto.Product;
import common.dto.ProductOption;
import common.util.Paging;

public interface PersonalProduceDao {
		
	//상품등록 메소드
	public int insertProduct(Product product);
	
	//상품옵션등록 메소드
	public int insertProductOption(ProductOption productoption);
	
	
	//게시글 목록
	public List<Product> selectProductList(Paging paging);
}
