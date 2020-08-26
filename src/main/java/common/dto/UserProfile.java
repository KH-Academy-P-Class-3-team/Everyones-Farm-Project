package common.dto;

public class UserProfile {

	// member field
	private int profileNo;
	private int userNo;
	private String originName;
	private String fileRename;
	private String savePath;
	
	// toString()
	@Override
	public String toString() {
		return "UserProfile [profileNo=" + profileNo + ", userNo=" + userNo + ", originName=" + originName
				+ ", fileRename=" + fileRename + ", savePath=" + savePath + "]";
	}

	// getter(), setter()
	public int getProfileNo() {
		return profileNo;
	}

	public void setProfileNo(int profileNo) {
		this.profileNo = profileNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
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

}
