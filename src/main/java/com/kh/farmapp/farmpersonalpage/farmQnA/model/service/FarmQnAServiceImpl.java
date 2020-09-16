package com.kh.farmapp.farmpersonalpage.farmQnA.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.farmapp.farmpersonalpage.farmQnA.model.dao.FarmQnADao;

import common.dto.FarmDiary;
import common.dto.FarmQnAQuestion;
import common.dto.FarmQnaAnswer;
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
	public Map<String, Object> selectFarmQnAList(int currentPage, int cntPerPage, int farmNo) {
		Paging p = new Paging(farmqnaDao.contentCnt(), currentPage, cntPerPage);
		
		Map<String, Object> pagingConfig = new HashMap<>();
//		pagingConfig.put("p", p);
//		pagingConfig.put("farmer", farmer);
		pagingConfig.put("start", p.getStart());
		pagingConfig.put("end", p.getEnd());
		pagingConfig.put("farmNo", farmNo);
		
		List<FarmQnAQuestion> fdlist = farmqnaDao.selectFarmQnAList(pagingConfig);
		System.out.println("FarmDiaryService - fdlist: " + fdlist.toString());

		Map<String,Object> res = new HashMap<String, Object>();	
		
		res.put("fdlist",fdlist);
		res.put("paging", p);
		
		System.out.println("서비스값" + res.toString());
		System.out.println("fd사이즈:"+fdlist.size());

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
	
	@Override
	public int modifyQnA(Map<String, Object> commandMap) {
		return farmqnaDao.modifyQnA(commandMap);
	}

	@Override
	public int selectFarmNoByFarmerNo2(String farmerNo) {
		return farmqnaDao.selectFarmNoByFarmerNo2(farmerNo);
	}

	@Override
	public void writeAnswer(FarmQnaAnswer farmqnaAnswer) {
		farmqnaDao.answerInsert(farmqnaAnswer);
	}

	@Override
	public List<FarmQnaAnswer> selectAnswerList(int farmQnaQuestionNo) {
		return farmqnaDao.selectAnserList(farmQnaQuestionNo);
	}

	@Override
	public int insertFarmQna(Map<String, Object> commandMap) {
		return farmqnaDao.insertFarmQnA(commandMap);
	}

	@Override
	public int insertFarmerFarmQna(Map<String, Object> commandMap) {
		return farmqnaDao.insertFarmerFarmQnA(commandMap);
	}

}
