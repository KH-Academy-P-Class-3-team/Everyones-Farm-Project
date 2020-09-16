package com.kh.farmapp.mypage.user.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.dto.Farmer;
import common.dto.QuestionOneonone;
import common.dto.UserProfile;
import common.dto.UserTB;

@Repository
public class MyPageDaoImpl implements MyPageDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public UserTB selectUser(UserTB user) {
		return sqlSession.selectOne("Mypage.selectUser", user);
	}

	
	@Override
	public int modifyUser(UserTB user) {
		System.out.println("2");
		return sqlSession.update("Mypage.updateUser", user);
	}

	@Override
	public UserProfile selectUserProfile(UserTB user) {
		return sqlSession.selectOne("Mypage.selectProfile", user);
	}

	@Override
	public int modifyprofile(Map<String, Object> fileMap) {
		
		return sqlSession.update("Mypage.modifyprofile", fileMap);
	}
	
	@Override
	public int insertprofile(Map<String, Object> fileMap) {
		return sqlSession.insert("Mypage.insertprofile", fileMap);
	}
	
	@Override
	public int leave(UserTB user) {
		return sqlSession.update("Mypage.deleteUser", user);
	}
	@Override
	public int farmerLeave(Farmer ckFarmer) {
		return sqlSession.update("Mypage.deleteFarmer", ckFarmer);
	}


	@Override
	public List<Map<String, Object>> o3List(Map<String, Object> forOne) {
		return sqlSession.selectList("Mypage.selectO3", forOne);
	}
	
	@Override
	public int cntO3(UserTB user) {
		return sqlSession.selectOne("Mypage.cntO3", user);
	}
	

	@Override
	public QuestionOneonone o3Detail(Map<String, Object> map) {
		return sqlSession.selectOne("Mypage.selectO3one", map);
	}
	
	@Override
	public QuestionOneonone o3DetailFarmer(Map<String, Object> map) {
		return sqlSession.selectOne("Mypage.selectO3FarmerOne", map);
	}


	@Override
	public int o3Delete(int qNo) {
		return sqlSession.delete("Mypage.deleteOneonone", qNo);
	}

	@Override
	public List<Map<String, Object>> appliActList(UserTB user) {
		
		return sqlSession.selectList("Mypage.selectActList", user);
	}
	@Override
	public List<Map<String, Object>> appliActList(Farmer farmer) {
		return sqlSession.selectList("Mypage.selectFarmerActList", farmer);
	}




	@Override
	public List<Map<String, Object>> basketList(Map<String, Object> sub) {
		return sqlSession.selectList("Mypage.selectBasketList", sub);
	}
	
	@Override
	public List<Map<String, Object>> basketFarmerList(Map<String, Object> sub) {
		return sqlSession.selectList("Mypage.selectFarmerBasketList", sub);
	}


	@Override
	public List<Map<String, Object>> orderList(Map<String, Object> sub) {
		
		return sqlSession.selectList("Mypage.selectOrderList", sub);
	}

	@Override
	public List<Map<String, Object>> orderFarmerList(Map<String, Object> sub) {
		return sqlSession.selectList("Mypage.selectFarmerOrderList", sub);
	}
	
	@Override
	public Map<String, Object> orderDetail(Map<String, Object> map) {
		return sqlSession.selectOne("Mypage.selectOrderDetail", map);
	}
	@Override
	public Map<String, Object> orderFarmerDetail(Map<String, Object> map) {
		return sqlSession.selectOne("Mypage.selectFarmerOrderDetail", map);
	}


	@Override
	public int cntApli(UserTB user) {
		return sqlSession.selectOne("Mypage.cntApli", user);
	}
	
	@Override
	public int cntApli(Farmer farmer) {
		return sqlSession.selectOne("Mypage.cntFarmerApli", farmer);
	}


	@Override
	public int cntOrder(int userNo) {
		return sqlSession.selectOne("Mypage.cntOrder", userNo);
	}
	@Override
	public int cntFarmerOrder(int farmerNo) {
		return sqlSession.selectOne("Mypage.cntFarmerOrder", farmerNo);
	}


	@Override
	public int cntBasket(int userNo) {
		return sqlSession.selectOne("Mypage.cntBasket", userNo);
	}
	
	@Override
	public int cntFarmerBasket(Farmer farmer) {
		return sqlSession.selectOne("Mypage.cntFarmerBasket", farmer);
	}


	@Override
	public int deleteBasket(int[] arr) {
		return sqlSession.delete("Mypage.deleteBasket", arr);
	}


	@Override
	public Map<String, Object> getTotla(UserTB user) {
		return sqlSession.selectOne("Mypage.minmax",user);
	}

	@Override
	public Map<String, Object> getO3FarmerTotal(Farmer farmer) {
		return sqlSession.selectOne("Mypage.O3FarmerMinMax", farmer);
	}


	@Override
	public Map<String, Object> getOrderTotal(int orderNo) {
		return sqlSession.selectOne("Mypage.orderminMax", orderNo);
	}

	@Override
	public Map<String, Object> getOrderTotal(Farmer farmer) {
		return sqlSession.selectOne("Mypage.orderFarmerminMax", farmer);
	}


	@Override
	public int writeO3(QuestionOneonone o3) {
		return sqlSession.insert("Mypage.insertO3", o3);
	}
	@Override
	public int writeO3Farmer(QuestionOneonone o3) {
		return sqlSession.insert("Mypage.insertFarmerO3", o3);
	}


	@Override
	public UserTB selectEmailCheck(String email) {
		return sqlSession.selectOne("Mypage.emailCheck", email);
	}


	@Override
	public UserTB selectPhoneCheck(String phone) {
		return sqlSession.selectOne("Mypage.phoneCheck", phone);
	}

	@Override
	public Farmer selectFarmerEmailCheck(String email) {
		return sqlSession.selectOne("Mypage.farmerEmailChk", email);
	}


	@Override
	public Farmer selectFarmerPhoneCheck(String phone) {
		return sqlSession.selectOne("Mypage.farmerPhoneChk", phone);
	}

	@Override
	public List<Map<String, Object>> selectBasket(int[] arr) {
		return sqlSession.selectList("Mypage.selectBasket", arr);
	}
	


	
	@Override
	public int subAmount(int optionNo) {
		return sqlSession.update("Mypage.subAmount", optionNo);
	}
	
	
	@Override
	public int insertPurchase(int basketNo) {
		return sqlSession.update("Mypage.updatePurchase", basketNo);
	}





	@Override
	public List<Map<String, Object>> purchaseList(int userNo) {
		return sqlSession.selectList("Mypage.selectBasketPurchase", userNo);
	}

	@Override
	public List<Map<String, Object>> purchaseList(Farmer farmer) {
		return sqlSession.selectList("Mypage.selectFarmerBasketPurchase", farmer);
	}



	@Override
	public void addAmount(int optionNo) {
		sqlSession.update("Mypage.addAmount", optionNo);
	}


	@Override
	public int subPurchase(int basketNo) {
		return sqlSession.update("Mypage.backPurchase", basketNo);
	}


	@Override
	public Map<String, Object> getAnswer(int QUESTION_NO) {
		return sqlSession.selectOne("Mypage.getAnswer",QUESTION_NO);
	}


	@Override
	public Farmer selectFarmer(int farmerNo) {
		return sqlSession.selectOne("Mypage.selectFarmer", farmerNo);
	}


	@Override
	public UserProfile selectFarmerProfile(Farmer farmer) {
		return sqlSession.selectOne("Mypage.selectFarmerProfile", farmer);
	}


	@Override
	public int modifyFarmer(Farmer farmer) {
		return sqlSession.update("Mypage.updateFarmer", farmer);
	}


	@Override
	public void insertFarmerprofile(UserProfile userProf) {
			sqlSession.insert("Mypage.insertFarmerProfile", userProf);
	}


	@Override
	public void modifFarmeryprofile(UserProfile userProf) {
		sqlSession.update("Mypage.updateFarmerProfile", userProf);
		
	}


	@Override
	public int cntO3Farmer(Farmer farmer) {
		return sqlSession.selectOne("MypageCntO3farmer", farmer);
	}


	@Override
	public List<Map<String, Object>> o3ListFarmer(Map<String, Object> forOne) {
		return sqlSession.selectList("MypageO3FarmerList", forOne);
	}


	@Override
	public int insertTbOrder(Map<String, Object> basket) {
		return sqlSession.insert("Mypage.insertTbOrder", basket);
	}


	@Override
	public int selectPrice(Map<String, Object> basket) {
		return sqlSession.selectOne("Mypage.selectPrice", basket);
	}


	@Override
	public int insertFarmerTbOrder(Map<String, Object> basket) {
		return sqlSession.insert("Mypage.insertFarmerTbOrder", basket);
	}








	





	







	




	












}
