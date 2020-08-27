package com.kh.farmapp.mypage.user.model.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import com.kh.farmapp.mypage.user.model.dao.MyPageDao;

import common.dto.Application;
import common.dto.Basket;
import common.dto.Product;
import common.dto.QuestionOneonone;
import common.dto.TBOrder;
import common.dto.UserAddress;
import common.dto.UserTB;
import common.util.FileUtil;

@Service
public class MypageServiceImpl implements MyPageService{

	@Autowired
	private MyPageDao mypageDao;
	
	@Override
	public int modifyUser(Map<String, Object> map) {
		
		UserTB user = new UserTB();
		
		int res = mypageDao.modifyUser(user);
		
		
		return res;
	}


	
	@Override
	public int modifyprofile(UserTB user) {
		return 0;
	}

	@Override
	public void insertFile(UserTB user, File file, String root) {
		
		FileUtil fileUtil = new FileUtil();
		
//		List<Map<String, String>> filedata = fileUtil.fileUpload(file, root);
		
	}
	
	@Override
	public int leave(UserTB user) {
		return mypageDao.leave(user);
	}

	@Override
	public List<QuestionOneonone> o3List() {
		return mypageDao.o3List();
	}

	@Override
	public QuestionOneonone o3Detail(int qNo) {
		return mypageDao.o3Detail(qNo);
	}

	@Override
	public int o3Upload(QuestionOneonone qO3) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int o3Modify(int qNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int o3Delete(int qNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Application appliActList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Application appliHelpList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Basket basketList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addProduct(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TBOrder orderList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product orderDetail(int orderNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserAddress getAddress(UserTB user) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public UserTB selectUser(UserTB user) {
		
		UserTB utb = mypageDao.selectUser(user);
		
		return utb;
	}



}
