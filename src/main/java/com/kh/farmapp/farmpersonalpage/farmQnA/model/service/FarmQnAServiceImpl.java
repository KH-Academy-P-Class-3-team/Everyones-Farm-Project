package com.kh.farmapp.farmpersonalpage.farmQnA.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.farmapp.farmpersonalpage.farmQnA.model.dao.FarmQnADao;

import common.dto.FarmDiary;
import common.util.Paging;

@Service
public class FarmQnAServiceImpl implements FarmQnAService {

	@Autowired
	private FarmQnADao farmqnaDao;
	
	@Override
	public void writeFarmQnA(Map<String, Object> commandMap) {
		farmqnaDao.insertFarmQnA(commandMap);
	}

	@Override
	public Map<String, Object> selectFarmQnAList(int currentPage, int cntPerPage) {
		Map<String,Object> res = new HashMap<String, Object>();
		Paging p = new Paging(farmqnaDao.contentCnt(), currentPage, cntPerPage);
		List<FarmDiary> fdlist = farmqnaDao.selectFarmQnAList(p);

		res.put("paging",p);
		res.put("fdlist",fdlist);

		//		System.out.println(fdlist.size());

		return res;
	}

	@Override
	public Map<String, Object> selectQnADetail(int farmQnaQuestionNo) {
		Map<String, Object> res = farmqnaDao.selectFarmQnADetail(farmQnaQuestionNo);
		return res;
	}

	@Override
	public int deleteQnA(int farmQnaQuestionNo) {
		return farmqnaDao.deleteQnA(farmQnaQuestionNo);

	}

}
