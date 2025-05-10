package com.webbanhang.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.webbanhang.dto.PayDTO;

public interface IPayService {

	List<PayDTO> findAll(Pageable pageable);
	int getTotalItem();	
	PayDTO findById(long id);
	PayDTO save(PayDTO payDTO);
	void delete(long[] ids);
	Map<Long, Long> findAll();
	
//	web
	PayDTO save(PayDTO payDTO, Long userId);
	List<PayDTO> findAllWeb(Long userId);
	
}
