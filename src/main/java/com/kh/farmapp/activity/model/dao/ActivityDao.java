package com.kh.farmapp.activity.model.dao;

import java.util.List;
import java.util.Map;

import common.dto.Application;
import common.dto.EveryonesFarmFile;
import common.dto.Farm;
import common.dto.FarmActivity;
import common.dto.FarmActivitySchedule;
import common.dto.Farmer;

public interface ActivityDao {

	/**전체 체험활동 조회 및 검색
	 * 
	 * @param map - 페이징 객체, 활동 구분, 검색 조건을 담은 Map
	 * @return List<Map<String, Object> - 조회된 체험 리스트 
	 */
	public List<Map<String, Object>> selectActivityList(Map<String, Object> map);
	
	/**페이징을 위해 전체 FarmActivity Count
	 * 
	 * @return int - count 결과 값
	 */
	public int selectActivityCnt(Map<String, Object> map);
	
	
	/**전체 활동 파일 썸네일 조회
	 * 
	 * @return List<EveryonesFarmFile> - 활동 파일 썸네일 리스트 
	 */
	public List<EveryonesFarmFile> selectActivityFileThumbnail();
	
	
	/**활동 상세 정보 조회
	 * 
	 * @param activityNo - 조회할 활동 번호
	 * @return FarmActivity - 조회한 활동 정보를 담은 객체
	 */
	public Map<String, Object> selectActivityDetail(int activityNo);
	
	
	/**활동 파일 정보 조회
	 * 
	 * @param activityNo - 조회할 파일의 활동 번호
	 * @return List<EveryonesFarmFile> - 조회한 파일 정보를 담은 객체
	 */
	public List<EveryonesFarmFile> selectActivityFileWithActivity(int activityNo);
	
	
	/**입력한 신청서 저장
	 * 
	 * @param application - 사용자가 입력한 신청 정보
	 * @return int - 저장 결과
	 */
	public int insertApplication(Application application);


	/**체험 활동 등록
	 * 
	 * @param farmActivity - 체험 활동 정보
	 * @return int - 등록 결과
	 */
	public int insertActivity(FarmActivity farmActivity);

	
	/**농부 번호로 농장 정보 조회
	 * 
	 * @param farmer - 농부 정보
	 * @return Farm - 농장 정보를 담은 객체
	 */
	public Farm selectFarmByFarmerNo(Farmer farmer);

	
	/**농장 번호로 체험 활동 목록 조회
	 * 
	 * @param farm - 농장 정보
	 * @return List<FarmActivity> - 조회된 체험 활동 리스트
	 */
	public List<FarmActivity> selectActivityListByFarmNo(Farm farm);


	/**체험 활동 관련 파일 등록
	 * 
	 * @param data - 파일 정보를 담은 Map
	 */
	public int insertFile(EveryonesFarmFile activityFile);


	/**체험 활동 일정 정보 등록
	 * 
	 * @param schedule - 체험 활동 일정 정보를 담은 객체
	 */
	public int insertActivitySchedule(FarmActivitySchedule schedule);


	/**농장 전체 목록 조회
	 * 
	 * @return List<Farm> - 조회된 농장 목록
	 */
	public List<Farm> selectFarmList();


	/**체험 번호로 일정 조회
	 * 
	 * @param activityNo - 조회할 체험 번호
	 * @return List<FarmActivitySchedule> - 조회된 일정 목록
	 */
	public List<FarmActivitySchedule> selectScheduleByActivityNo(int activityNo);


	/**활동 번호로 체험 활동 조회
	 * 
	 * @param activityNo
	 * @return FarmActivity - 조회된 체험 활동 객체 
	 */
	public FarmActivity selectActivityByActivityNo(int activityNo);


	/**체험 활동 삭제
	 * 
	 * @param activityNo - 삭제될 체험 번호
	 * @return int - 삭제 결과
	 */
	public int deleteActivity(int activityNo);


	/**체험 활동 이미지 삭제
	 * 
	 * @param activityNo - 삭제될 파일의 체험 번호
	 * @return int - 삭제 결과
	 */
	public int deleteActivityFile(int activityNo);

	
	/**
	 * 농장 번호로 농장 조회
	 * @param farmNo - 조회할 농장 번호
	 * @return Farm - 조회된 농장 정보
	 */
	public Farm selectFarmByFarmNo(int farmNo);


	
	
}
