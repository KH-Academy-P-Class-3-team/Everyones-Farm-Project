package common.util.upload.img.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.dto.EveryonesFarmFile;

/**
 * 
 * 업로드 된 이미지에 대한 정보를 테이블에 저장
 */
@Repository
public class CkImageUploadDaoImpl implements CkImageUploadDao{

	// mapper 와 연결해 주는 SqlSessionTemplate 객체 DI
	@Autowired
	SqlSessionTemplate session;
	
	// 업로드 된 이미지 테이블에 저장
	@Override
	public int insertFile(EveryonesFarmFile fileDto) {
		return session.insert("COMMONIMAGEUPLOAD.insertFile", fileDto);
	}

	// 업로드 된 이미지 테이블에서 삭제
	@Override
	public int deleteFile(Map<String, Object> deleteConfig) {
		return session.insert("COMMONIMAGEUPLOAD.deleteFile", deleteConfig);
	}
	
	// 삭제할 이미지 정보들을 조회
	@Override
	public List<EveryonesFarmFile> selectFilesByBoardNoAdnPostNo(Map<String, Object> deleteConfig) {
		return session.selectList("COMMONIMAGEUPLOAD.selectFilesByBoardNoAdnPostNo", deleteConfig);
	}

}
