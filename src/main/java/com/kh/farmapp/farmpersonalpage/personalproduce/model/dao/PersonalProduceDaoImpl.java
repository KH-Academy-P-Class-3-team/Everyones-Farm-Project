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
	public int insertProduct(Map<String, Object> commandMap) {
		return sqlSession.insert("Product.insertProduct", commandMap);

	}
	
	public int insertProductOption(Map<String, Object> commandMap) {
		return sqlSession.insert("Product.insertProductOption", commandMap);
	}

	@Override
	public List<Product> selectProductList(Map<String, Object> map) {		
		return sqlSession.selectList("Product.selectProductList", map);
	}

	@Override
	public int contentCnt() {
		int cnt = sqlSession.selectOne("Product.selectContentCnt");
		return cnt;
	}

	@Override
	public Map<String, Object> selectProductDetail(int productNo) {
		return sqlSession.selectOne("Product.selectProductDetail", productNo);
	}

}
