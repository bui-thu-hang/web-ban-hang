package com.webbanhang.dto;

public class UserDTO extends AbstractDTO<UserDTO>{

    private String userName;
    private String fullName;
	private String passWord;	
	private String phoneEmail;
	private Integer status;
	private String statusName;	
	private Long roleId;
	private String roleCode;
	
	private String tru;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}		
	public String getPhoneEmail() {
		return phoneEmail;
	}
	public void setPhoneEmail(String phoneEmail) {
		this.phoneEmail = phoneEmail;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}	
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getTru() {
		return tru;
	}
	public void setTru(String tru) {
		this.tru = tru;
	}
	
	
}
