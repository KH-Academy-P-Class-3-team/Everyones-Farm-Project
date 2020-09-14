package com.kh.farmapp.mypage.farmer.model.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.farmapp.mypage.farmer.model.dao.FarmerMypageDao;

import common.dto.Application;
import common.dto.Farmer;
import common.dto.FarmingDailylog;
import common.dto.TBOrder;
import common.dto.page.Criteria;

@Service
public class FarmerMypageServiceImpl implements FarmerMypageService {

	@Autowired
	private FarmerMypageDao farmerMypageDao;

	//영농일지 목록조회
	@Override
	public List<Map<String, Object>> dailyLoglist(Criteria cri,Farmer farmer) {

		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("farmerNo", farmer.getFarmerNo());
		data.put("cri", cri);
		
		List<Map<String, Object>> res = farmerMypageDao.dailyLoglist(data);
		
		return res;
	}

	//영농일지 페이지 총 갯수
	@Override
	public int listCount() {
		return farmerMypageDao.listCount();
	}

	//영농일지 작성 
	@Override
	public void writeDailylog(FarmingDailylog farmingDailylog) {
		farmerMypageDao.writeDailylog(farmingDailylog);
	}
	
	@Override
	// 영농일지 삭제
	public void delete(int dailyLogNo) {
		farmerMypageDao.delete(dailyLogNo);
	}
	
	//농장 체험 활동내역 리스트
	@Override
	public List<Map<String, Object>> activitylist(Criteria cri, Farmer farmer) {
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("farmerNo", farmer.getFarmerNo());
		data.put("cri", cri);
		
		List<Map<String, Object>> res = farmerMypageDao.activitylist(data);
		System.out.println(res);
		return res;
		
	}
	//농장체험 페이지 총 갯수
	@Override
	public int listCount2(Farmer farmer) {
		return farmerMypageDao.listCount2(farmer);
	}
	
	// 일손 체험 활동내역 리스트
	@Override
	public List<Map<String, Object>> activitylist3(Criteria cri ,Farmer farmer) {
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("farmerNo", farmer.getFarmerNo());
		data.put("cri", cri);
		System.out.println();
		List<Map<String,Object>> res = farmerMypageDao.activitylist3(data);
		System.out.println(res);
		return res;
	}
	//일손체험 페이지 총 갯수
	@Override
	public int listCount3(Farmer farmer) {
		return farmerMypageDao.listCount3(farmer);
	}
	
	@Override
	public FarmingDailylog read(int dailylogNo) {
		System.out.println(dailylogNo+"서비스");
		return farmerMypageDao.read(dailylogNo);
	}

	
	
	
	
	
	
	
	
	
	//승인 미승인 업데이트
	@Override
	public int updateIsApproval(Application application) {
		Application res = farmerMypageDao.selectOne(application);
		if (res.getIsApproval()==1) {
			res.setIsApproval(0);
		}else if(res.getIsApproval()==0){
			res.setIsApproval(1);
			System.out.println(res);

		}
		return farmerMypageDao.updateIsApproval(res);
	}
	

	// 판매 리스트 
	@Override
	public List<Map<String, Object>> selllist(Criteria cri ,Farmer farmer) {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("farmerNo", farmer.getFarmerNo());
		data.put("cri", cri);
		
		List<Map<String,Object>> res = farmerMypageDao.selllist(data);
		System.out.println("서비스"+res);
		return res;
	}
	//판매내역 총 갯수
	@Override
	public int listCount4(Farmer farmer) {
		return farmerMypageDao.listCount4(farmer);
	}
	
	// 결제 처리 업데이트
	@Override
	public int updatePayment(TBOrder order) {
		TBOrder res = farmerMypageDao.selectOne(order);
		if( res.getPaymentStatus()==1) {
			res.setPaymentStatus(0);
		}else if(res.getPaymentStatus()==0) {
			res.setPaymentStatus(1);
		}
		return farmerMypageDao.updatePayment(res);
	
	}

	@Override
	public List<Map<String, Object>> datelist(String date) {
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
		Date to = null;
		try {
			to = transFormat.parse(date);		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return farmerMypageDao.datelist(date);
	}

}
