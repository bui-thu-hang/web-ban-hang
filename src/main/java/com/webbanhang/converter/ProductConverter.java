package com.webbanhang.converter;

import org.springframework.stereotype.Component;

import com.webbanhang.dto.ProductDTO;
import com.webbanhang.entity.ProductEntity;

@Component
public class ProductConverter {

	public ProductDTO toDto(ProductEntity entity) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(entity.getId());
		productDTO.setProductName(entity.getProductName());
		productDTO.setProductCode(entity.getProductCode());
		productDTO.setProductPrice(entity.getProductPrice());
		productDTO.setCodeImg(entity.getCodeImg());
		productDTO.setProductPriceOld(entity.getProductPriceOld());
        productDTO.setCategoryCode(entity.getCategory().getCategoryCode());
		productDTO.setProductContent(entity.getProductContent());
		return productDTO;
	}
	
	public ProductEntity toEntity(ProductEntity entity, ProductDTO dto) {		
		entity.setProductName(dto.getProductName());
		entity.setProductCode(dto.getProductCode());
		entity.setProductPrice(dto.getProductPrice());
		entity.setCodeImg(dto.getCodeImg());
		entity.setProductPriceOld(dto.getProductPriceOld());
		entity.setProductContent(dto.getProductContent());
		return entity;
	}
}