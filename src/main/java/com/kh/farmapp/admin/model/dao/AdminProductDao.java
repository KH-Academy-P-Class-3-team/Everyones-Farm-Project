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
	 * 판매 상품의 productSas 컬럼을 update 한다.
	 * @param approve - 승인될 Product 객체
	 * @return int - update 결과
	 */
	public int updateProductSas(Product approve);

	/**
	 * 판매 상품의 productSas 컬럼을 update 한다.
	 * @param cancel - 보류(반려)될 Product 객체
	 * @return int - update 결과
	 */
	public int updateProductSasIsCancel(Product cancel);

	/**
	 * 조회된 판매상품의 갯수
	 * 
	 * @param search - 검색어
	 * @return int - 조회 결과
	 */
	public int selectCntAllProduct(String search);

}
