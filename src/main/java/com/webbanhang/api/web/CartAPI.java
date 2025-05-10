package com.webbanhang.api.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.webbanhang.dto.ProductAddDTO;
import com.webbanhang.service.IProductAddService;
import com.webbanhang.util.SecurityUtils;


@RestController(value = "cartAPIOfWeb")
public class CartAPI {

	@Autowired
	private IProductAddService productAddService;
	
	@PostMapping("/api/productAdd")
	public long createProductAdd(@RequestBody long id) {						
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();	
		if (authentication.getName().equals("anonymousUser")) {					
			return id;									
		}else {						
				productAddService.save(id, SecurityUtils.getPrincipal().getId());	
				return id;								
		}									
	}
	
	@PutMapping("/api/productAdd")
	public Object[] createPay(HttpServletRequest request, @RequestBody Object[] objects) {		
		Gson son = new Gson();
		if (objects.length > 0) {		   
			for (int i = 0; i < objects.length; i++) {
				ProductAddDTO productAddDTO = son.fromJson(objects[i]+"", ProductAddDTO.class);
				productAddService.savePay(productAddDTO);				
			} 		      		
		}
		return objects;	
	}
	
	@DeleteMapping("/api/productAdd")
	public void deleteProductAdd(@RequestBody long[] ids) {
		productAddService.delete(ids);
	}
}
