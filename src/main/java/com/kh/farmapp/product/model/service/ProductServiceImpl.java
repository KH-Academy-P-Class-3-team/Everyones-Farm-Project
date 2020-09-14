package com.kh.farmapp.product.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.farmapp.product.model.dao.ProductDao;

import common.dto.Basket;
import common.dto.EveryonesFarmFile;
import common.dto.Product;
import common.util.Paging;

@Repository
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Map<String, Object>> selectSeasonTop() {
		return productDao.selectSeasonTop();
	}
	
	@Override
	public List<Map<String, Object>> selectGeneralTop() {
		return productDao.selectGeneralTop();
	}
	
	@Override
	public Map<String, Object> selectSeasonList(int cPage, int cntPerPage, int isSeasonalFood) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Paging p = new Paging(productDao.selectSeasonCnt(), cPage, cntPerPage);
		
		List<Product> plist = productDao.selectSeasonList(p);
		
		map.put("isSeasonalFood", isSeasonalFood);
		map.put("start", p.getStart());
		map.put("end", p.getEnd());
		
		List<EveryonesFarmFile> fileList = productDao.selectSeasonFileThumbnail();
		map.put("plist", plist);
		map.put("paging", p);
		map.put("fileList", fileList);
		
		
		return map;
	}
	
	@Override
	public Map<String, Object> selectGeneralList(int cPage, int cntPerPage, int isSeasonalFood) {

		Map<String, Object> map = new HashMap<String, Object>();
		Paging p = new Paging(productDao.selectGeneralCnt(), cPage, cntPerPage);
		
		List<Product> plist = productDao.selectGeneralList(p);
		
		map.put("isSeasonalFood", isSeasonalFood);
		map.put("start", p.getStart());
		map.put("end", p.getEnd());
		
		List<EveryonesFarmFile> fileList = productDao.selectGeneralFileThumbnail();
		map.put("plist", plist);
		map.put("paging", p);
		map.put("fileList", fileList);
		
		
		return map;
	}
	
	@Override
	public Map<String, Object> selectSeasonSearch(int cPage, int cntPerPage, int isSeasonalFood, String title,
			String filter) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("isSeasonalFood", isSeasonalFood);
		map.put("name", title);
		map.put("kind", title);
		
		Paging p = null;
		List<Product> plist;
		
		if(filter.equals("productname")) {
			p = new Paging(productDao.selectSeasonByTitleCnt(map), cPage, cntPerPage);
			map.put("start", p.getStart());
			map.put("end", p.getEnd());
			
			plist = productDao.selectSeasonSearchByTitle(map);
		} else {
			p = new Paging(productDao.selectSeasonByKindCnt(map), cPage, cntPerPage);
			map.put("start", p.getStart());
			map.put("end", p.getEnd());
			
			plist = productDao.selectSeasonSearchByKind(map);
		}
		
		List<EveryonesFarmFile> fileList = productDao.selectSeasonFileThumbnail();
		map.put("plist", plist);
		map.put("paging", p);
		map.put("fileList", fileList);
		
		
		return map;
	}
	
	@Override
	public Map<String, Object> selectProductDetail(int productNo) {
		Map<String, Object> map = productDao.selectProductDetail(productNo);
		List<EveryonesFarmFile> file = productDao.selectProductFile(productNo);
		System.out.println(file.toString());
		
		// file 이 null값이 아닐 때
		if( file != null ) {
			map.put("fileList", file);
		}
		
		return map;
	}
	
	@Override
	public List<Map<String, Object>> selectProductOption(int productNo) {
		return productDao.selectProductOption(productNo);
	}
	
	@Override
	public int insertBasket(Map<String, Object> commandMap) {
		
		return productDao.insertBasket(commandMap);
	}
	
}
