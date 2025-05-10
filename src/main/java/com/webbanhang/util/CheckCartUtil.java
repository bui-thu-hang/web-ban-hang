package com.webbanhang.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webbanhang.dto.UserDTO;
import com.webbanhang.entity.ProductAddEntity;
import com.webbanhang.entity.UserEntity;
import com.webbanhang.repository.ProductAddRepository;
import com.webbanhang.repository.UserRepository;

@Component
public class CheckCartUtil {
	
	@Autowired
	private ProductAddRepository productAddRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public boolean check(Long productId, Long userId) {
		List<ProductAddEntity> productAddEntities = productAddRepository.findAll();		
		for (ProductAddEntity item: productAddEntities) {
			if (item.getProductadd().getId() == productId && item.getUseradd().getId() == userId) {
				return true;
			}
		}			
		return false;
		
	}
	
	public boolean checkUser(UserDTO userDTO) {
		List<UserEntity> userEntities = userRepository.findAll();		
		for (UserEntity item: userEntities) {
			if (item.getUserName().equals(userDTO.getUserName()) || item.getPhoneEmail().equals(userDTO.getPhoneEmail())) {
				return true;
			}
		}			
		return false;
		
	}

}
