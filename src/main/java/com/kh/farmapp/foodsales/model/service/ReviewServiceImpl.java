package com.kh.farmapp.foodsales.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.farmapp.foodsales.model.dao.ReviewDao;

import common.dto.Product;
import common.dto.Review;
import common.dto.ReviewFile;
import common.dto.UserTB;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDao reviewDao;

	@Override
	public int deleteReview(Review review) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateReview(UserTB user, Review review) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, Object>> selectReview(Review review, UserTB user, Product product) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public int reviewScore(Review review) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

//	@Override
//	public int reviewFileNo(Review review, ReviewFile reviewFile) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

//	@Override
//	public List<Map<String, Object>> reviewContent() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
