package common.dto;

import java.util.Date;

/**
 * 공지사항 & 자주 묻는 질문 정보를 저장하는 테이블
 */
public class Notice {

	// member field
	private int noticeNo;
	private String title;
	private String content;
	private int adminNo;
	private Date regDate;
	private int isShowed;
	
	// toString()
	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", title=" + title + ", content=" + content + ", adminNo=" + adminNo
				+ ", regDate=" + regDate + ", isShowed=" + isShowed + "]";
	}

	// getter(), setter()
	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(int adminNo) {
		this.adminNo = adminNo;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getIsShowed() {
		return isShowed;
	}

	public void setIsShowed(int isShowed) {
		this.isShowed = isShowed;
	}

}
