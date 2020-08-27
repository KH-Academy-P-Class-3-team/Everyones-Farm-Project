package com.kh.farmapp.farmpersonalpage.farmdiary.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.farmapp.farmpersonalpage.farmdiary.model.dao.FarmDiaryDao;

import common.dto.FarmDiary;
import common.util.Paging;

@Service
public class FarmDiaryServiceImpl implements FarmDiaryService{
	
	@Autowired
	private FarmDiaryDao farmdiaryDao;

	@Override
	public Map<String, Object> selectFarmDiaryList(int currentPage, int cntPerPage) {
		Map<String,Object> res = new HashMap<String, Object>();
		Paging p = new Paging(farmdiaryDao.contentCnt(), currentPage, cntPerPage);
		List<FarmDiary> fdlist = farmdiaryDao.selectFarmDiaryList(p);
		res.put("paging",p);
		res.put("fdlist",fdlist);
		return res;
	}
	
	@Override
	public Map<String, Object> selectFarmDiaryDetail(int farmDiaryNo) {
		Map<String, Object> res = farmdiaryDao.selectFarmDiaryDetail(farmDiaryNo);
		return farmdiaryDao.selectFarmDiaryDetail(farmDiaryNo);
	}

	@Override
	public void writeFarmDiary(Map<String, Object> commandMap) {
		farmdiaryDao.insertFarmDiary(commandMap);
	}

	@Override
	public int deleteFarmDiary() {
		return 0;
	}

	@Override
	public int modifyFarmDiary() {
		return 0;
	}

}
