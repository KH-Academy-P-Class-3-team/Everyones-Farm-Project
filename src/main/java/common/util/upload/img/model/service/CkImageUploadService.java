package common.util.upload.img.model.service;

import java.util.List;
import java.util.Map;

import common.dto.EveryonesFarmFile;

public interface CkImageUploadService {

	/**
	 * 업로드 된 이미지 저장
	 * 
	 * @param fileDto - insert 할 파일 정보를 갖는 EveryonesFarmFile 객체
	 * @return int - insert 결과
	 */
	public int insertFile(EveryonesFarmFile fileDto);

	/**
	 * 업로드 된 파일 테이블에서 삭제
	 * 
	 * @param deleteConfig - 삭제할 파일에 대한 정보를 갖는 Map
	 * @return int - delete 결과
	 */
	public int deleteFile(Map<String, Object> deleteConfig);

	/**
	 * 삭제 할 파일들 조회
	 * 
	 * @param deleteConfig - 파일을 조회하기 위한 정보를 갖는 Map(boardNo, postNo)
	 * @return List<EveryonesFarmFile> - 조회 결과 반환
	 */
	public List<EveryonesFarmFile> selectFilesByBoardNoAndPostNo(Map<String, Object> deleteConfig);


}
