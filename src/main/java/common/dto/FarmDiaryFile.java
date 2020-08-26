package common.dto;

public class FarmDiaryFile {

	// member field
	private int farmDiaryFileNo;
	private String originName;
	private String fileRename;
	private String savePath;
	private int farmDiaryNo;
	private int isThumbnail;

	// getter(), setter()
	public int getFarmDiaryFileNo() {
		return farmDiaryFileNo;
	}
	public void setFarmDiaryFileNo(int farmDiaryFileNo) {
		this.farmDiaryFileNo = farmDiaryFileNo;
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
	public int getFarmDiaryNo() {
		return farmDiaryNo;
	}
	public void setFarmDiaryNo(int farmDiaryNo) {
		this.farmDiaryNo = farmDiaryNo;
	}
	public int getIsThumbnail() {
		return isThumbnail;
	}
	public void setIsThumbnail(int isThumbnail) {
		this.isThumbnail = isThumbnail;
	}

	// toString()
	@Override
	public String toString() {
		return "FarmDiaryFile [farmDiaryFileNo=" + farmDiaryFileNo + ", originName=" + originName + ", fileRename="
				+ fileRename + ", savePath=" + savePath + ", farmDiaryNo=" + farmDiaryNo + ", isThumbnail="
				+ isThumbnail + "]";
	}
	
}
