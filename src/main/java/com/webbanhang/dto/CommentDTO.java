package com.webbanhang.dto;

public class CommentDTO extends AbstractDTO<CommentDTO>{
		
	private String commentContent;	
	private Long productId;
	private Long userId;
	private String userName;	
	private String userPhoneEmail;
	private String productName;
	private String productCode;
	
	
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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

	
}
