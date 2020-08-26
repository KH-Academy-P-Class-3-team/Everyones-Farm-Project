package common.dto;

public class Basket {

	// member field
	private int basketNo;
	private int userNo;
	private int farmerNo;
	private int productNo; // 꼭 필요한 컬럼일까요?
	private int optionNo;
	
	// getter(), setter()
	public int getBasketNo() {
		return basketNo;
	}
	public void setBasketNo(int basketNo) {
		this.basketNo = basketNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getFarmerNo() {
		return farmerNo;
	}
	public void setFarmerNo(int farmerNo) {
		this.farmerNo = farmerNo;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public int getOptionNo() {
		return optionNo;
	}
	public void setOptionNo(int optionNo) {
		this.optionNo = optionNo;
	}

	// toString()
	@Override
	public String toString() {
		return "Basket [basketNo=" + basketNo + ", userNo=" + userNo + ", farmerNo=" + farmerNo + ", productNo="
				+ productNo + ", optionNo=" + optionNo + "]";
	}

}
