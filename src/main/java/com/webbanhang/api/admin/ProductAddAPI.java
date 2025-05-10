package com.webbanhang.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webbanhang.dto.ProductAddDTO;
import com.webbanhang.service.IProductAddService;

@RestController(value = "productAddAPIOfAdmin")
public class ProductAddAPI {
	
	@Autowired
	private IProductAddService productAddService;
	
	@PostMapping("/api/productAddAmin")
	public ProductAddDTO createProductAdd(@RequestBody ProductAddDTO productAddDTO) {
		return productAddService.save(productAddDTO);
		
	}
	
	@PutMapping("/api/productAddAmin")
	public ProductAddDTO updateProductAdd(@RequestBody ProductAddDTO productAddDTO) {
		return productAddService.save(productAddDTO);
	}
	
	@DeleteMapping("/api/productAddAmin")
	public void deleteProductAdd(@RequestBody long[] ids) {
		productAddService.delete(ids);
	}

}
