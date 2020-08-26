package common.dto;

import java.util.Date;

public class FarmDiary {

	private int farmDiaryNo;
	private String title;
	private int hit;
	private Date enrollDate;
	private String youtubeLink;
	private String content;
	private int farmerNo;
	
	@Override
	public String toString() {
		return "FarmDiary [farmDiaryNo=" + farmDiaryNo + ", title=" + title + ", hit=" + hit + ", enrollDate="
				+ enrollDate + ", youtubeLink=" + youtubeLink + ", content=" + content + ", farmerNo=" + farmerNo + "]";
	}

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

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
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
