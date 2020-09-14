package com.kh.farmapp.mypage.farmer.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import common.dto.Application;
import common.dto.FarmActivity;
import common.dto.FarmDiary;
import common.dto.Farmer;
import common.dto.FarmingDailylog;
import common.dto.page.Criteria;

public interface FarmerMypageService {

	//게시글 작성
//	public void write(BoardVo boardVo);
	
	/**
	 * 영농일지 작성
	 * @param farmingDailylog - 영농일지 작성 정보를 저장하고 있는 FarmingDailylog 객체
	 */
	public void writeDailylog(FarmingDailylog farmingDailylog);
	/**
	 * 영농일지 목록 조회
	 * @param farmer 
	 * @return List<FarmingDailylog> - 조회 결과 반환
	 */
	public List<Map<String, Object>>  dailyLoglist(Criteria cri, Farmer farmer);
	

	/**
	 * 영농일지 총 갯수
	 * @param scri 페이지 수 
	 * @return istCount(SearchCriteria scri) - 총 갯수
	 */
	public int listCount();
	
<<<<<<< HEAD
=======
	
	//영농일지 상세페이지
	public FarmingDailylog read(int dailyLogNo);
	
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
	/**
	 * 활동 신청내역 리스트 조회
	 * @param cri
<<<<<<< HEAD
	 * @return
	 */
	public List<Map<String, Object>> activitylist(Criteria cri);
=======
	 * @param farmer 
	 * @return 
	 * @return
	 */
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
	
	
	public List<Map<String, Object>> activitylist(Criteria cri, Farmer farmer);

	/**
	 * 활동내역 총 갯수
	 * @param scri 페이지 수 
	 * @return istCount(SearchCriteria scri) - 총 갯수
	 */
	public int listCount2(Farmer farmer);

	/**
	 * 일손 체험 신청내역 리스트 조회
	 * @param cri
	 * @param farmer 
	 * @return 
	 */
	public List<Map<String, Object>> activitylist3(Criteria cri, Farmer farmer);
	
	/**
<<<<<<< HEAD
    * service
    * @param application
    * @return
    */
   public int updateIsApproval(Application application);
=======
	 * 일손 체험 내역 총 갯수
	 * @param cri 페이지 수
	 * @return listCount3(SearchCriteria scri) -총 갯수
	 */ 
	public int listCount3(Farmer farmer);
	
	
	
	/**
    * service
    * @param application 승인 신청 0 or 1 업데이트
    * @return dto 반환
    */
   public int updateIsApproval(Application application);
   
   
   /**
    * 판매 내역 리스트 user테이블과 order테이블 엮기
    * @param  cri 페이지 수
 * @param farmer 
    * @return 
    */
   public List<Map<String, Object>> selllist(Criteria cri, Farmer farmer);
   
   /**
    * 결제 처리 
    * @param order 결제 처리 0 or 1 업데이트
    * @return
    */
   public int updatePayment(TBOrder order);

   // 영농일지 데이트눌렀을때 리스트
   public List<Map<String, Object>> datelist(String date);

   
   //판매 내역 페이징 총 갯수
   public int listCount4(Farmer farmer);
   
   
 

   
   
   
   
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
	
   
	//게시물 조회
//	public BoardVo read(int bno);
	
	//게시글 삭제
//	public void delete(int bno);
	//게시글 수정
//	public void update(BoardVo boardVo);
}
