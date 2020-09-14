package com.kh.farmapp.findfarm.model.service;

import java.util.Map;

import common.dto.test.FarmSearchCriteria;

public interface FindFarmService {

	/**전체 농장 리스트 조회
	 * 
	 * @param currentPage, cntPerPage - 페이징 변수
	 * @param fsc - 검색어 설정을 담은 객체
	 * @return Map<Strint, Object> - 조회된 농장 리스트, 전체 농장 파일, 페이징 정보를 담은 Map
	 */
	public Map<String, Object> selectFarmList(int currentPage, int cntPerPage, FarmSearchCriteria fsc);
	
	
}
