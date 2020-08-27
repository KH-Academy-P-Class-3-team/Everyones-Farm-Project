package common.dto;

public class ProductFile {
	
	// member field
	private int fileNo;
	private int productNo;
	private String originName;
	private String fileRename;
	private String savePath;
	private int isThumbnail;
	
	// toString()
	@Override
	public String toString() {
		return "ProductFile [fileNo=" + fileNo + ", productNo=" + productNo + ", originName=" + originName
				+ ", fileRename=" + fileRename + ", savePath=" + savePath + ", isThumbnail=" + isThumbnail + "]";
	}

	// getter(), setter()
	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
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
	
}
