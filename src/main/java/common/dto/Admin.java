package common.dto;

/**
 * 관리자 정보 DTO
 */
public class Admin {
	
	// member field
	// 관리자 번호
	private int adminNo;
	// 관리자 아이디
	private String adminId;
	// 관리자 비밀번호
	private String adminPw;

	@Override
	public String toString() {
		return "Admin [adminNo=" + adminNo + ", adminId=" + adminId + ", adminPw=" + adminPw + "]";
	}

	public int getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(int adminNo) {
		this.adminNo = adminNo;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

}
