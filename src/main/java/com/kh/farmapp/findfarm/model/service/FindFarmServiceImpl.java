package com.kh.farmapp.findfarm.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.farmapp.findfarm.model.dao.FindFarmDao;

import common.dto.test.FarmSearchCriteria;
import common.util.Paging;

@Service
public class FindFarmServiceImpl implements FindFarmService {

	@Autowired
	private FindFarmDao findFarmDao;

	@Override
	public Map<String, Object> selectFarmList(int currentPage, int cntPerPage, FarmSearchCriteria fsc) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String address = null;
		
		if(fsc.getCity1() != null || fsc.getCity2() != null) {
			address = fsc.getCity1() + " " + fsc.getCity2();
		}
		
		map.put("address", address);
		map.put("filter", fsc.getFilter());
		map.put("item", fsc.getItem());
		
		Paging p = new Paging(findFarmDao.selectFarmCnt(map), currentPage, cntPerPage);

		map.put("start", p.getStart());
		map.put("end", p.getEnd());

		map.put("paging", p);
		map.put("farmList", findFarmDao.selectFarmList(map));
		map.put("fileList", findFarmDao.selectFarmFileList());
		
		System.out.println("farmList : " + findFarmDao.selectFarmList(map));
		
		return map;
	}
	
	
}
