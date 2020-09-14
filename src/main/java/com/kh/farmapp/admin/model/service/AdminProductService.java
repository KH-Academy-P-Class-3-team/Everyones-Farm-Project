package com.kh.farmapp.admin.model.service;

import java.util.List;
import java.util.Map;

import common.dto.Product;
import common.util.AdminPaging;

/**
 * 상품 관리 페이지의 Service interface
 */
public interface AdminProductService {

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
	public int approveProduct(Product approve);
	
	/**
	 * 판매 상품의 productSas 컬럼을 update 한다.
	 * @param cancel - 보류(반려)될 Product 객체
	 * @return int - update 결과
	 */
	public int putProductOnHold(Product cancel);

	/**
	 * 판매상품 리스트 불러오기
	 * 
	 * @param pagingConfig - 페이징 설정 정보를 갖는 Map
	 * @return AdminPaging - 설정 페이징 결과 반환
	 */
	public AdminPaging getPaging(Map<String, Object> pagingConfig);
	
}
