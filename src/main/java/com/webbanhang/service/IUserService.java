package com.webbanhang.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.webbanhang.dto.UserDTO;

public interface IUserService {

	List<UserDTO> findAll(Pageable pageable);
	int getTotalItem();
	UserDTO findById(long id);
	UserDTO save(UserDTO dto);
	void delete(long[] ids);
	Map<String, String> findAll();
	UserDTO saveLogin(UserDTO dto);
	List<UserDTO> findAllAd();
}
