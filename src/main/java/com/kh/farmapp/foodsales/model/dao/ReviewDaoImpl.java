package com.kh.farmapp.foodsales.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.dto.TBOrder;
import common.dto.Review;
import common.dto.ReviewFile;
import common.dto.UserTB;

@Repository
public class ReviewDaoImpl implements ReviewDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public int writeReview(HashMap map) {

        // 클래스 다이어그램용 DTO 객체 선언
        Review r = new Review();
        ReviewFile rf = new ReviewFile();
        UserTB user = new UserTB();
        TBOrder o = new TBOrder();


//        sqlSession.selectList()
        int seq =  sqlSession.insert("Review.writeReview", map);

        if(seq > 0){
            return sqlSession.insert("Review.insertReviewFile", map);
        }
        return -1;
    }

    @Override
    public int deleteReview(Map map) {
        sqlSession.delete("Review.deleteReview", map);
        return sqlSession.delete("Review.deleteReview_file", map);
    }

    @Override
    public String updateReview(Review review) {
        return null;
    }

    @Override
    public List selectReview(Map<String, Object> map) {
        return sqlSession.selectList("Review.selectReviews", map);
    }

    @Override
    public List reviewMore(Map<String, Object> map) {
        return null;
    }

}
