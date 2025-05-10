package com.webbanhang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "paydetail")
public class PayDetailEntity extends BaseEntity{

	@Column
	private Long number;
	
	@Column(name = "productname")
	private String productName;
	
	@Column(name = "productprice")
	private Long productPrice;
	
	@Column(name = "codeimg")
	private String codeImg;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pay_id")
    private PayEntity pay;
	

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Long productPrice) {
		this.productPrice = productPrice;
	}

	public String getCodeImg() {
		return codeImg;
	}

	public void setCodeImg(String codeImg) {
		this.codeImg = codeImg;
	}

	public PayEntity getPay() {
		return pay;
	}

	public void setPay(PayEntity pay) {
		this.pay = pay;
	}
	
}
