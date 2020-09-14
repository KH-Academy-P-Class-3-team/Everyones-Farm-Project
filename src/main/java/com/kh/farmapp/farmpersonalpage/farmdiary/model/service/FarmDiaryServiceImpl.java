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
	public void writeFarmDiary(Map<String, Object> commandMap) {
		farmdiaryDao.insertFarmDiary(commandMap);
	}

	@Override
	public Map<String, Object> selectFarmDiaryList(int currentPage, int cntPerPage, String farmerNo) {
		
		Paging p = new Paging(farmdiaryDao.contentCnt(), currentPage, cntPerPage);
		
		Map<String, Object> pagingConfig = new HashMap<>();
//		pagingConfig.put("p", p);
//		pagingConfig.put("farmer", farmer);
		pagingConfig.put("start", p.getStart());
		pagingConfig.put("end", p.getEnd());
		pagingConfig.put("farmerNo", farmerNo);
		
		List<FarmDiary> fdlist = farmdiaryDao.selectFarmDiaryList(pagingConfig);
//		System.out.println("FarmDiaryService - fdlist: " + fdlist.toString());

		Map<String,Object> res = new HashMap<String, Object>();	
		
		res.put("fdlist",fdlist);
		res.put("paging", p);
		
		
//		System.out.println("서비스값" + res.toString());
//		System.out.println("fd사이즈:"+fdlist.size());

		return res;
	}

	@Override
	public Map<String, Object> selectFarmDiaryDetail(int farmDiaryNo) {
		Map<String, Object> res = farmdiaryDao.selectFarmDiaryDetail(farmDiaryNo);
		return res;
	}

	//파일 업로드
	//	@Override
	//	public int insertFarmdiaryFile(FarmDiary farmdiary, List<MultipartFile> files, String root) throws Exception{
	//		int result = farmdiaryDao.insertFarmDiary(farmdiary);
	//		if(!(files.size() == 1 && files.get(0).getOriginalFilename().equals(""))) {
	//			List<Map<String,String>> filedata 
	//				= new FileUtil().fileUpload(files, root);
	//			
	//			for(Map<String,String> fileInfo : filedata) {
	//				farmdiaryDao.insertFileWithSC(fileInfo);
	//			}
	//		}
	//		return result;
	//	}


	@Override
	public int deleteFarmDiary(int farmDiaryNo) {
//		return farmdiaryDao.deleteFarmDiary(farmDiaryNo);
		int res = farmdiaryDao.deleteFarmDiary(farmDiaryNo);
		return res;

	}

	@Override
	public int modifyFarmDiary(Map<String, Object> commandMap) {
		return farmdiaryDao.modifyFarmDiary(commandMap);
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

	@Override
	public int selectFarmerNoByFarmNo(String farmNo) {
		return farmdiaryDao.selectFarmerNoByFarmNo(farmNo);
	}

}
