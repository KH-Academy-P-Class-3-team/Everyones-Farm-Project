package com.kh.farmapp.activity.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.farmapp.activity.model.dao.ActivityDao;

import common.dto.Application;
import common.dto.EveryonesFarmFile;
import common.dto.Farm;
import common.dto.FarmActivity;
import common.dto.FarmActivitySchedule;
import common.dto.Farmer;
import common.util.ActivityFileUtil;
import common.util.Paging;

@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityDao activityDao;

	@Override
	public Map<String, Object> selectActivityList(int currentPage, int cntPerPage, int isHelp) {

		Map<String, Object> map = new HashMap<String, Object>();
		
		Paging p = new Paging(activityDao.selectActivityCnt(isHelp), currentPage, cntPerPage);
		
		map.put("isHelp",isHelp);
		map.put("start", p.getStart());
		map.put("end", p.getEnd());
		
		List<FarmActivity> activityList = activityDao.selectActivityList(map);
		List<EveryonesFarmFile> fileList = activityDao.selectActivityFileThumbnail();
		
		map.put("paging", p);
		map.put("activityList", activityList);
		map.put("fileList", fileList);

		return map;
	}

	@Override
	public Map<String, Object> selectActivityDetail(int activityNo) {
		
		Map<String, Object> map = activityDao.selectActivityDetail(activityNo);
		List<EveryonesFarmFile> file = activityDao.selectActivityFileWithActivity(activityNo);
		List<FarmActivitySchedule> schedule = activityDao.selectScheduleByActivityNo(activityNo);
		
		map.put("schedule", schedule);
		map.put("fileList", file);
		
		return map;
	}

	@Override
	public Map<String, Object> selectActivitySearch(int currentPage, int cntPerPage, int isHelp, String title, String filter) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("isHelp", isHelp);
		map.put("title", title);

		Paging p = null;
		List<FarmActivity> activityList;
		
		if(filter.equals("activityTitle")) {
			p = new Paging(activityDao.selectActivityByTitleCnt(map), currentPage, cntPerPage);
			
			map.put("start", p.getStart());
			map.put("end", p.getEnd());

			activityList = activityDao.selectActivityByTitle(map);
		} else {
			p = new Paging(activityDao.selectActivityByFarmNameCnt(map), currentPage, cntPerPage);
			
			map.put("start", p.getStart());
			map.put("end", p.getEnd());

			activityList = activityDao.selectActivityByFarmName(map);
		} 
		
		List<EveryonesFarmFile> fileList = activityDao.selectActivityFileThumbnail();
		
		map.put("paging", p);
		map.put("activityList", activityList);
		map.put("fileList", fileList);
		
		return map;
	}

	@Override
	public int insertApplication(Application application) {
		return activityDao.insertApplication(application);
	}

	@Override
	public int insertActivity(FarmActivity farmActivity, List<MultipartFile> files, String root, List<FarmActivitySchedule> scheduleList) {
		
		int result = activityDao.insertActivity(farmActivity);
		
		for(FarmActivitySchedule schedule : scheduleList) {
			activityDao.insertActivitySchedule(schedule);
		}
		
		ActivityFileUtil fileUtil = new ActivityFileUtil();
		
		List<EveryonesFarmFile> fileData = fileUtil.fileUpload(files, root);
		
		
		if(files.size() > 0) {
			for(EveryonesFarmFile data : fileData) {
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
		List<EveryonesFarmFile> fileList = activityDao.selectActivityFileThumbnail();
		
		commandMap.put("activityList", activityList);
		commandMap.put("fileList", fileList);
		
		return commandMap;
	}

	@Override
	public List<Farm> selectFarmList() {
		return activityDao.selectFarmList();
	}
	
	@Override
	public FarmActivity selectActivityByActivityNo(int activityNo) {
		return activityDao.selectActivityByActivityNo(activityNo);
	}
	
	@Override
	public int activityDelete(int activityNo) {
		activityDao.deleteActivityFile(activityNo);
				
		return activityDao.deleteActivity(activityNo);
	}
	
}
