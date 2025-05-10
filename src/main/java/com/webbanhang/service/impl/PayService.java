package com.webbanhang.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webbanhang.converter.PayConverter;
import com.webbanhang.dto.PayDTO;
import com.webbanhang.entity.PayEntity;
import com.webbanhang.entity.UserEntity;
import com.webbanhang.repository.PayRepository;
import com.webbanhang.repository.UserRepository;
import com.webbanhang.service.IPayService;

@Service
public class PayService implements IPayService{

	@Autowired
	private PayRepository payRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PayConverter payConverter;
	
	@Override
	public List<PayDTO> findAll(Pageable pageable) {
		List<PayDTO> payDTOs = new ArrayList<>();
		List<PayEntity> payentities = payRepository.findAll(pageable).getContent();
		for (PayEntity item: payentities) {
			PayDTO payDTO = payConverter.toDto(item);
			payDTOs.add(payDTO);
		}
		return payDTOs;
	}

	@Override
	public int getTotalItem() {
		return (int) payRepository.count();
	}
	
	@Override
	public PayDTO findById(long id) {
		PayEntity payEntity = payRepository.findOne(id);
		return payConverter.toDto(payEntity);
	}

	@Override
	@Transactional
	public PayDTO save(PayDTO payDTO) {
		UserEntity userEntity = userRepository.findOneByPhoneEmail(payDTO.getUserPhoneEmail());
		PayEntity payEntity = new PayEntity();
		if (payDTO.getId() != null) {
			PayEntity oldPay = payRepository.findOne(payDTO.getId());
			payEntity = payConverter.toEntity(payDTO, oldPay ,userEntity);
		} else {			
			payEntity = payConverter.toEntity(payDTO, payEntity ,userEntity);
		}
		
		return payConverter.toDto(payRepository.save(payEntity));
	}	

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id: ids) {
			payRepository.delete(id);
		}
	}
	
	@Override
	public Map<Long, Long> findAll() {
		Map<Long, Long> result = new HashMap<>();
		List<PayEntity> entities = payRepository.findAll();
		for (PayEntity item: entities) {
			PayDTO payDTO = payConverter.toDto(item);
			result.put(payDTO.getPaycode(), item.getId());
		}
		return result;
	}

//	web
	@Override
	@Transactional
	public PayDTO save(PayDTO payDTO, Long userId) {		
		PayEntity payEntity = new PayEntity();	
		UserEntity  userEntity = userRepository.findOne(userId);		
		payEntity = payConverter.toEntity(payDTO, payEntity, userEntity);
		return payConverter.toDto(payRepository.save(payEntity));
	}
	
	@Override
	public List<PayDTO> findAllWeb(Long userId) {		
		List<PayDTO> payDTOs = new ArrayList<>();
		List<PayEntity> payentities = payRepository.findAll();
		for (PayEntity item: payentities) {	
			if (item.getUserpay().getId() == userId) {
			   PayDTO payDTO = payConverter.toDto(item);
			   payDTOs.add(payDTO);
			}
		}
		return payDTOs;
	}	

}
