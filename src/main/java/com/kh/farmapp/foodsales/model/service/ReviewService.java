package com.kh.farmapp.foodsales.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.dto.Review;

public interface ReviewService {


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
     * @param review - 리뷰 조회 객체
     * @return String
     */
    public List selectReview(Map<String, Object> map);

    /**
     * 리뷰 더 보기
     *
     * @param review - 리뷰 객체
     * @return String
     */
    public String reviewMore(Map<String, Object> map);

    /**
     * 리뷰 점수 번호
     *
     * @param reviewScore - 리뷰 점수 번호
     * @return int
     */
    public int reviewScore(Review review);

    /**
     * 리뷰 파일 번호
     *
     * @param reviewFile - 리뷰 파일 번호
     * @return int
     */
    public int reviewFileNo(Review review);

    /**
     * 리뷰 내용
     *
     * @param reviewFile - 리뷰 내용
     * @return String
     */
    public String reviewContent(Map<String, Object> map);

    /**
     * 리뷰 작성
     *
     * @param reviewFile - 리뷰 내용
     * @return String
     */
    public int writeReview(HashMap<String, Object> map) throws Exception;

}
