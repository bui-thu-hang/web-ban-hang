package com.webbanhang.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.webbanhang.dto.PayDTO;
import com.webbanhang.dto.PayDetailDTO;

public interface IPayDetailService {

	List<PayDetailDTO> findAll(Pageable pageable);
	int getTotalItem();
	PayDetailDTO findById(long id);
	PayDetailDTO save(PayDetailDTO payDetailDTO);
	void delete(long[] ids);
	
//	web
	List<PayDetailDTO> findAllByPay(Long id);
	PayDTO save(PayDTO payDTO);
}
