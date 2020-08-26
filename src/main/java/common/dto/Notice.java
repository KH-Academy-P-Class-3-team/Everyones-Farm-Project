package common.dto;

/**
 * 공지사항 & 자주 묻는 질문 정보를 저장하는 테이블
 */
public class Notice {

	// member field
	// 공지사항 & 자주 묻는 질문 번호
	private int noticeNo;
	// 제목
	private String title;
	// 내용
	private String content;
	// 공지사항인지 여부를 판단해 주는 컬럼
	private int isNotice;

	// toString()
	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", title=" + title + ", content=" + content + ", isNotice=" + isNotice
				+ "]";
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

	public int getIsNotice() {
		return isNotice;
	}

	public void setIsNotice(int isNotice) {
		this.isNotice = isNotice;
	}

}
