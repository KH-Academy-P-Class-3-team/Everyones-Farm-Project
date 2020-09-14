package com.kh.farmapp.farmpersonalpage.personalproduce.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.farmapp.farmpersonalpage.personalproduce.model.dao.PersonalProduceDao;

<<<<<<< HEAD
=======
import common.dto.FarmDiary;
import common.dto.Product;
import common.dto.ProductOption;
import common.util.Paging;

>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
@Service
public class PersonalProduceServiceImpl implements PersonalProduceService {
	
	@Autowired
	private PersonalProduceDao personalproduceDao;

	@Override
	public Map<String, Object> selectProductList(int currentPage, int cntPerPage, String farmerNo) {
		Paging p = new Paging(personalproduceDao.contentCnt(), currentPage, cntPerPage);
		
		Map<String, Object> pagingConfig = new HashMap<>();
//		pagingConfig.put("p", p);
//		pagingConfig.put("farmer", farmer);
		pagingConfig.put("start", p.getStart());
		pagingConfig.put("end", p.getEnd());
		pagingConfig.put("farmerNo", farmerNo);
		
		List<Product> fdlist = personalproduceDao.selectProductList(pagingConfig);
		System.out.println("FarmDiaryService - fdlist: " + fdlist.toString());

		Map<String,Object> res = new HashMap<String, Object>();	
		
		res.put("fdlist",fdlist);
		res.put("paging", p);
		
		System.out.println("서비스값" + res.toString());
		System.out.println("fd사이즈:"+fdlist.size());

		return res;
	}


	@Override
<<<<<<< HEAD
	public int addProduct() {
		return 0;
=======
	public void writeProduct(Map<String, Object> commandMap) {
		personalproduceDao.insertProduct(commandMap);
	}
	
	@Override
	public void writeProductOption(Map<String, Object> commandMap) {
		personalproduceDao.insertProductOption(commandMap);
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
	}

	@Override
	public Map<String, Object> selectProductDetail(int productNo) {
		Map<String, Object> res = personalproduceDao.selectProductDetail(productNo);
		return personalproduceDao.selectProductDetail(productNo);
	}
<<<<<<< HEAD
=======




>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
}
