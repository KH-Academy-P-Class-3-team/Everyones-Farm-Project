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
		return session.selectList("sellPRODUCT.selectSeasonTop");
	}
	
	@Override
	public List<Map<String, Object>> selectGeneralTop() {
		return session.selectList("sellPRODUCT.selectGeneralTop");
	}
	
	@Override
	public int selectSeasonCnt() {
		return session.selectOne("sellPRODUCT.selectSeasonCnt");
	}
	
	@Override
	public List<Product> selectSeasonList(Paging p) {
		return session.selectList("sellPRODUCT.selectSeasonList", p);
	}
	
	@Override
	public List<EveryonesFarmFile> selectSeasonFileThumbnail() {
		return session.selectList("sellPRODUCT.selectSeasonFileThumbnail");
	}
	
	@Override
	public int selectGeneralCnt() {
		return session.selectOne("sellPRODUCT.selectGeneralCnt");
	}
	
	@Override
	public List<Product> selectGeneralList(Paging p) {
		return session.selectList("sellPRODUCT.selectGeneralList", p);
	}
	
	@Override
	public List<EveryonesFarmFile> selectGeneralFileThumbnail() {
		return session.selectList("sellPRODUCT.selectGeneralFileThumbnail");
	}
	
	@Override
	public int selectSeasonByTitleCnt(Map<String, Object> map) {
		return session.selectOne("sellPRODUCT.selectSeasonByTitleCnt", map);
	}
	
	@Override
	public List<Product> selectSeasonSearchByTitle(Map<String, Object> map) {
		return session.selectList("sellPRODUCT.selectSeasonSearchByTitle", map);
	}
	
	@Override
	public int selectSeasonByKindCnt(Map<String, Object> map) {
		return session.selectOne("sellPRODUCT.selectSeasonByKindCnt", map);
	}
	
	@Override
	public List<Product> selectSeasonSearchByKind(Map<String, Object> map) {
		return session.selectList("sellPRODUCT.selectSeasonSearchByKind", map);
	}
	
	@Override
	public Map<String, Object> selectGeneralDetail(int productNo) {
		return session.selectOne("sellPRODUCT.selectGeneralByProductNo", productNo);
	}
	
	@Override
	public List<EveryonesFarmFile> selectProductFileWithGeneral(int productNo) {
		return session.selectList("sellPRODUCT.selectProductFileWithGeneral", productNo);
	}
	
	@Override
	public Map<String, Object> selectProductDetail(int productNo) {
		return session.selectOne("sellPRODUCT.selectProductByProductNo", productNo);
	}
	@Override
	public List<EveryonesFarmFile> selectProductFile(int productNo) {
		return session.selectList("sellPRODUCT.selectProductFile", productNo);
	}
	
	@Override
	public int insertBasket(Map<String, Object> commandMap) {
		return session.insert("sellPRODUCT.insertBasket", commandMap);
	}
	
	
}
