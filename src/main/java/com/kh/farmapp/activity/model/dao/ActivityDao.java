package com.kh.farmapp.activity.model.dao;

import java.util.List;
import java.util.Map;

import common.dto.Application;
import common.dto.Farm;
import common.dto.FarmActivity;
import common.dto.FarmActivityFile;
import common.dto.FarmActivitySchedule;
import common.dto.Farmer;
import common.util.Paging;

public interface ActivityDao {

	/**전체 활동 리스트 조회
	 * 
	 * @param map - 페이징 객체, 활동 구분을 담은 Map
	 * @return List<FarmActivity> - 체험활동/일손돕기 전체 리스트 
	 */
	public List<FarmActivity> selectActivityList(Map<String, Object> map);
	
	
	/**전체 활동 파일 리스트 조회
	 * 
	 * @return List<FarmActivityFile> - 활동 파일 전체 리스트 
	 */
	public List<FarmActivityFile> selectActivityFileThumbnail();
	
	
	/**활동 상세 정보 조회
	 * 
	 * @param activityNo - 조회할 활동 번호
	 * @return FarmActivity - 조회한 활동 정보를 담은 객체
	 */
	public FarmActivity selectActivityDetail(int activityNo);
	
	
	/**활동 파일 정보 조회
	 * 
	 * @param activityNo - 조회할 파일의 활동 번호
	 * @return List<Map<String, String>> - 조회한 파일 정보를 담은 객체
	 */
	public List<Map<String, String>> selectFileWithActivity(int activityNo);
	
	
	/**체험 활동 검색
	 * 
	 * @param map - 페이징 변수, 검색어(활동명)를 담은 매개변수
	 * @return FarmActivity - 검색 결과(활동) 정보 반환
	 */
	public List<FarmActivity> selectActivityByTitle(Map<String, Object> map);
	
	
	/**체험 활동 검색 결과 수 조회
	 * 
	 * @return int - 검색 결과 개수
	 */
	public int selectActivityByTitleCnt(Map<String, Object> map);
	
	
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
	public int insertFile(FarmActivityFile activityFile);


	/**체험 활동 일정 정보 등록
	 * 
	 * @param schedule - 체험 활동 일정 정보를 담은 객체
	 */
	public int insertActivitySchedule(FarmActivitySchedule schedule);


	/**페이징을 위해 전체 FarmActivity Count
	 * 
	 * @return int - count 결과 값
	 */
	public int selectActivityCnt(int isHelp);


	/**농장 전체 목록 조회
	 * 
	 * @return List<Farm> - 조회된 농장 목록
	 */
	public List<Farm> selectFarmList();


	/**농장명으로 활동 검색
	 * 
	 * @param map - 페이징 객체, 검색어(농장명)를 담은 Map
	 * @return List<FarmActivity> - 검색 결과 리스트
	 */
	public List<FarmActivity> selectActivityByFarmName(Map<String, Object> map);


	/**농장명으로 검색한 활동 목록 수
	 * 
	 * @param map - 검색어
	 * @return int - 검색 결과 개수
	 */
	public int selectActivityByFarmNameCnt(Map<String, Object> map);


	
	
}
