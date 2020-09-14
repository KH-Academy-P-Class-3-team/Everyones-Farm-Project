package com.kh.farmapp.admin.model.dao;

import java.util.List;
import java.util.Map;

import common.dto.Product;
import common.util.AdminPaging;

/**
 * 상품 관리 페이지의 Dao interface
 */
public interface AdminProductDao {

	/**
	 * 상품 관리 페이지에서 판매 상품 신청을 한 판매 상품 목록을 조회한다.
	 * @param apaging - 페이징 정보를 갖는 AdminPaging 객체
	 * 
	 * @return List<Map<String, Object>> - 조회 결과 반환
	 */
	public List<Map<String, Object>> selectAllProduct(AdminPaging apaging);

	/**
	 * 조회된 판매상품의 갯수
	 * 
	 * @param search - 검색어
	 * @return int - 조회 결과
	 */
	public int selectCntAllProduct(String search);

	/**
	 * 판매상품 승인
	 * 
	 * @param productNoList  - productNo 정보를 갖는 List
	 * @return int - update 결과
	 */
	public int approveProduct(List<String> productNoList);

	/**
	 * 판매 상품 보류
	 * 
	 * @param productNoList - productNo 정보를 갖는 List
	 * @return int - update 결과
	 */
	public int putProductOnHold(List<String> productNoList);

}
