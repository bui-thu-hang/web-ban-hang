package com.webbanhang.dto;

import java.util.Date;

public class PayDTO extends AbstractDTO<PayDTO>{
	
	private Long status;
	private String statusName;	
	private Long totalPrice;
	private String address;
	private Long phone;
	private String name;
	private Long paycode;
	private String userName;	
	private String userPhoneEmail;
	private Date datePay;
	 private Long userId;// được thêm vào sau có thể xoá 
	
	public Long getStatus() {
		return status;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setStatus(Long status) {
		this.status = status;
	}	
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public Long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPaycode() {
		return paycode;
	}
	public void setPaycode(Long paycode) {
		this.paycode = paycode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhoneEmail() {
		return userPhoneEmail;
	}
	public void setUserPhoneEmail(String userPhoneEmail) {
		this.userPhoneEmail = userPhoneEmail;
	}
	public Date getDatePay() {
		return datePay;
	}
	public void setDatePay(Date datePay) {
		this.datePay = datePay;
	}	
	
}
