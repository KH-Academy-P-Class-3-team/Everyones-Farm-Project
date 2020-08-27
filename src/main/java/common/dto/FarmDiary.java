package common.dto;

import java.util.Date;


public class FarmDiary {
	
	// member field
	private int farmDiaryNo;
	private String title;
	private int hits;
	private Date enrollDate;
	private String youtubeLink;
	private String content;
	private int farmerNo;
	
	// toString()
	@Override
	public String toString() {
		return "FarmDiary [farmDiaryNo=" + farmDiaryNo + ", title=" + title + ", hits=" + hits + ", enrollDate="
				+ enrollDate + ", youtubeLink=" + youtubeLink + ", content=" + content + ", farmerNo=" + farmerNo + "]";
	}

	// getter(), setter()
	public int getFarmDiaryNo() {
		return farmDiaryNo;
	}

	public void setFarmDiaryNo(int farmDiaryNo) {
		this.farmDiaryNo = farmDiaryNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getYoutubeLink() {
		return youtubeLink;
	}

	public void setYoutubeLink(String youtubeLink) {
		this.youtubeLink = youtubeLink;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getFarmerNo() {
		return farmerNo;
	}

	public void setFarmerNo(int farmerNo) {
		this.farmerNo = farmerNo;
	}

}
