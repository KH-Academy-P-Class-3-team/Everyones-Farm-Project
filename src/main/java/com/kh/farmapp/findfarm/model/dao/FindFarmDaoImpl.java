package com.kh.farmapp.findfarm.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.dto.EveryonesFarmFile;
import common.dto.Farm;
import common.util.Paging;

@Repository
public class FindFarmDaoImpl implements FindFarmDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<Map<String, Object>> selectFarmList(Map<String, Object> map) {
		return sqlSession.selectList("FINDFARM.selectFarmList", map);
	}

	@Override
	public List<EveryonesFarmFile> selectFarmFileList() {
		return sqlSession.selectList("FINDFARM.selectFarmFile");
	}

	@Override
	public int selectFarmCnt(Map<String, Object> map) {
		return sqlSession.selectOne("FINDFARM.selectFarmCnt", map);
	}
	
}
