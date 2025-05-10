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
@Table(name = "user")
public class UserEntity extends BaseEntity {
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "fullname")
	private String fullName;
	
	@Column(name = "password")
	private String passWord;

	@Column(name = "phoneemail")
	private String phoneEmail;
	
	@Column
	private Integer status;	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private RoleEntity role;	
	
	@OneToMany(mappedBy = "user", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<CommentEntity> comments = new ArrayList<>();
	
	@OneToMany(mappedBy = "useradd", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<ProductAddEntity> productAdd = new ArrayList<>();
	
	@OneToMany(mappedBy = "userpay", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<PayEntity> pays = new ArrayList<>();
	
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

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	public List<ProductAddEntity> getProductAdd() {
		return productAdd;
	}

	public void setProductAdd(List<ProductAddEntity> productAdd) {
		this.productAdd = productAdd;
	}

	public List<PayEntity> getPays() {
		return pays;
	}

	public void setPays(List<PayEntity> pays) {
		this.pays = pays;
	}
	
	
}