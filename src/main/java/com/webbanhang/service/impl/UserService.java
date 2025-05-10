package com.webbanhang.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webbanhang.converter.UserConverter;
import com.webbanhang.dto.UserDTO;
import com.webbanhang.entity.RoleEntity;
import com.webbanhang.entity.UserEntity;
import com.webbanhang.repository.RoleRepository;
import com.webbanhang.repository.UserRepository;
import com.webbanhang.service.IUserService;
import com.webbanhang.util.CheckCartUtil;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private CheckCartUtil checkCartUtil;
	
	@Override
	public List<UserDTO> findAll(Pageable pageable) {
		List<UserDTO> usersDTOs = new ArrayList<>();
		List<UserEntity> userentities = userRepository.findAll(pageable).getContent();
		for (UserEntity item: userentities) {
				UserDTO usersDTO = userConverter.toDto(item);
				usersDTOs.add(usersDTO);
		}
		return usersDTOs;
	}
			
	@Override
	public int getTotalItem() {
		return (int) userRepository.count();
	}

	@Override
	public UserDTO findById(long id) {
		UserEntity userEntity = userRepository.findOne(id);
		return userConverter.toDto(userEntity);
	}

	@Override
	@Transactional
	public UserDTO save(UserDTO userDTO) {
		
		String password = userDTO.getPassWord();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		if (userDTO.getId() == null)
		userDTO.setPassWord(hashedPassword);
		
		RoleEntity roleEntity = roleRepository.findOneByRoleCode(userDTO.getRoleCode());
		UserEntity userEntity = new UserEntity();
		if (userDTO.getId() != null) {
			UserEntity oldProduct = userRepository.findOne(userDTO.getId());
			oldProduct.setRole(roleEntity);
			userEntity = userConverter.toEntity(oldProduct, userDTO);
		} else {
			UserEntity newProduct = new UserEntity();
			userEntity = userConverter.toEntity(newProduct, userDTO);
			userEntity.setRole(roleEntity);
		}
		return userConverter.toDto(userRepository.save(userEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id: ids) {
			userRepository.delete(id);
		}		
	}

	@Override
	public Map<String, String> findAll() {
		Map<String, String> result = new HashMap<>();
		List<UserEntity> entities = userRepository.findAll();
		for (UserEntity item: entities) {
			result.put(item.getPhoneEmail(), item.getUserName());
		}
		return result;
	}

	@Override
	@Transactional
	public UserDTO saveLogin(UserDTO userDTO) {
		
		if (checkCartUtil.checkUser(userDTO)) {
			userDTO.setTru("khong");
			return userDTO;
		} else {
			String password = userDTO.getPassWord();
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(password);
			userDTO.setPassWord(hashedPassword);						
		    RoleEntity roleEntity = roleRepository.findOneByRoleCode("USER");
		    UserEntity userEntity = new UserEntity();		
		    userDTO.setStatus(0);
			userEntity = userConverter.toEntity(userEntity, userDTO);
			userEntity.setRole(roleEntity);	
		   return userConverter.toDto(userRepository.save(userEntity));
		}
			
			
	}

	@Override
	public List<UserDTO> findAllAd() {
		List<UserDTO> usersDTOs = new ArrayList<>();
		List<UserEntity> userentities = userRepository.findAll();
		for (UserEntity item: userentities) {
				UserDTO usersDTO = userConverter.toDto(item);
				usersDTOs.add(usersDTO);
		}
		return usersDTOs;
	}

}
