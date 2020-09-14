package com.kh.farmapp.farmpersonalpage.personalproduce.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import common.dto.Product;
import common.dto.ProductFile;
import common.dto.ProductOption;

@Repository
public class PersonalProduceDaoImpl implements PersonalProduceDao {

	@Override
	public int insertProduct() {
		return 0;
	}

	@Override
	public List<Product> selectProductList() {
		
		// 클래스 다이어그램 용 DTO 객체 선언
		Product product = new Product();
		ProductFile productFile = new ProductFile();
		ProductOption pOption = new ProductOption();
		
		return null;
	}

}
