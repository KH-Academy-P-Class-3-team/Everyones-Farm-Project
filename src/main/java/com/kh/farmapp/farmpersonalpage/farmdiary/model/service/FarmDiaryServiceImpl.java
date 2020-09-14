package com.kh.farmapp.farmpersonalpage.farmdiary.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.farmapp.farmpersonalpage.farmdiary.model.dao.FarmDiaryDao;

import common.dto.FarmDiary;
import common.dto.Farmer;
import common.util.Paging;

@Service
public class FarmDiaryServiceImpl implements FarmDiaryService{
	
	@Autowired
	private FarmDiaryDao farmdiaryDao;

	@Override
	public Map<String, Object> selectFarmDiaryList(int currentPage, int cntPerPage, String farmerNo) {
		
		Paging p = new Paging(farmdiaryDao.contentCnt(), currentPage, cntPerPage);
<<<<<<< HEAD
		List<FarmDiary> fdlist = farmdiaryDao.selectFarmDiaryList(p);
		res.put("paging",p);
		res.put("fdlist",fdlist);
=======
		
		Map<String, Object> pagingConfig = new HashMap<>();
//		pagingConfig.put("p", p);
//		pagingConfig.put("farmer", farmer);
		pagingConfig.put("start", p.getStart());
		pagingConfig.put("end", p.getEnd());
		pagingConfig.put("farmerNo", farmerNo);
		
		List<FarmDiary> fdlist = farmdiaryDao.selectFarmDiaryList(pagingConfig);
		System.out.println("FarmDiaryService - fdlist: " + fdlist.toString());

		Map<String,Object> res = new HashMap<String, Object>();	
		
		res.put("fdlist",fdlist);
		res.put("paging", p);
		
		
		System.out.println("서비스값" + res.toString());
		System.out.println("fd사이즈:"+fdlist.size());

>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
		return res;
	}

	@Override
	public FarmDiary selectFarmDiaryDetail(int farmDiaryNo) {
		return farmdiaryDao.selectFarmDiaryDetail(farmDiaryNo);
	}

	@Override
<<<<<<< HEAD
	public void writeFarmDiary(Map<String, Object> commandMap) {
		farmdiaryDao.insertFarmDiary(commandMap);
	}
=======
	public int deleteFarmDiary(int farmDiaryNo) {
//		return farmdiaryDao.deleteFarmDiary(farmDiaryNo);
		int res = farmdiaryDao.deleteFarmDiary(farmDiaryNo);
		return res;
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05

	@Override
	public int deleteFarmDiary() {
		return 0;
	}

	@Override
	public int modifyFarmDiary() {
		return 0;
	}

	@Override
	public int updateFarmDiaryHits(int hits) {
		return farmdiaryDao.updateFarmDiaryHits(hits);
	}

	// farmerNo 로 farmNo 조회
	@Override
	public int selectFarmNoByFarmerNo(String farmerNo) {
		return farmdiaryDao.selectFarmNoByFarmerNo(farmerNo);
	}

}
