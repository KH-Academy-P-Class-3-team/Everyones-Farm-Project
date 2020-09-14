package com.kh.farmapp.foodsales.model.dao;

import java.util.List;
import java.util.Map;

import common.dto.Product;
import common.dto.Review;
import common.dto.ReviewFile;
import common.dto.UserTB;

public interface ReviewDao {

	
	
	/**
	 * 리뷰 작성
	 * 
	 * @param wirteReview - 작성할 리뷰
	 * @return int
	 */
	
	public int writeReview(Review review, Product product);
	
	
	/**
	 * 리뷰 삭제
	 * 
	 * @param DeleteReview - 삭제할 리뷰
	 * @return int
	 */
	public int deleteReview(Review review);
//	public List<Map<String,Object>> deleteReview(Review review);
	
	/**
	 * 리뷰 업데이트
	 * 
	 * @param updateReview - 업데이트할 리뷰
	 * @return String
	 */
	public int updateReview(UserTB user, Review review);
	
	/**
	 * 리뷰 조회
	 * 
	 * @param review - 리뷰 객체
	 * @return String
	 */
//	public List<Map<String,Object>> selectReview(Review review, User user, Product product);
	
	/**
	 * 리뷰 더 보기
	 * 
	 * @param review - 리뷰 객체
	 * @return String
	 */
	public List<Map<String,Object>> reviewMore(Review review, ReviewFile reviewFile,  UserTB user, Product product);
	
	
}
