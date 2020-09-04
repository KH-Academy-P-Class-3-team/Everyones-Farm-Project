package com.kh.farmapp.foodsales.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.farmapp.foodsales.model.dao.ReviewDao;

import common.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDao reviewDao;
	
	
	/**
	 * 리뷰 삽입
	 * 
	 * @param review - 입력할 리뷰
	 */
	public int writeReview(HashMap<String, Object> map) {
		return reviewDao.writeReview(map);
	}
	
	/**
	 * 리뷰 삭제
	 * 
	 * @param DeleteReview - 삭제할 리뷰
	 */
	public int deleteReview(Map map) {
		return reviewDao.deleteReview(map);
	}
	
	/**
	 * 리뷰 업데이트
	 * 
	 * @param updateReview - 업데이트할 리뷰
	 */
	public String updateReview(Review review) {
		return null;
	}
	
	/**
	 * 리뷰 조회
	 * 
	 * @param review - 리뷰 객체
	 */
	public List selectReview(Map<String,Object> map) {
		return reviewDao.selectReview(map);
	}
	
	/**
	 * 리뷰 더 보기
	 * 
	 * @param map
	 * @return String
	 */
	public String reviewMore(Map<String,Object> map) {
		return null;
	}
	
	/**
	 * 리뷰 점수 번호
	 * 
	 * @param review - 리뷰 점수 번호
	 * @return int
	 */
	public int reviewScore(Review review) {
		return 0;
	}
	
	/**
	 * 리뷰 파일 번호
	 * 
	 * @param review - 리뷰 파일 번호
	 * @return int
	 */
	public int reviewFileNo(Review review) {
		return 0;
	}
	
	/**
	 * 리뷰  파일 
	 * 
	 * @param map - 리뷰 파일
	 * @return
	 */
	public String reviewContent(Map<String,Object> map) {
		return null;
	}


}
