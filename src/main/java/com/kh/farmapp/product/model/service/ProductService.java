package com.kh.farmapp.product.model.service;

import java.util.List;
import java.util.Map;

import common.dto.Basket;

public interface ProductService {

	/**
	 * 제철음식 top4 불러오기
	 * @return List
	 */
	public List<Map<String, Object>> selectSeasonTop();

	/**
	 * 일반음식 top4 불러오기
	 * @return List
	 */
	public List<Map<String, Object>> selectGeneralTop();

	/**
	 * 제철음식 리스트 목록
	 * @param cPage
	 * @param cntPerPage
	 * @param i 
	 * @return Map
	 */
	public Map<String, Object> selectSeasonList(int cPage, int cntPerPage, int isSeason);

	/**
	 * 검색
	 * @param cPage
	 * @param cntPerPage
	 * @param isSeasonalFood
	 * @param title
	 * @param filter
	 * @return Map<String, Object>
	 */
	public Map<String, Object> selectSeasonSearch(int cPage, int cntPerPage, int isSeasonalFood, String title,
			String filter);


	/**
	 * 일반음식 리스트 목록
	 * @param cPage
	 * @param cntPerPage
	 * @param isSeason
	 * @return
	 */
	public Map<String, Object> selectGeneralList(int cPage, int cntPerPage, int isSeason);

	/**
	 * 상품 상세보기
	 * @param productNo
	 * @return Map<String, Object>
	 */
	public Map<String, Object> selectProductDetail(int productNo);

	/**
	 * 장바구니 담기
	 * @param commandMap - 장바구니에 넣을 값들을 갖는 Map
	 * @return int
	 */
	public int insertBasket(Map<String, Object> commandMap);

	/**
	 * 옵션 리스트 찾기
	 * @param productNo
	 * @return
	 */
	public List<Map<String, Object>> selectProductOption(int productNo);


}
