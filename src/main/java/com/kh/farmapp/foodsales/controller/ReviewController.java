package com.kh.farmapp.foodsales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.farmapp.foodsales.model.service.ReviewService;

import common.dto.Product;
import common.dto.Review;
import common.dto.ReviewFile;
import common.dto.UserTB;

@Controller
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	//리뷰 작성
//	@RequestMapping("")
//	public String reviewWrite(UserTB user, Product product) {
//		return null;
//	}
	
	//리뷰 삭제
//	@RequestMapping("")
//	public String reviewDelete(Review review) {
//		return null;
//	
//	}
	
	//리뷰 업데이트
//	@RequestMapping("")
//	public String reviewUpdate(UserTB user, Review review) {
//		return null;
//		
//	}
//	
<<<<<<< HEAD
	//리뷰 조회
//	@RequestMapping("")
//	public ModelAndView reviewSelect(Review review, UserTB user, Product product) {
//		ModelAndView mav = new ModelAndView();
//		return mav;
//		
//	}
=======
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

            //수정 필
//                    paramMap.put("reviewNo", "2");
            paramMap.put("productNo", "1");
            paramMap.put("content", content);

            paramMap.put("farmerNo", null);
            paramMap.put("userNo", null);
            paramMap.put("reviewScore", score);

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

                    // review file
                    paramMap.put("originName", originalFileName);
                    paramMap.put("fileReName", storedFileName);
                    paramMap.put("savePath", filePath);
                    paramMap.put("isThumbnail", null);

                    //  board no
                    paramMap.put("boardNo", 5);


                }

            }
            nRes = reviewService.writeReview(paramMap);


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
            mav.addObject("reviewsCnt", resultList.size());
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }


        mav.setViewName("/review/review");
        return mav;
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05

	//리뷰 삽입
//	@RequestMapping("")
//	public String reviewInsert(User user) {
//		return null;
//		
//	}
	
	//리뷰 파일 넘버
//	@RequestMapping
//	public String reviewfilenoImpl(ReviewFile reviewFile) {
//		return null;
//		
//	}
	
	//리뷰 점수
//	@RequestMapping
//	public int reviewScore(Review reivew, Product product) {
//		return 0;
//
//	}
	
//	//리뷰 날짜
//	@RequestMapping("")
//	public Date reviewDate() {
//		return null;
//		
//	}
	
	//리뷰 번호
//	@RequestMapping
//	public int reviewNo(ReviewFile reviewFile) {
//		return 0;
//	}

	//리뷰 하트 점수
//	@RequestMapping
//	public int heartScore(ReviewFile reviewFile, Product product, User user) {
//		return 0;
//	}
	
	//리뷰 항목
//	@RequestMapping("")
//	public ModelAndView reviewProduct(Review review, User user) {
//		ModelAndView mav = new ModelAndView();
//		return mav;
//		
//	}
	
}
