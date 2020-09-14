package com.kh.farmapp.foodsales.model.service;

import java.util.List;
import java.util.Map;

import common.dto.Product;
import common.dto.Review;
import common.dto.ReviewFile;
import common.dto.UserTB;

public interface ReviewService {

	
	/**
	 * 리뷰 삭제
	 * 
	 * @param DeleteReview - 삭제할 리뷰
	 * @return int 
	 */
	public int deleteReview(Review review);
	
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
	 * @param review - 리뷰 조회 객체
	 * @return String
	 */
	public List<Map<String, Object>> selectReview(Review review, UserTB user, Product product);
	
//	/**
//	 * 리뷰 더 보기
//	 * 
//	 * @param review - 리뷰 객체
//	 * @return String
//	 */
//	public List<Map<String, Object>> reviewMore();
	
	/**
	 * 리뷰 점수 번호
	 * 
	 * @param reviewScore - 리뷰 점수 번호
	 * @return int
	 */
//	public int reviewScore(Review review);
	
	/**
	 * 리뷰 파일 번호
	 * 
	 * @param reviewFile - 리뷰 파일 번호
	 * @return int
	 */
//	public int reviewFileNo(Review review, ReviewFile reviewFile);
	
	/**
	 * 리뷰 내용
	 * 
	 * @return String
	 */
//	public List<Map<String, Object>> reviewContent();
	
}
