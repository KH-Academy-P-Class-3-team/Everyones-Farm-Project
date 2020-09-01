package com.kh.farmapp.notice.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.dto.Notice;

/**
 * NoticeDao 를 상속 받는 클래스
 * NoticeDao 구현 클래스
 */
@Repository
public class NoticeDaoImpl implements NoticeDao{
	
	@Autowired
	private SqlSessionTemplate session;

	@Override
	public Notice selectOneNotice() {
		return session.selectOne("NOTICE.selectLatestNotice");
	}

}
