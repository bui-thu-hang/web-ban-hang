package com.webbanhang.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webbanhang.converter.CategoryConverter;
import com.webbanhang.dto.CategoryDTO;
import com.webbanhang.entity.CategoryEntity;
import com.webbanhang.repository.CategoryRepository;
import com.webbanhang.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryConverter categoryConverter;
	
	@Override
	public Map<String, String> findAll() {
		Map<String, String> result = new HashMap<>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for (CategoryEntity item: entities) {
			result.put(item.getCategoryCode(), item.getCategoryName());
		}
		return result;
	}

	@Override
	public List<CategoryDTO> findAll(Pageable pageable) {
		List<CategoryDTO> categoryDTOs = new ArrayList<>();
		List<CategoryEntity> categoryentities = categoryRepository.findAll(pageable).getContent();
		for (CategoryEntity item: categoryentities) {
			CategoryDTO categoryDTO = categoryConverter.toDto(item);
			categoryDTOs.add(categoryDTO);
		}
		return categoryDTOs;
	}

	@Override
	public int getTotalItem() {
		return (int) categoryRepository.count();
	}

	@Override
	public CategoryDTO findById(long id) {
		CategoryEntity categoryEntity = categoryRepository.findOne(id);
		return categoryConverter.toDto(categoryEntity);
	}

	@Override
	@Transactional
	public CategoryDTO save(CategoryDTO categoryDTO) {
		CategoryEntity categoryEntity = new CategoryEntity();
		if (categoryDTO.getId() != null) {
			CategoryEntity oldCategory = categoryRepository.findOne(categoryDTO.getId());			
			categoryEntity = categoryConverter.toEntity(oldCategory, categoryDTO);
		} else {
			CategoryEntity newCategory = new CategoryEntity();
			categoryEntity = categoryConverter.toEntity(newCategory, categoryDTO);			
		}
		return categoryConverter.toDto(categoryRepository.save(categoryEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id: ids) {
			categoryRepository.delete(id);
		}
		
	}
}