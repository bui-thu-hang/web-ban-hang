package com.webbanhang.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.webbanhang.dto.ProductAddDTO;

public interface IProductAddService {
//  web
	ProductAddDTO save(Long productId, Long userId);
	List<ProductAddDTO> findAll(Long userId);	
	void delete(long[] ids);
	ProductAddDTO savePay(ProductAddDTO dto);
//	ad
	List<ProductAddDTO> findAll(Pageable pageable);
	int getTotalItem();
	ProductAddDTO findById(long id);
	ProductAddDTO save(ProductAddDTO dto);
	
}
