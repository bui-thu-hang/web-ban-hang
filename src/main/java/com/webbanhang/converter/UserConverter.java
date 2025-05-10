package com.webbanhang.converter;

import org.springframework.stereotype.Component;

import com.webbanhang.dto.UserDTO;
import com.webbanhang.entity.UserEntity;

@Component
public class UserConverter {

	public UserDTO toDto(UserEntity entity) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(entity.getId());
		userDTO.setUserName(entity.getUserName());
		userDTO.setFullName(entity.getFullName());
		userDTO.setPassWord(entity.getPassWord());
		userDTO.setPhoneEmail(entity.getPhoneEmail());
		userDTO.setStatus(entity.getStatus());
		if (entity.getStatus()==0) {
			userDTO.setStatusName("Chưa duyệt người dùng");
		} else {
			userDTO.setStatusName("Đã duyệt người dùng");
		}
		userDTO.setRoleId(entity.getRole().getId());
		userDTO.setRoleCode(entity.getRole().getRoleCode());
		return userDTO;
	}
	
	public UserEntity toEntity(UserEntity entity, UserDTO dto) {	
		entity.setUserName(dto.getUserName());
		entity.setFullName(dto.getFullName());
		entity.setPassWord(dto.getPassWord());
		entity.setPhoneEmail(dto.getPhoneEmail());
		entity.setStatus(dto.getStatus());
		return entity;
	}
	
}
