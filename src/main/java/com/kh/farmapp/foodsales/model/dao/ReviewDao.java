package com.kh.farmapp.foodsales.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.dto.Review;

public interface ReviewDao {

	
	
	/**
	 * 리뷰 작성
	 * 
	 * @param map - 작성할 리뷰
	 * @return int
	 */
	
	public int writeReview(HashMap<String, Object> map);
	
	
	/**
	 * 리뷰 삭제
	 * 
	 * @param DeleteReview - 삭제할 리뷰
	 * @return int
	 */
	public int deleteReview(Map map);
	
	/**
	 * 리뷰 업데이트
	 * 
	 * @param updateReview - 업데이트할 리뷰
	 * @return String
	 */
	public String updateReview(Review review);
	
	/**
	 * 리뷰 조회
	 * 
	 * @param map - 리뷰 객체
	 * @return List
	 */
	public List selectReview(Map<String,Object> map);
	
	/**
	 * 리뷰 더 보기
	 * 
	 * @param review - 리뷰 객체
	 * @return String
	 */
	public List reviewMore(Map<String,Object> map);

}
