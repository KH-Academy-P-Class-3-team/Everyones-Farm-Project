package com.kh.farmapp.farmpersonalpage.personalproduce.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.farmapp.farmpersonalpage.personalproduce.model.dao.PersonalProduceDao;

@Service
public class PersonalProduceServiceImpl implements PersonalProduceService {
	
	@Autowired
	private PersonalProduceDao personalproduceDao;

	@Override
	public List<Map<String, Object>> selectAllProductList(//현재 페이지
															int currentPage,
															//페이지당 노출할 게시굴 수
															int cntPerPag) {
		return null;
	}

	@Override
	public int addProduct() {
		return 0;
	}

	@Override
	public int registrationProduct() {
		return 0;
	}
}
