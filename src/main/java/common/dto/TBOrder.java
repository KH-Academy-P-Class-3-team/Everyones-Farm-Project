package common.dto;

import java.util.Date;

public class TBOrder {

	// member field
	private int orderNo;
	private int optionNo;
	private int userNo;
	private int farmerNo;
	private Date orderDate;
	private int paymentStatus;
	private int paymentPrice;
	private String zonecode;
	private String firstAddress;
	private String secondAddress;
	private int orderAmount;
	
	// getter(), setter()
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getOptionNo() {
		return optionNo;
	}
	public void setOptionNo(int optionNo) {
		this.optionNo = optionNo;
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
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public int getPaymentPrice() {
		return paymentPrice;
	}
	public void setPaymentPrice(int paymentPrice) {
		this.paymentPrice = paymentPrice;
	}
	public String getZonecode() {
		return zonecode;
	}
	public void setZonecode(String zonecode) {
		this.zonecode = zonecode;
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
	
	public int getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	// toString()
	@Override
	public String toString() {
		return "TBOrder [orderNo=" + orderNo + ", optionNo=" + optionNo + ", userNo=" + userNo + ", farmerNo="
				+ farmerNo + ", orderDate=" + orderDate + ", paymentStatus=" + paymentStatus + ", paymentPrice="
				+ paymentPrice + ", zonecode=" + zonecode + ", firstAddress=" + firstAddress + ", secondAddress="
				+ secondAddress + ", orderAmount=" + orderAmount + "]";
	}

}
