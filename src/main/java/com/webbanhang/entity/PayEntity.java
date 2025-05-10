package com.webbanhang.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pay")
public class PayEntity extends BaseEntity{
	
	@Column
	private Long status;
	
	@Column(name = "totalprice")
	private Long totalPrice;
	
	@Column
	private String address;

	@Column
	private Long phone;
	
	@Column
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userpay;

	@OneToMany(mappedBy = "pay", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<PayDetailEntity> payDetails = new ArrayList<>();
	
	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
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

	public UserEntity getUserpay() {
		return userpay;
	}

	public void setUserpay(UserEntity userpay) {
		this.userpay = userpay;
	}

	public List<PayDetailEntity> getPayDetails() {
		return payDetails;
	}

	public void setPayDetails(List<PayDetailEntity> payDetails) {
		this.payDetails = payDetails;
	}
	
	
}
