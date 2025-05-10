package com.webbanhang.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webbanhang.dto.CategoryDTO;
import com.webbanhang.service.ICategoryService;

@RestController(value = "categoryAPIOfAdmin")
public class CategoryAPI {

	@Autowired
	private ICategoryService categoryService;
	
	@PostMapping("/api/category")
	public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
		return categoryService.save(categoryDTO);
	}
	
	@PutMapping("/api/category")
	public CategoryDTO updateCategory(@RequestBody CategoryDTO categoryDTO) {
		return categoryService.save(categoryDTO);
	}
	
	@DeleteMapping("/api/category")
	public void deleteCategory(@RequestBody long[] ids) {	
		categoryService.delete(ids);
	}
	
}
