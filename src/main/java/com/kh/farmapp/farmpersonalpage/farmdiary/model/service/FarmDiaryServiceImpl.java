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
	public void writeFarmDiary(Map<String, Object> commandMap) {
		farmdiaryDao.insertFarmDiary(commandMap);
	}

	@Override
	public Map<String, Object> selectFarmDiaryList(int currentPage, int cntPerPage) {
		Map<String,Object> res = new HashMap<String, Object>();
		Paging p = new Paging(farmdiaryDao.contentCnt(), currentPage, cntPerPage);
		List<FarmDiary> fdlist = farmdiaryDao.selectFarmDiaryList(p);

		res.put("paging",p);
		res.put("fdlist",fdlist);

		//		System.out.println(fdlist.size());

		return res;
	}

	@Override
	public Map<String, Object> selectFarmDiaryDetail(int farmDiaryNo) {
		Map<String, Object> res = farmdiaryDao.selectFarmDiaryDetail(farmDiaryNo);
		return farmdiaryDao.selectFarmDiaryDetail(farmDiaryNo);
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
		return farmdiaryDao.deleteFarmDiary(farmDiaryNo);

	}

	@Override
	public int modifyFarmDiary(Map<String, Object> commandMap) {
		return farmdiaryDao.modifyFarmDiary(commandMap);
	}

}
