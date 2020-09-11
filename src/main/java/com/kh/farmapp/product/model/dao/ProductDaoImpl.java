package com.kh.farmapp.product.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.dto.Basket;
import common.dto.EveryonesFarmFile;
import common.dto.Product;
import common.util.Paging;

@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public List<Map<String, Object>> selectSeasonTop() {
		return session.selectList("PRODUCT.selectSeasonTop");
	}
	
	@Override
	public List<Map<String, Object>> selectGeneralTop() {
		return session.selectList("PRODUCT.selectGeneralTop");
	}
	
	@Override
	public int selectSeasonCnt() {
		return session.selectOne("PRODUCT.selectSeasonCnt");
	}
	
	@Override
	public List<Product> selectSeasonList(Paging p) {
		return session.selectList("PRODUCT.selectSeasonList", p);
	}
	
	@Override
	public List<EveryonesFarmFile> selectSeasonFileThumbnail() {
		return session.selectList("PRODUCT.selectSeasonFileThumbnail");
	}
	
	@Override
	public int selectGeneralCnt() {
		return session.selectOne("PRODUCT.selectGeneralCnt");
	}
	
	@Override
	public List<Product> selectGeneralList(Paging p) {
		return session.selectList("PRODUCT.selectGeneralList", p);
	}
	
	@Override
	public List<EveryonesFarmFile> selectGeneralFileThumbnail() {
		return session.selectList("PRODUCT.selectGeneralFileThumbnail");
	}
	
	@Override
	public int selectSeasonByTitleCnt(Map<String, Object> map) {
		return session.selectOne("PRODUCT.selectSeasonByTitleCnt", map);
	}
	
	@Override
	public List<Product> selectSeasonSearchByTitle(Map<String, Object> map) {
		return session.selectList("PRODUCT.selectSeasonSearchByTitle", map);
	}
	
	@Override
	public int selectSeasonByKindCnt(Map<String, Object> map) {
		return session.selectOne("PRODUCT.selectSeasonByKindCnt", map);
	}
	
	@Override
	public List<Product> selectSeasonSearchByKind(Map<String, Object> map) {
		return session.selectList("PRODUCT.selectSeasonSearchByKind", map);
	}
	
	@Override
	public Map<String, Object> selectGeneralDetail(int productNo) {
		return session.selectOne("PRODUCT.selectGeneralByProductNo", productNo);
	}
	
	@Override
	public List<EveryonesFarmFile> selectProductFileWithGeneral(int productNo) {
		return session.selectList("PRODUCT.selectProductFileWithGeneral", productNo);
	}
	
	@Override
	public Map<String, Object> selectProductDetail(int productNo) {
		return session.selectOne("PRODUCT.selectProductByProductNo", productNo);
	}
	@Override
	public List<EveryonesFarmFile> selectProductFile(int productNo) {
		return session.selectList("PRODUCT.selectProductFile", productNo);
	}
	
	@Override
	public int insertBasket(Map<String, Object> commandMap) {
		return session.insert("PRODUCT.insertBasket", commandMap);
	}
	
	
}
