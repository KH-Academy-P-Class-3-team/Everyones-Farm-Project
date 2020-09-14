package com.kh.farmapp.farmpersonalpage.personalproduce.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import common.dto.Product;
import common.dto.ProductFile;
import common.dto.ProductOption;

@Repository
public class PersonalProduceDaoImpl implements PersonalProduceDao {
<<<<<<< HEAD

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
=======
	
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
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
	}

}
