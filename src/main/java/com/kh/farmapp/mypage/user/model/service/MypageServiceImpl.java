package com.kh.farmapp.mypage.user.model.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.farmapp.mypage.user.model.dao.MyPageDao;

import common.dto.Application;
import common.dto.Basket;
import common.dto.EveryonesFarmFile;
import common.dto.Product;
import common.dto.Purchase;
import common.dto.QuestionOneonone;
import common.dto.TBOrder;
import common.dto.UserAddress;
import common.dto.UserProfile;
import common.dto.UserTB;
import common.util.ActivityFileUtil;
import common.util.FileUtil;
import common.util.Paging;

@Service
public class MypageServiceImpl implements MyPageService{

	@Autowired
	private MyPageDao mypageDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public int modifyUser(UserTB user, String root, MultipartFile upload) {
		
		String password = user.getUserPw();
		password = passwordEncoder.encode(password);
		
		user.setUserPw(password);
		int res = mypageDao.modifyUser(user);
		
		if(upload.getOriginalFilename() != "") {
		ActivityFileUtil fileUtil = new ActivityFileUtil();
		
		
		
		UserProfile check = new UserProfile();
		check = mypageDao.selectUserProfile(user.getUserNo());
		check = fileUtil.fileUpload(upload, root);
		

		Map<String, Object> fileMap = new HashMap<String, Object>();
		fileMap.put("userNo", user.getUserNo());
		fileMap.put("fileData", check);
		int result=0;
		if(check == null) {
			result = mypageDao.insertprofile(fileMap);
		}else {
			result = mypageDao.modifyprofile(fileMap);
		}
		System.out.println("result"+result);
		}
		
		return res;
	}

	
	@Override
	public UserProfile selectUserProfile(UserTB user) {
		return mypageDao.selectUserProfile(user.getUserNo());
	}


	
	@Override
	public int modifyprofile(UserTB user, MultipartFile file, String root) {
		
		ActivityFileUtil fileUtil = new ActivityFileUtil();
		
		UserProfile check = new UserProfile();
		
		check = mypageDao.selectUserProfile(user.getUserNo());
		
		UserProfile fileData = fileUtil.fileUpload(file, root);
		
		Map<String, Object> fileMap = new HashMap<String, Object>();
		fileMap.put("userNo", user.getUserNo());
		fileMap.put("fileData", fileData);
		int res=0;
		if(check == null) {
			res = mypageDao.insertprofile(fileMap);
		}else {
			res = mypageDao.modifyprofile(fileMap);
		}
		
		return res;
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
	public Map<String, Object> o3List(int cPage, int cntPerPage, UserTB user) {
		int userNo = user.getUserNo();
		Map<String, Object> o3List = new HashMap<String, Object>();
		Map<String, Object> forOne = new HashMap<String, Object>();
		
		Paging page = new Paging(mypageDao.cntO3(user), cPage, cntPerPage);

		forOne.put("page", page);
		forOne.put("userNo", userNo);
		List<Map<String, Object>> one = mypageDao.o3List(forOne);
		o3List.put("o3List", one);
		o3List.put("page", page);
		
		return o3List;
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
		return mypageDao.o3Delete(qNo);
	}

	@Override
	public List<Map<String, Object>> appliActList(UserTB user) {
		return mypageDao.appliActList(user);
	}

	@Override
	public Application appliHelpList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> basketList(int userNo, int cPage, int cntPerPage) {
		
		int total= mypageDao.cntBasket(userNo);
		Paging page = new Paging(total, cPage, cntPerPage);

		System.out.println("전체 게시물 수 :" + total);
		Map<String, Object> sub = new HashMap<String, Object>();
		
		sub.put("page", page);
		sub.put("userNo", userNo);
		List<Map<String, Object>> baskets = mypageDao.basketList(sub);
		
		Map<String, Object> basketList = new HashMap<String, Object>();
		
		basketList.put("baskets", baskets);
		basketList.put("page", page);
		
		return basketList;
	}

	@Override
	public int addProduct(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> orderList(int userNo, int cPage, int cntPerPage) {
		
		Map<String, Object> orderList = new HashMap<String, Object>();
		
		int total= mypageDao.cntOrder(userNo);
		Paging page = new Paging(total, cPage, cntPerPage);

		System.out.println("전체 게시물 수 :" + total);
		Map<String, Object> sub = new HashMap<String, Object>();
		
		sub.put("page", page);
		sub.put("userNo", userNo);
		
		List<Map<String, Object>> orders = mypageDao.orderList(sub);
		System.out.println(orders);
		orderList.put("orders", orders);
		orderList.put("page", page);
		
		return orderList;
		
	}

	@Override
	public Map<String, Object> orderDetail(int orderNo) {
		return mypageDao.orderDetail(orderNo);
	}

	@Override
	public UserAddress getAddress(UserTB user) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public UserTB selectUser(UserTB user) {
		
		return mypageDao.selectUser(user);
	}



	@Override
	public int getCount(UserTB user) {
		return mypageDao.cntO3(user);
	}



	@Override
	public int cntApli(UserTB user) {
		return mypageDao.cntApli(user);
	}



	@Override
	public int deleteBasket(int[] arr) {
		
		return  mypageDao.deleteBasket(arr);
		
	}


	@Override
	public Map<String, Object> getTotal(UserTB user) {
		return mypageDao.getTotla(user);
	}


	@Override
	public Map<String, Object> getOrderTotal(int orderNo) {
		return mypageDao.getOrderTotal(orderNo);
	}

	

	@Override
	public int wirteO3(QuestionOneonone o3) {
		return mypageDao.writeO3(o3);
	}


	@Override
	public int selectEmailCheck(String email, UserTB user) {
		
		UserTB userchk = mypageDao.selectEmailCheck(email); 
		int res = 0;
		if(userchk.getUserNo()==user.getUserNo() || user.getPhone()==null) {
			return res;
		}else {
			res = 1;
			return res;
		}
	}


	@Override
	public int selectPhoneCheck(String phone, UserTB user) {
		UserTB userchk = mypageDao.selectPhoneCheck(phone); 
		int res = 0;
		if(userchk.getUserNo()==user.getUserNo() || user.getPhone()==null) {
			return res;
		}else {
			res = 1;
			return res;
		}
		
	}


	@Override
	public int insertPurchase(int[] arr) {
		
		List<Map<String, Object>> basketList = mypageDao.selectBasket(arr);
		
		int res = 0;
		for(Map<String, Object> b : basketList) {
			System.out.println(b);
			String amount = String.valueOf(b.get("AMOUNT"));
			if(Integer.parseInt(amount)== 0) {
				return res;
			}else {
				String optionNo = String.valueOf(b.get("OPTION_NO"));
				String basketNo = String.valueOf(b.get("BASKET_NO"));
				res = mypageDao.subAmount(Integer.parseInt(optionNo));
				mypageDao.insertPurchase(Integer.parseInt(basketNo));
			}
		}
		
		return res;
	}


	@Override
	public Map<String, Object> basketListPur(int userNo) {
		
		List<Map<String, Object>> baskets = mypageDao.purchaseList(userNo);
		
		int cost = 0;
		for(Map<String, Object> c : baskets) {
			String costs = String.valueOf(c.get("PRICE"));
			cost += Integer.parseInt(costs);
		}
		
		Map<String, Object> basketList = new HashMap<String, Object>();
		
		basketList.put("baskets", baskets);
		basketList.put("cost", cost);
		
		return basketList;
	}


	@Override
	public int canclePurchase(int[] arr) {
		List<Map<String, Object>> basketList = mypageDao.selectBasket(arr);

		int res = 0;
		for(Map<String, Object> b : basketList) {
			String optionNo = String.valueOf(b.get("OPTION_NO"));
			String basketNo = String.valueOf(b.get("BASKET_NO"));
			//purchase를 0으로 다시 만드는 메서드
			res = mypageDao.subPurchase(Integer.parseInt(basketNo));
			//amount +1
			mypageDao.addAmount(Integer.parseInt(optionNo));
		}
		return res;
		
		
	}








}
