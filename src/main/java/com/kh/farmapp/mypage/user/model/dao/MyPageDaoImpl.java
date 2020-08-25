package com.kh.farmapp.mypage.user.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
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

@Repository
public class MyPageDaoImpl implements MyPageDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public Map<String, Object> selectUser(UserTB user) {
		return sqlSession.selectOne("Mypage.selectUser", user);
	}

	
	@Override
	public int modifyUser(UserTB user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyprofile(UserTB user) {
		
		// 클래스 다이어그램 용 DTO 객체 선언
		UserProfile up = new UserProfile();
		
		return 0;
	}

	@Override
	public int leave(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<QuestionOneonone> o3List() {
		return sqlSession.selectList("Mypage.selectO3");
	}

	@Override
	public QuestionOneonone o3Detail(int qNo) {
		
		// 클래스 다이어그램 용 DTO 객체 선언
		QuestionOneonone q = new QuestionOneonone();
		AnsweredOneonone a = new AnsweredOneonone();
		UserTB u = new UserTB();
		
		return null;
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
		
		// 클래스 다이어그램 용 Dto 객체 선언
		Application application = new Application();
		
		return null;
	}

	@Override
	public Application appliHelpList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Basket basketList() {
		
		// 클래스 다이어그램 용 DTO 객체 선언
		Basket basket = new Basket();
		
		return null;
	}

	@Override
	public int addProduct(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TBOrder orderList() {
		
		// 클래스다이어그램 용 DTO 객체 선언
		TBOrder order = new TBOrder();
		Product p = new Product();
		UserTB user = new UserTB();
		UserAddress ua = new UserAddress();
		
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


}
