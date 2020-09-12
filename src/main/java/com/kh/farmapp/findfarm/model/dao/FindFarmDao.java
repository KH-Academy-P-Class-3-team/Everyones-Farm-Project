package com.kh.farmapp.findfarm.model.dao;

import java.util.List;
import java.util.Map;

import common.dto.EveryonesFarmFile;
import common.dto.Farm;
import common.util.Paging;

public interface FindFarmDao {
	
	/**농장 목록 조회
	 * 
	 * @param map - 검색어, 페이징 객체를 담고있는 Map
	 * @return List<Map<String, Object> - 조회된 농장 리스트
	 */
	public List<Map<String, Object>> selectFarmList(Map<String, Object> map);
	
	
	/**전체 농장 파일 리스트 조회
	 * 
	 * @return List<FarmFile> - 전체 파일 리스트
	 */
	public List<EveryonesFarmFile> selectFarmFileList();
	
	
	/**전체 농장 수 조회
	 * 
	 * @return int - 전체 농장 수
	 */
//	public int selectFarmCnt();
	
	public int selectFarmCnt(Map<String, Object> map);


}
