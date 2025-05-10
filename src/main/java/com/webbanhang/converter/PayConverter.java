package com.webbanhang.converter;

import org.springframework.stereotype.Component;

import com.webbanhang.dto.PayDTO;
import com.webbanhang.entity.PayEntity;
import com.webbanhang.entity.UserEntity;

@Component
public class PayConverter {
	
	public PayDTO toDto(PayEntity entity) {
		PayDTO payDTO = new PayDTO();						
		payDTO.setId(entity.getId());
		payDTO.setStatus(entity.getStatus());
		if (entity.getStatus()==0) {
			payDTO.setStatusName("Chưa thanh toán");
		} else {
			payDTO.setStatusName("Đã thanh toán");
		}
		payDTO.setTotalPrice(entity.getTotalPrice());
		payDTO.setAddress(entity.getAddress());
		payDTO.setPhone(entity.getPhone());
		payDTO.setName(entity.getName());
		payDTO.setPaycode(entity.getId());
		payDTO.setUserName(entity.getUserpay().getUserName());
		payDTO.setUserPhoneEmail(entity.getUserpay().getPhoneEmail());
		payDTO.setDatePay(entity.getCreatedDate());
		return payDTO;
	}
	
	public PayEntity toEntity(PayDTO payDTO, PayEntity payEntity, UserEntity  userEntity) {		
		
		if (payDTO.getStatus() == null) {
			payEntity.setStatus((long) 0);
		} else {
			payEntity.setStatus(payDTO.getStatus());
		}
//		payEntity.setTotalPrice(payDTO.getTotalPrice());
//		payEntity.setAddress(payDTO.getAddress());
//		payEntity.setPhone(payDTO.getPhone());
//		payEntity.setName(payDTO.getName());
//		payEntity.setUserpay(userEntity);				
		return payEntity;
		
	}

}
