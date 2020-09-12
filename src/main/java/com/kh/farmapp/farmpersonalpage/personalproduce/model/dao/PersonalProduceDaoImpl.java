package com.kh.farmapp.farmpersonalpage.personalproduce.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.dto.Product;
import common.dto.ProductFile;
import common.dto.ProductOption;
import common.util.Paging;

@Repository
public class PersonalProduceDaoImpl implements PersonalProduceDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertProduct(Product product) {
		return sqlSession.insert("Product.insertProduct", product);

	}
	
	public int insertProductOption(ProductOption productoption) {
		return sqlSession.insert("Product.insertProductOption", productoption);
	}

	@Override
	public List<Product> selectProductList(Paging paging) {		
		return null;
	}

}
