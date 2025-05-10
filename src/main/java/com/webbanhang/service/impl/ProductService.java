package com.webbanhang.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webbanhang.converter.ProductConverter;
import com.webbanhang.dto.ProductDTO;
import com.webbanhang.entity.CategoryEntity;
import com.webbanhang.entity.ProductEntity;
import com.webbanhang.repository.CategoryRepository;
import com.webbanhang.repository.ProductRepository;
import com.webbanhang.service.IProductService;

@Service
public class ProductService implements IProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductConverter productConverter;
	
	@Override
	public List<ProductDTO> findAll(Pageable pageable) {
		List<ProductDTO> productDTOs = new ArrayList<>();
		List<ProductEntity> productentities = productRepository.findAll(pageable).getContent();
		for (ProductEntity item: productentities) {
			ProductDTO productDTO = productConverter.toDto(item);
			productDTOs.add(productDTO);
		}
		return productDTOs;
		
	}

	@Override
	public List<ProductDTO> findAllWeb1() {
		List<ProductDTO> productDTOs = new ArrayList<>();
		List<ProductEntity> productentities = productRepository.findAll();
		for (ProductEntity item: productentities) {
			if (item.getCategory().getCategoryCode().equals("sp-xuong-khop")) {
				ProductDTO productDTO = productConverter.toDto(item);
				productDTOs.add(productDTO);
			}
		}
		return productDTOs;
	}
	@Override
	public List<ProductDTO> findAllWeb2() {
		List<ProductDTO> productDTOs = new ArrayList<>();
		List<ProductEntity> productentities = productRepository.findAll();
		for (ProductEntity item: productentities) {
			if (item.getCategory().getCategoryCode().equals("sp-dai-trang")) {
				ProductDTO productDTO = productConverter.toDto(item);
				productDTOs.add(productDTO);
			}
		}
		return productDTOs;
	}
	@Override
	public List<ProductDTO> findAllWeb3() {
		List<ProductDTO> productDTOs = new ArrayList<>();
		List<ProductEntity> productentities = productRepository.findAll();
		for (ProductEntity item: productentities) {
			if (item.getCategory().getCategoryCode().equals("sp-nao")) {
				ProductDTO productDTO = productConverter.toDto(item);
				productDTOs.add(productDTO);
			}
		}
		return productDTOs;
	}
	
	@Override
	public int getTotalItem() {
		return (int) productRepository.count();
	}

	@Override
	public ProductDTO findById(long id) {
		ProductEntity productEntity = productRepository.findOne(id);
		return productConverter.toDto(productEntity);
	}

	@Override
	@Transactional
	public ProductDTO save(ProductDTO productDTO) {
		CategoryEntity categoryEntity = categoryRepository.findOneByCategoryCode(productDTO.getCategoryCode());
		ProductEntity productEntity = new ProductEntity();
		if (productDTO.getId() != null) {
			ProductEntity oldProduct = productRepository.findOne(productDTO.getId());
			oldProduct.setCategory(categoryEntity);
			productEntity = productConverter.toEntity(oldProduct, productDTO);
		} else {			
			productEntity = productConverter.toEntity(productEntity, productDTO);
			productEntity.setCategory(categoryEntity);
		}
		return productConverter.toDto(productRepository.save(productEntity));
	}
	
	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id: ids) {
			productRepository.delete(id);
		}
	}

	@Override
	public List<ProductDTO> Search(String name) {
		List<ProductDTO> productDTOs = new ArrayList<>();
		List<ProductEntity> productentities = productRepository.findAll();
		for (ProductEntity item: productentities) {
			if (item.getProductContent().contains(name)) {
				ProductDTO productDTO = productConverter.toDto(item);
				productDTOs.add(productDTO);
			}
		}
		return productDTOs;		
	}

	@Override
	public Map<String, String> findAll() {
		Map<String, String> result = new HashMap<>();
		List<ProductEntity> entities = productRepository.findAll();
		for (ProductEntity item: entities) {
			result.put(item.getProductCode(), item.getProductName());
		}
		return result;
	}

	@Override
	public List<ProductDTO> findAllWebUD(String category, Long up, Long down) {
		List<ProductDTO> productDTOs = new ArrayList<>();
		List<ProductEntity> productentities = productRepository.findAll();
		for (ProductEntity item: productentities) {
			if (item.getCategory().getCategoryCode().equals(category) && item.getProductPrice() <= up  && item.getProductPrice() >= down) {
				ProductDTO productDTO = productConverter.toDto(item);
				productDTOs.add(productDTO);
			}
		}
		return productDTOs;
	}

	
}
