package com.kh.farmapp.mypage.user.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.dto.AnsweredOneonone;
import common.dto.Application;
import common.dto.Basket;
import common.dto.Product;
import common.dto.QuestionOneonone;
import common.dto.TBOrder;
import common.dto.UserAddress;
import common.dto.UserProfile;
import common.dto.UserTB;
import common.util.Paging;

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
	public UserProfile selectUserProfile(int userNo) {
		return sqlSession.selectOne("Mypage.selectProfile", userNo);
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
	public List<Map<String, Object>> o3List(Map<String, Object> forOne) {
		return sqlSession.selectList("Mypage.selectO3", forOne);
	}
	
	@Override
	public int cntO3(UserTB user) {
		return sqlSession.selectOne("Mypage.cntO3", user);
	}
	

	@Override
	public QuestionOneonone o3Detail(int qNo) {
		return sqlSession.selectOne("Mypage.selectO3one", qNo);
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
	public List<Map<String, Object>> basketList(Map<String, Object> sub) {
		return sqlSession.selectList("Mypage.selectBasketList", sub);
	}

	@Override
	public int addProduct(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, Object>> orderList(Map<String, Object> sub) {
		
		// 클래스다이어그램 용 DTO 객체 선언
		return sqlSession.selectList("Mypage.selectOrderList", sub);
	}

	@Override
	public Map<String, Object> orderDetail(int orderNo) {
		return sqlSession.selectOne("Mypage.selectOrderDetail", orderNo);
	}


	@Override
	public int cntApli(UserTB user) {
		return sqlSession.selectOne("Mypage.cntApli", user);
	}


	@Override
	public int cntOrder(int userNo) {
		return sqlSession.selectOne("Mypage.cntOrder", userNo);
	}


	@Override
	public int cntBasket(int userNo) {
		return sqlSession.selectOne("Mypage.cntBasket", userNo);
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
	public Map<String, Object> getOrderTotal(int orderNo) {
		return sqlSession.selectOne("Mypage.orderminMax", orderNo);
	}


	@Override
	public int writeO3(QuestionOneonone o3) {
		return sqlSession.insert("Mypage.insertO3", o3);
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
	public Application appliHelpList() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UserAddress getAddress(UserTB user) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Map<String, Object>> purchaseList(int userNo) {
		return sqlSession.selectList("Mypage.selectBasketPurchase", userNo);
	}


	@Override
	public void addAmount(int optionNo) {
		sqlSession.update("Mypage.addAmount", optionNo);
	}


	@Override
	public int subPurchase(int basketNo) {
		return sqlSession.update("Mypage.backPurchase", basketNo);
	}









}
