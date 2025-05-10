package com.webbanhang.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.webbanhang.dto.ProductDTO;

public interface IProductService {
	List<ProductDTO> findAll(Pageable pageable);
	List<ProductDTO> findAllWeb1();
	List<ProductDTO> findAllWeb2();
	List<ProductDTO> findAllWeb3();
	int getTotalItem();
	ProductDTO findById(long id);
	ProductDTO save(ProductDTO dto);
	void delete(long[] ids);
	List<ProductDTO> Search(String name);
	Map<String, String> findAll();
	List<ProductDTO> findAllWebUD(String category, Long up,Long down);
}
