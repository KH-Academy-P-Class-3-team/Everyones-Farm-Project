package common.util.upload.img.model.dao;

import java.util.List;
import java.util.Map;

import common.dto.EveryonesFarmFile;

public interface CkImageUploadDao {

	/**
	 * 업로드 된 이미지 정보 테이블에 insert
	 *  
	 * @param fileDto - 업로드 된 이미지 정보를 갖는 EveryonesFarmFile 객체
	 * @return int - insert 결과
	 */
	public int insertFile(EveryonesFarmFile fileDto);

	/**
	 * 업로드 된 이미지 파일 테이블에서 delete
	 * 
	 * @param deleteConfig - 삭제할 이미지 파일에 대한 정보를 갖는 Map
	 * @return int - delete 결과
	 */
	public int deleteFile(Map<String, Object> deleteConfig);

	/**
	 * 삭제할  파일 들 조회
	 * 
	 * @param deleteConfig - 삭제할 파일들을 조회할 조건을 저장하고 있는 Map(postNo, boardNo)
	 * @return List<EveryonesFarmFile> - 조회 결과 반환
	 */
	public List<EveryonesFarmFile> selectFilesByBoardNoAdnPostNo(Map<String, Object> deleteConfig);

}
