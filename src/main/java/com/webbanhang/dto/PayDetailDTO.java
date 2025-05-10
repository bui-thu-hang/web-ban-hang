package com.webbanhang.dto;

public class PayDetailDTO extends AbstractDTO<PayDetailDTO>{

	private Long productAddId;
	private Long number;					
	private Long paycode;
	private Long price;
	private String codeImg;
	private String productName;
	
	
	
	public Long getProductAddId() {
		return productAddId;
	}
	public void setProductAddId(Long productAddId) {
		this.productAddId = productAddId;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public Long getPaycode() {
		return paycode;
	}
	public void setPaycode(Long paycode) {
		this.paycode = paycode;
	}	
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}	
	public String getCodeImg() {
		return codeImg;
	}
	public void setCodeImg(String codeImg) {
		this.codeImg = codeImg;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
}
