package com.kh.farmapp.activity.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.farmapp.activity.model.dao.ActivityDao;

import common.dto.Application;
import common.dto.Farm;
import common.dto.FarmActivity;
import common.dto.FarmActivityFile;
import common.dto.FarmActivitySchedule;
import common.dto.Farmer;
import common.util.ActivityFileUtil;
import common.util.Paging;

@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityDao activityDao;

	@Override
	public Map<String, Object> selectActivityList(int currentPage, int cntPerPage, String isHelp) {

		Map<String, Object> map = new HashMap<String, Object>();
		
		Paging p = new Paging(activityDao.selectActivityCnt(), currentPage, cntPerPage);
		
		map.put("isHelp",isHelp);
		map.put("start", p.getStart());
		map.put("end", p.getEnd());
		
		List<FarmActivity> activityList = activityDao.selectActivityList(map);
		List<FarmActivityFile> fileList = activityDao.selectActivityFileThumbnail();
		
		map.put("paging", p);
		map.put("activityList", activityList);
		map.put("fileList", fileList);

		return map;
	}

	@Override
	public Map<String, Object> selectActivityDetail(int activityNo) {
		return null;
	}

	@Override
	public Map<String, Object> selectActivitySearch(String isHelp, String title, String filter) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("isHelp", isHelp);
		map.put("title", title);
		map.put("filter", filter);
		
		List<FarmActivity> activityList = activityDao.selectActivitySearch(map);
		
		return null;
	}

	@Override
	public int insertApplication(Application application) {
		return 0;
	}

	@Override
	public int insertActivity(FarmActivity farmActivity, List<MultipartFile> files, String root, List<FarmActivitySchedule> scheduleList) {
		
		int result = activityDao.insertActivity(farmActivity);
		
		for(FarmActivitySchedule schedule : scheduleList) {
			activityDao.insertActivitySchedule(schedule);
		}
		
		ActivityFileUtil fileUtil = new ActivityFileUtil();
		
		List<FarmActivityFile> fileData = fileUtil.fileUpload(files, root);
		
		
		if(files.size() > 1) {
			
			
			for(FarmActivityFile data : fileData) {
				activityDao.insertFile(data);
			}
		}
		
		
		return result;
	}

	@Override
	public Farm selectFarmByFarmerNo(Farmer farmer) {
		Farm farm = activityDao.selectFarmByFarmerNo(farmer); 
		return farm;
	}

	@Override
	public Map<String, Object> selectActivityListByFarmNo(Farm farm) {
		
		Map<String, Object> commandMap = new HashMap<String, Object>();
		
		List<FarmActivity> activityList = activityDao.selectActivityListByFarmNo(farm); 
		List<FarmActivityFile> fileList = activityDao.selectActivityFileThumbnail();
		
		commandMap.put("activityList", activityList);
		commandMap.put("fileList", fileList);
		
		return commandMap;
	}

	@Override
	public List<Farm> selectFarmList() {
		return activityDao.selectFarmList();
	}
	
}
