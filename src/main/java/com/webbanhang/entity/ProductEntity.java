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
@Table(name = "product")
public class ProductEntity extends BaseEntity {
	
	@Column(name = "productname")
	private String productName;
	
	@Column(name = "productcode")
	private String productCode;
	
	@Column(name = "productprice")
	private Long productPrice;
	
	@Column(name = "codeimg")
	private String codeImg;
	
	@Column(name = "productpriceOld")
	private Long productPriceOld;
	
	@Column(name = "productcontent", columnDefinition = "TEXT")
	private String productContent;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
	
	@OneToMany(mappedBy = "product", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<CommentEntity> comments = new ArrayList<>();
	
	@OneToMany(mappedBy = "productadd", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<ProductAddEntity> productAdds = new ArrayList<>();
	
	
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

	public String getProductContent() {
		return productContent;
	}

	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	public List<ProductAddEntity> getProductAdds() {
		return productAdds;
	}

	public void setProductAdds(List<ProductAddEntity> productAdds) {
		this.productAdds = productAdds;
	}
	
}
