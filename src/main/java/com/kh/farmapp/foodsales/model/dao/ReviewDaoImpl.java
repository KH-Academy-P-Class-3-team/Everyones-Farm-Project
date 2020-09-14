package com.kh.farmapp.foodsales.model.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import common.dto.Product;
import common.dto.Review;
import common.dto.ReviewFile;
import common.dto.TBOrder;
import common.dto.UserTB;


@Repository
public class ReviewDaoImpl implements ReviewDao{

	@Override
	public int updateReview(UserTB user, Review review) {
		// TODO Auto-generated method stub
		return 0;
	}

//	@Override
//	public List<Map<String, Object>> selectReview(Review review, User user, Product product) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<Map<String, Object>> reviewMore(Review review, ReviewFile reviewFile, UserTB user, Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int writeReview(Review review, Product product) {
		
		// 클래스 다이어그램 용 DTO 객체 선언
		TBOrder o = new TBOrder();
		
		return 0;
	}

	@Override
	public int deleteReview(Review review) {
		// TODO Auto-generated method stub
		return 0;
	}

	



	
	

	
	
	



	
	
	
}
