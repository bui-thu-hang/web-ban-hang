package com.webbanhang.converter;

import org.springframework.stereotype.Component;

import com.webbanhang.dto.PayDetailDTO;
import com.webbanhang.entity.PayDetailEntity;
import com.webbanhang.entity.PayEntity;
import com.webbanhang.entity.ProductAddEntity;

@Component
public class PayDetailConverter {
	
	public PayDetailDTO toDto(PayDetailEntity entity) {
				
		PayDetailDTO payDetailDTO = new PayDetailDTO();
		payDetailDTO.setId(entity.getId());
		payDetailDTO.setNumber(entity.getNumber());
		payDetailDTO.setPaycode(entity.getPay().getId());
		payDetailDTO.setPrice(entity.getProductPrice());
		payDetailDTO.setCodeImg(entity.getCodeImg());
		payDetailDTO.setProductName(entity.getProductName());
				
		return payDetailDTO;
	}
	
	public PayDetailEntity toEntity(ProductAddEntity productAddEntity ,PayEntity  payEntity) {
		PayDetailEntity payDetailEntity = new PayDetailEntity();
		payDetailEntity.setNumber(productAddEntity.getNumberAdd());
		payDetailEntity.setProductName(productAddEntity.getProductadd().getProductName());
		payDetailEntity.setProductPrice(productAddEntity.getProductadd().getProductPrice());
		payDetailEntity.setCodeImg(productAddEntity.getProductadd().getCodeImg());						
		payDetailEntity.setPay(payEntity);		
		return payDetailEntity;
	}
	
	public PayDetailEntity toEntityAdmin(PayDetailDTO payDetailDTO,PayDetailEntity  payDetailEntity ,PayEntity payEntity) {
		payDetailEntity.setNumber(payDetailDTO.getNumber());
		payDetailEntity.setProductName(payDetailDTO.getProductName());
		payDetailEntity.setProductPrice(payDetailDTO.getPrice());
		payDetailEntity.setCodeImg(payDetailDTO.getCodeImg());						
		payDetailEntity.setPay(payEntity);		
		return payDetailEntity;
	}


}
