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

import common.dto.AnsweredOneonone;
import common.dto.Application;
import common.dto.Basket;
import common.dto.EveryonesFarmFile;
import common.dto.Farmer;
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
	public int modifyUser(UserTB user) {

		String password = user.getUserPw();
		password = passwordEncoder.encode(password);

		user.setUserPw(password);
		int res = mypageDao.modifyUser(user);



		return res; 
	}
	@Override
	public void modifyFarmer(Farmer farmer) {
		String password = farmer.getFarmerPw();
		password = passwordEncoder.encode(password);

		farmer.setFarmerPw(password);
		int res = mypageDao.modifyFarmer(farmer);


	}



	@Override
	public UserProfile selectUserProfile(UserTB user) {
		return mypageDao.selectUserProfile(user);
	}

	@Override
	public UserProfile selectFarmerProfile(Farmer farmer) {
		return mypageDao.selectFarmerProfile(farmer);
	}

	@Override
	public Farmer selectFarmer(Farmer farmer) {
		return mypageDao.selectFarmer(farmer.getFarmerNo());
	}


	@Override
	public int modifyprofile(UserTB user, MultipartFile upload, String root) {
		int result=0;
		if(upload.getOriginalFilename() != "") {
			ActivityFileUtil fileUtil = new ActivityFileUtil();



			UserProfile check = new UserProfile();
			check = mypageDao.selectUserProfile(user);
			check = fileUtil.fileUpload(upload, root);

			Map<String, Object> fileMap = new HashMap<String, Object>();
			fileMap.put("userNo", user.getUserNo());
			fileMap.put("fileData", check);

			if(check == null) {
				result = mypageDao.insertprofile(fileMap);
			}else {
				result = mypageDao.modifyprofile(fileMap);
			}
			System.out.println("result"+result);
		}

		return result;
	}


	@Override
	public void modifyFarmerprofile(Farmer farmer2, MultipartFile upload, String root) {
		if(upload.getOriginalFilename() != "") {
			ActivityFileUtil fileUtil = new ActivityFileUtil();



			UserProfile check = new UserProfile();
			check = mypageDao.selectFarmerProfile(farmer2);


			UserProfile userProf = new UserProfile();
			
			if(check == null) {
				userProf = fileUtil.fileUpload(upload, root);
				userProf.setFarmerNo(farmer2.getFarmerNo());
				mypageDao.insertFarmerprofile(userProf);
			}else {
				userProf = fileUtil.fileUpload(upload, root);
				userProf.setFarmerNo(farmer2.getFarmerNo());
				mypageDao.modifFarmeryprofile(userProf);
			}
		}


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
	public int farmerLeave(Farmer ckFarmer) {
		return mypageDao.farmerLeave(ckFarmer);
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
	public Map<String, Object> o3ListFarmer(int cPage, int cntPerPage, Farmer farmer) {
		int farmerNo = farmer.getFarmerNo();
		Map<String, Object> o3List = new HashMap<String, Object>();
		Map<String, Object> forOne = new HashMap<String, Object>();

		Paging page = new Paging(mypageDao.cntO3Farmer(farmer), cPage, cntPerPage);

		forOne.put("page", page);
		forOne.put("farmerNo", farmerNo);
		List<Map<String, Object>> one = mypageDao.o3ListFarmer(forOne);
		o3List.put("o3List", one);
		o3List.put("page", page);

		return o3List;
	}

	@Override
	public QuestionOneonone o3Detail(int qNo, int userNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("qNo", qNo);
		map.put("userNo", userNo);
		return mypageDao.o3Detail(map);
	}
	@Override
	public QuestionOneonone o3DetailFarmer(int qUESTION_NO, int farmerNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("qNo", qUESTION_NO);
		map.put("farmerNo", farmerNo);
		return mypageDao.o3DetailFarmer(map);
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
	public List<Map<String, Object>> appliActList(Farmer farmer) {
		return mypageDao.appliActList(farmer);
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
	public Map<String, Object> basketList(Farmer farmer, int cPage, int cntPerPage) {
		int total= mypageDao.cntFarmerBasket(farmer);
		Paging page = new Paging(total, cPage, cntPerPage);

		System.out.println("전체 게시물 수 :" + total);
		Map<String, Object> sub = new HashMap<String, Object>();

		sub.put("page", page);
		sub.put("farmerNo", farmer.getFarmerNo());
		List<Map<String, Object>> baskets = mypageDao.basketFarmerList(sub);

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
	public Map<String, Object> orderFarmerList(int farmerNo, int cPage, int cntPerPage) {
		Map<String, Object> orderList = new HashMap<String, Object>();

		int total= mypageDao.cntFarmerOrder(farmerNo);
		Paging page = new Paging(total, cPage, cntPerPage);

		System.out.println("전체 게시물 수 :" + total);
		Map<String, Object> sub = new HashMap<String, Object>();

		sub.put("page", page);
		sub.put("farmerNo", farmerNo);

		List<Map<String, Object>> orders = mypageDao.orderFarmerList(sub);
		System.out.println(orders);
		orderList.put("orders", orders);
		orderList.put("page", page);

		return orderList;
	}

	@Override
	public Map<String, Object> orderDetail(int orderNo, int userNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderNo", orderNo);
		map.put("userNo", userNo);
		return mypageDao.orderDetail(map);
	}

	@Override
	public Map<String, Object> orderFarmerDetail(int orderNo, int farmerNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderNo", orderNo);
		map.put("farmerNo", farmerNo);
		return mypageDao.orderFarmerDetail(map);
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
	public int cntApli(Farmer farmer) {
		return mypageDao.cntApli(farmer);
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
	public Map<String, Object> getTotalFarmer(Farmer farmer) {
		return mypageDao.getO3FarmerTotal(farmer);
	}


	@Override
	public Map<String, Object> getOrderTotal(int orderNo) {
		return mypageDao.getOrderTotal(orderNo);
	}
	
	@Override
	public Map<String, Object> getOrderTotal(Farmer farmer) {
		return mypageDao.getOrderTotal(farmer);
	}



	@Override
	public int wirteO3(QuestionOneonone o3) {
		System.out.println("famerNo : "+o3.getFarmerNo());
		if(o3.getFarmerNo() == 0) {
			return mypageDao.writeO3(o3);
		}else {
			return mypageDao.writeO3Farmer(o3);
		}
	}


	@Override
	public int selectEmailCheck(String email, UserTB user) {

		UserTB userchk = mypageDao.selectEmailCheck(email); 
		int res = 0;
		if( userchk==null ||userchk.getEmail().equals(user.getEmail()) ) {
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
		if( userchk==null ||userchk.getPhone().equals(user.getPhone())) {
			return res;
		}else {
			res = 1;
			return res;
		}

	}
	@Override
	public int selectFarmerEmailCheck(String email, Farmer farmer) {
		Farmer farmerchk = mypageDao.selectFarmerEmailCheck(email); 
		int res = 0;
		if( farmerchk==null ||farmerchk.getEmail().equals(farmer.getEmail()) ) {
			return res;
		}else {
			res = 1;
			return res;
		}
	}


	@Override
	public int selectFarmerPhoneCheck(String phone, Farmer farmer) {
		Farmer farmerchk = mypageDao.selectFarmerPhoneCheck(phone);
		int res = 0;
		if( farmerchk==null ||farmerchk.getEmail().equals(farmer.getEmail()) ) {
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
	public Map<String, Object> basketListPur(Farmer farmer) {
		List<Map<String, Object>> baskets = mypageDao.purchaseList(farmer);

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


	@Override
	public Map<String, Object> getAnswer(int QUESTION_NO) {
		return mypageDao.getAnswer(QUESTION_NO);
	}




























}
