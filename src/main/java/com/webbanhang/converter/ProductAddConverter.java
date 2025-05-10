package com.webbanhang.converter;

import org.springframework.stereotype.Component;

import com.webbanhang.dto.ProductAddDTO;
import com.webbanhang.entity.ProductAddEntity;
import com.webbanhang.entity.ProductEntity;
import com.webbanhang.entity.UserEntity;

@Component
public class ProductAddConverter {

	public ProductAddDTO toDto(ProductAddEntity entity) {
		ProductAddDTO productAddDTO = new ProductAddDTO();
		productAddDTO.setId(entity.getId());
		productAddDTO.setProductName(entity.getProductadd().getProductName());
		productAddDTO.setNumberAdd(entity.getNumberAdd());
		productAddDTO.setCodeImg(entity.getProductadd().getCodeImg());
		productAddDTO.setProductPrice(entity.getProductadd().getProductPrice());		
		productAddDTO.setUserPhoneEmail(entity.getUseradd().getPhoneEmail()); 
		productAddDTO.setUserName(entity.getUseradd().getUserName());
		productAddDTO.setProductId(entity.getProductadd().getId());
		productAddDTO.setProductCode(entity.getProductadd().getProductCode());             
		return productAddDTO;
	}
	
	public ProductAddEntity toBetweenEntity(ProductEntity entity, ProductAddEntity productAddEntity, UserEntity  userEntity) {
				
		productAddEntity.setNumberAdd((long) 1);
		productAddEntity.setUseradd(userEntity);
		productAddEntity.setProductadd(entity);
		return productAddEntity;
	}
}
