package com.kh.farmapp.farmpersonalpage.personalproduce.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.farmapp.farmpersonalpage.personalproduce.model.dao.PersonalProduceDao;

import common.dto.Product;
import common.dto.ProductOption;
import common.util.Paging;

@Service
public class PersonalProduceServiceImpl implements PersonalProduceService {

	@Autowired
	private PersonalProduceDao personalproduceDao;

	@Override
	public Map<String, Object> selectProductList(int currentPage, int cntPerPage) {
		Map<String,Object> res = new HashMap<String, Object>();
		Paging p = new Paging(personalproduceDao.contentCnt(), currentPage, cntPerPage);
		List<Product> fdlist = personalproduceDao.selectProductList(p);

		res.put("paging",p);
		res.put("fdlist",fdlist);


		return res;
	}

	@Override
	public void writeProduct(Map<String, Object> commandMap) {
		personalproduceDao.insertProduct(commandMap);
	}
	
	@Override
	public void writeProductOption(Map<String, Object> commandMap) {
		personalproduceDao.insertProductOption(commandMap);
	}

	@Override
	public Map<String, Object> selectProductDetail(int productNo) {
		Map<String, Object> res = personalproduceDao.selectProductDetail(productNo);
		return personalproduceDao.selectProductDetail(productNo);
	}




}
