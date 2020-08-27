package common.dto;

import java.util.Date;

public class Application {

	// member field
	private int applicationNo;
	private int activityNo;
	private int userNo;
	private String applicantName;
	private String applicantPhone;
	private String applicantEmail;
	private int people;
	private Date activityDate;
	private int isGroup;
	private int isApproval;

	// getter(), setter()
	public int getApplicationNo() {
		return applicationNo;
	}

	public void setApplicationNo(int applicationNo) {
		this.applicationNo = applicationNo;
	}

	public int getActivityNo() {
		return activityNo;
	}

	public void setActivityNo(int activityNo) {
		this.activityNo = activityNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getApplicantPhone() {
		return applicantPhone;
	}

	public void setApplicantPhone(String applicantPhone) {
		this.applicantPhone = applicantPhone;
	}

	public String getApplicantEmail() {
		return applicantEmail;
	}

	public void setApplicantEmail(String applicantEmail) {
		this.applicantEmail = applicantEmail;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	public int getIsGroup() {
		return isGroup;
	}

	public void setIsGroup(int isGroup) {
		this.isGroup = isGroup;
	}

	public int getIsApproval() {
		return isApproval;
	}

	public void setIsApproval(int isApproval) {
		this.isApproval = isApproval;
	}

	// toString()
	@Override
	public String toString() {
		return "Application [applicationNo=" + applicationNo + ", activityNo=" + activityNo + ", userNo=" + userNo
				+ ", applicantName=" + applicantName + ", applicantPhone=" + applicantPhone + ", applicantEmail="
				+ applicantEmail + ", people=" + people + ", activityDate=" + activityDate + ", isGroup=" + isGroup
				+ ", isApproval=" + isApproval + "]";
	}

}
