package common.dto;

/**
 * 일반 회원 정보 DTO
 */
public class UserTB {

	// member field
	// 일반 회원 번호
	private int userNo;
	// 일반 회원 아이디
	private String userId;
	// 일반 회원 비밀번호
	private String userPw;
	// 일반 회원 이름
	private String userName;
	// 일반 회원 이메일
	private String email;
	// 일반 회원 전화번호
	private String phone;
	// 일반 회원 탈퇴 여부
	private int isLeave;
	// 일반 회원 활동 정지 여부
	private int isPause;
	// 우편번호
	private String zonecode;
	// 도로명 주소
	private String firstAddress;
	// 상세 주소
	private String secondAddress;
	
	// toString()
	@Override
	public String toString() {
		return "UserTB [userNo=" + userNo + ", userId=" + userId + ", userPw=" + userPw + ", userName=" + userName
				+ ", email=" + email + ", phone=" + phone + ", isLeave=" + isLeave + ", isPause=" + isPause
				+ ", zoneCode=" + zonecode + ", firstAddress=" + firstAddress + ", secondAddress=" + secondAddress
				+ "]";
	}
	
	// getter(), setter()
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getIsLeave() {
		return isLeave;
	}
	public void setIsLeave(int isLeave) {
		this.isLeave = isLeave;
	}
	public int getIsPause() {
		return isPause;
	}
	public void setIsPause(int isPause) {
		this.isPause = isPause;
	}
	public String getZoneCode() {
		return zonecode;
	}
	public void setZoneCode(String zoneCode) {
		this.zonecode = zoneCode;
	}
	public String getFirstAddress() {
		return firstAddress;
	}
	public void setFirstAddress(String firstAddress) {
		this.firstAddress = firstAddress;
	}
	public String getSecondAddress() {
		return secondAddress;
	}
	public void setSecondAddress(String secondAddress) {
		this.secondAddress = secondAddress;
	}

	

}
