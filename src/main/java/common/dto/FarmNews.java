package common.dto;

import java.util.Date;

public class FarmNews {

	// member field
	// 농업 소식 번호
	private int farmNewsNo;
	// 농업 소식 제목
	private String title;
	// 농업 소식 데이터 출처 URL
	private String link;
	// 농업 소식 데이터 출처 사이트 이름
	private String siteName;
	// 농업 소식 데이터 등록일(그 사이트에서 작성된 날짜)
	private Date regDate;

	// getter(), setter()
	public int getFarmNewsNo() {
		return farmNewsNo;
	}

	public void setFarmNewsNo(int farmNewsNo) {
		this.farmNewsNo = farmNewsNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	// toString()
	@Override
	public String toString() {
		return "FarmNews [farmNewsNo=" + farmNewsNo + ", title=" + title + ", link=" + link + ", siteName=" + siteName
				+ ", regDate=" + regDate + "]";
	}

}
