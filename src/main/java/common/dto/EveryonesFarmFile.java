package common.dto;

/**
 * 
 * 업로드된 파일의 정보를 저장하는 테이블(하나의 테이블로 관리합니다.)
 * (하지만 user_profile 테이블은 따로 뒀어요!)
 */
public class EveryonesFarmFile {
	
	// member field
	private int fileNo;
	private String originName;
	private String fileRename;
	private String savePath;
	private int isThumbnail;
	private int boardNo;
	private int postNo;
	
	// toString()
	@Override
	public String toString() {
		return "EveryonesFarmFile [fileNo=" + fileNo + ", originName=" + originName + ", fileRename=" + fileRename
				+ ", savePath=" + savePath + ", isThumbnail=" + isThumbnail + ", boardNo=" + boardNo + ", postNo="
				+ postNo + "]";
	}

	// getter(), setter()
	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getFileRename() {
		return fileRename;
	}

	public void setFileRename(String fileRename) {
		this.fileRename = fileRename;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public int getIsThumbnail() {
		return isThumbnail;
	}

	public void setIsThumbnail(int isThumbnail) {
		this.isThumbnail = isThumbnail;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

}
