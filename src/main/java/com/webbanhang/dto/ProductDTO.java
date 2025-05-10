package com.webbanhang.dto;

public class ProductDTO extends AbstractDTO<ProductDTO> {
	
	private String productName;
	private String productCode;
	private Long productPrice;
	private String codeImg;
	private Long productPriceOld;
	private Long categoryId;
	private String productContent;
	private String categoryCode;
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
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
	public Long getProductPriceOld() {
		return productPriceOld;
	}
	public void setProductPriceOld(Long productPriceOld) {
		this.productPriceOld = productPriceOld;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getProductContent() {
		return productContent;
	}
	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	
	
}