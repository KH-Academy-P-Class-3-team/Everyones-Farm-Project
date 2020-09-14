package common.dto;

public class Purchase {
	// member field
	private int purchaseNo;
	private int userNo;
	private int farmerNo;
	private int productNo; // 꼭 필요한 컬럼일까요?
	private int optionNo;
	private int basketNo;
	@Override
	public String toString() {
		return "Purchase [purchaseNo=" + purchaseNo + ", userNo=" + userNo + ", farmerNo=" + farmerNo + ", productNo="
				+ productNo + ", optionNo=" + optionNo + ", basketNo=" + basketNo + "]";
	}
	public int getPurchaseNo() {
		return purchaseNo;
	}
	public void setPurchaseNo(int purchaseNo) {
		this.purchaseNo = purchaseNo;
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
	public int getBasketNo() {
		return basketNo;
	}
	public void setBasketNo(int basketNo) {
		this.basketNo = basketNo;
	}
	
	
	

}
