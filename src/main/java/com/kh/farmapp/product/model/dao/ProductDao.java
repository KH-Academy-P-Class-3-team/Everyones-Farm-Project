package com.kh.farmapp.product.model.dao;

import java.util.List;
import java.util.Map;

import common.dto.Basket;
import common.dto.EveryonesFarmFile;
import common.dto.Product;
import common.util.Paging;

public interface ProductDao {

	/**
	 * 제철음식 top 뽑기
	 * @return List
	 */
	public List<Map<String, Object>> selectSeasonTop();

	/**
	 * 일반음식 top 뽑기
	 * @return List
	 */
	public List<Map<String, Object>> selectGeneralTop();

	/**
	 * 제철음식 게시글 수
	 * @return int
	 */
	public int selectSeasonCnt();
	
	/**
	 * 제철음식 게시글 목록
	 * @param p
	 * @return List
	 */
	public List<Product> selectSeasonList(Paging p);

	/**
	 * 파일 리스트
	 * @return List<EveryonesFarmFile>
	 */
	public List<EveryonesFarmFile> selectSeasonFileThumbnail();

	/**
	 * 제철 상품 이름으로 찾은 수
	 * @param map
	 * @return int 개수
	 */
	public int selectSeasonByTitleCnt(Map<String, Object> map);

	/**
	 * 제철 상품 이름으로 검색
	 * @param map
	 * @return List<Product>
	 */
	public List<Product> selectSeasonSearchByTitle(Map<String, Object> map);

	/**
	 * 제철 상품 종류로 찾은 수
	 * @param map
	 * @return int 개수
	 */
	public int selectSeasonByKindCnt(Map<String, Object> map);

	/**
	 * 제철 상품 종류로 검색
	 * @param map
	 * @return List<Product>
	 */
	public List<Product> selectSeasonSearchByKind(Map<String, Object> map);

	/**
	 * 일반음식 게시글 수
	 * @return int
	 */
	public int selectGeneralCnt();

	/**
	 * 일반음식 게시글 목록
	 * @param p
	 * @return List<Product>
	 */
	public List<Product> selectGeneralList(Paging p);

	/**
	 * 일반음식 사진 검색
	 * @return List<EveryonesFarmFile>
	 */
	public List<EveryonesFarmFile> selectGeneralFileThumbnail();

	/**
	 * 일반 음식 상세보기
	 * @param productNo
	 * @return Map<String, Object>
	 */
	public Map<String, Object> selectGeneralDetail(int productNo);

	/**
	 * 일반 음식 사진 파일
	 * @param productNo
	 * @return List<EveryonesFarmFile>
	 */
	public List<EveryonesFarmFile> selectProductFileWithGeneral(int productNo);

	/**
	 * 상품 상세보기
	 * @param productNo
	 * @return Map<String, Object>
	 */
	public Map<String, Object> selectProductDetail(int productNo);

	/**
	 * 상품 파일 찾기
	 * @param productNo
	 * @return List<EveryonesFarmFile>
	 */
	public List<EveryonesFarmFile> selectProductFile(int productNo);

	/**
	 * 장바구니 담기
	 * @param commandMap - 장바구니 테이블에 넣을 데이터를 갖는 Map
	 * @return int
	 */
	public int insertBasket(Map<String, Object> commandMap);


}
