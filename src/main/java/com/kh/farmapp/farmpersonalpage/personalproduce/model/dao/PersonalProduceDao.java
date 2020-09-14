package com.kh.farmapp.farmpersonalpage.personalproduce.model.dao;

import java.util.List;

import common.dto.Product;

public interface PersonalProduceDao {
	
	//게시글 삽입
	public int insertProduct();
	
	//게시글 목록
	public List<Product> selectProductList();
}
