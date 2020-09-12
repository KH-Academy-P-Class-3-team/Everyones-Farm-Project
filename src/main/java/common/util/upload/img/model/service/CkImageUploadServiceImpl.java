package common.util.upload.img.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.dto.EveryonesFarmFile;
import common.util.upload.img.model.dao.CkImageUploadDao;

/**
 * 
 * 이미지 업로드 정보를 저장할 함수를 호출하는 service
 */
@Service
public class CkImageUploadServiceImpl implements CkImageUploadService {

	// dao
	@Autowired
	private CkImageUploadDao ckImageUploadDao;
	
	// 업로드 된 이미지 파일 정보 insert
	@Override
	public int insertFile(EveryonesFarmFile fileDto) {
		return ckImageUploadDao.insertFile(fileDto);
	}

	// 업로드 된 이미지 파일 정보 delete
	@Override
	public int deleteFile(Map<String, Object> deleteConfig) {
		return ckImageUploadDao.deleteFile(deleteConfig);
	}

	// 삭제할 이미지 파일 조회
	@Override
	public List<EveryonesFarmFile> selectFilesByBoardNoAndPostNo(Map<String, Object> deleteConfig) {
		return ckImageUploadDao.selectFilesByBoardNoAdnPostNo(deleteConfig);
	}

}
