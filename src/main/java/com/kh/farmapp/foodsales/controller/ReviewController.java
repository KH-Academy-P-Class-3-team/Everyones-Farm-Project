package com.kh.farmapp.foodsales.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.*;

import com.kh.farmapp.HomeController;
import common.dto.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.foodsales.model.service.ReviewService;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/review")
@Transactional(rollbackFor = Exception.class)
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    private static final Logger logger = LoggerFactory.getLogger(ReviewService.class);

    //
    //리뷰 삭제
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseEntity reviewDelete(@RequestParam(value = "checkArr[]") List<Integer> list) {
        ResponseEntity entity = null;

        Map<String, Object> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(list.get(i));
        }
        map.put("reviewNos", sb.toString());
        if (reviewService.deleteReview(map) >= 0) {

            entity = new ResponseEntity("success", HttpStatus.OK);
        } else {
            entity = new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }

        return entity;

    }

    //
//	//리뷰 업데이트
//	@RequestMapping("")
//	public String reviewUpdate() {
//		return null;
//		
//	}
//	
    //	//리뷰 작성

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<String> reviewWrite(
            MultipartHttpServletRequest request) {
        int nRes = -1;
        ResponseEntity entity = null;
        HashMap<String, Object> paramMap = new HashMap();

        String content = request.getParameter("content");
        String score = request.getParameter("reviewScore");

        String filePath = request.getSession().getServletContext().getRealPath("/");
//        String filePath = "resources/";


        filePath = filePath + "resources/fileUpload/";

        File file = new File(filePath);
        if (file.exists() == false) {
            file.mkdirs();
        }
        try {

            Iterator<String> files = request.getFileNames();
            while (files.hasNext()) {
                String uploadFile = files.next();
                MultipartFile multipartFile = request.getFile(uploadFile);

                if (multipartFile.isEmpty() == false) {
                    logger.debug("name : " + multipartFile.getName());

                    String originalFileName = multipartFile.getOriginalFilename();
                    String originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
                    String storedFileName = System.currentTimeMillis() + originalFileExtension;


                    file = new File(filePath + storedFileName);
                    multipartFile.transferTo(file);

//                    INSERT INTO REVIEW_FILE(REVIEW_FILE_NO , REVIEW_NO, ORIGIN_NAME , FILE_RENAME , SAVE_PATH, IS_THUMBNAIL )


                    //수정 필요?
//                    paramMap.put("reviewNo", "2");
                    paramMap.put("productNo", "1");
                    paramMap.put("content", content);

                    paramMap.put("farmerNo", null);
                    paramMap.put("userNo", null);
                    paramMap.put("reviewScore", score);


                    // review file
                    paramMap.put("originName", originalFileName);
                    paramMap.put("fileReName", storedFileName);
                    paramMap.put("savePath", filePath);
                    paramMap.put("isThumbnail", null);

                    nRes = reviewService.writeReview(paramMap);

                }

            }


            if (nRes > -1) {
                entity = new ResponseEntity("Success", HttpStatus.OK);
            }
        } catch (Exception e) {
            logger.error(e.toString(), e);
            entity = new ResponseEntity("FAIL", HttpStatus.EXPECTATION_FAILED);
        }
        return entity;

    }

    //
    //리뷰 조회
    @RequestMapping(value = "")
    public ModelAndView reviewSelect(@RequestParam HashMap<String, Object> paramMap, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();

        response.setContentType("image/jpeg");

        if (paramMap == null) {
            paramMap = new HashMap<>();
        }
        try {
            List<Map<String, Object>> resultList = reviewService.selectReview(paramMap);

            mav.addObject("reviews", resultList);
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }


        mav.setViewName("/review/review");
        return mav;

    }
//	
//	//리뷰 파일 넘버
//	@RequestMapping
//	public String reviewfilenoImpl() {
//		return null;
//		
//	}
//	
//	//리뷰 점수
//	@RequestMapping
//	public int reviewScore() {
//		return 0;
//
//	}
//	
//	//리뷰 날짜
//	@RequestMapping("")
//	public Date reviewDate() {
//		return null;
//		
//	}
//	
//	//리뷰 번호
//	@RequestMapping
//	public int reviewNo() {
//		return 0;
//	}
//
//	//리뷰 하트 점수
//	@RequestMapping
//	public int heartScore() {
//		return 0;
//	}
//	
//	//리뷰 항목
//	@RequestMapping("")
//	public ModelAndView reviewProduct() {
//		ModelAndView mav = new ModelAndView();
//		return mav;
//		
//	}


}
