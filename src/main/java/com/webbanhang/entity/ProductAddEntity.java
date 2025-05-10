package com.webbanhang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productadd")
public class ProductAddEntity extends BaseEntity {
	
		
	@Column(name = "numberadd")
	private Long numberAdd;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity useradd;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductEntity productadd;
	
		

	public Long getNumberAdd() {
		return numberAdd;
	}

	public void setNumberAdd(Long numberAdd) {
		this.numberAdd = numberAdd;
	}

	public UserEntity getUseradd() {
		return useradd;
	}

	public void setUseradd(UserEntity useradd) {
		this.useradd = useradd;
	}

	public ProductEntity getProductadd() {
		return productadd;
	}

	public void setProductadd(ProductEntity productadd) {
		this.productadd = productadd;
	}
	
	
}