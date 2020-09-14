package com.kh.farmapp.mypage.user.model.service;

import java.io.File;
<<<<<<< HEAD
=======
import java.util.HashMap;
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
import java.util.List;
import java.util.Map;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
import org.springframework.stereotype.Service;

import com.kh.farmapp.mypage.user.model.dao.MyPageDao;

import common.dto.Application;
import common.dto.Basket;
<<<<<<< HEAD
import common.dto.Product;
import common.dto.QuestionOneonone;
import common.dto.TBOrder;
import common.dto.UserAddress;
import common.dto.UserTB;
import common.util.FileUtil;
=======
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
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added

@Service
public class MypageServiceImpl implements MyPageService{

	@Autowired
	private MyPageDao mypageDao;
	
	@Override
<<<<<<< HEAD
<<<<<<< HEAD
	public Map<String, Object> modifyUser(UserTB user) {
=======
=======
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
	public int modifyUser(UserTB user, String root, MultipartFile upload) {
		
		String password = user.getUserPw();
		password = passwordEncoder.encode(password);
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
		
		Map<String, Object> userInfo = mypageDao.selectUser(user);
		
<<<<<<< HEAD
=======
		user.setUserPw(password);
		int res = mypageDao.modifyUser(user);
		
		if(upload.getOriginalFilename() != "") {
		ActivityFileUtil fileUtil = new ActivityFileUtil();
		
		
		
		UserProfile check = new UserProfile();
		check = mypageDao.selectUserProfile(user.getUserNo());
		check = fileUtil.fileUpload(upload, root);
		
<<<<<<< HEAD
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
		
		ActivityFileUtil fileUtil = new ActivityFileUtil();
		
		UserProfile check = new UserProfile();
		
		check = mypageDao.selectUserProfile(user.getUserNo());
		
		UserProfile fileData = fileUtil.fileUpload(upload, root);
		
		Map<String, Object> fileMap = new HashMap<String, Object>();
		fileMap.put("userNo", user.getUserNo());
		fileMap.put("fileData", fileData);
		int result=0;
		if(check == null) {
			result = mypageDao.insertprofile(fileMap);
		}else {
			result = mypageDao.modifyprofile(fileMap);
		}
		System.out.println(result);
		
//		return 0;
		return res; // 그리고 return 값을 보내서 쓰이는 곳이 없으면 지우는게 맞는거 같네요
	}

	@Override
	public void modifyUserProfile(UserTB user, String root, MultipartFile upload) {
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
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
		
		return userInfo;
=======

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
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
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
<<<<<<< HEAD
=======

	@Override
	public void insertFile(UserTB user, File file, String root) {
		
		FileUtil fileUtil = new FileUtil();
		
//		List<Map<String, String>> filedata = fileUtil.fileUpload(file, root);
		
	}
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
	
	@Override
	public int leave(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<QuestionOneonone> o3List() {
		return mypageDao.o3List();
	}

	@Override
	public QuestionOneonone o3Detail(int qNo) {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		return null;
	}

=======
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

>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
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

<<<<<<< HEAD
	@Override
	public int o3Delete(int qNo) {
		// TODO Auto-generated method stub
		return 0;
=======
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
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
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
<<<<<<< HEAD
	public TBOrder orderList() {
		// TODO Auto-generated method stub
		return null;
=======
	public int selectEmailCheck(String email, UserTB user) {
		
		UserTB userchk = mypageDao.selectEmailCheck(email); 
		int res = 0;
		if(userchk.getUserNo()==user.getUserNo() || user.getPhone()==null) {
			return res;
		}else {
			res = 1;
			return res;
		}
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
	}

	@Override
<<<<<<< HEAD
	public Product orderDetail(int orderNo) {
		// TODO Auto-generated method stub
		return null;
=======
	public int selectPhoneCheck(String phone, UserTB user) {
		UserTB userchk = mypageDao.selectPhoneCheck(phone); 
		int res = 0;
		if(userchk.getUserNo()==user.getUserNo() || user.getPhone()==null) {
			return res;
		}else {
			res = 1;
			return res;
		}
		
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
	}

	@Override
	public UserAddress getAddress(UserTB user) {
		// TODO Auto-generated method stub
		return null;
	}


<<<<<<< HEAD
=======
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






>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05

}
