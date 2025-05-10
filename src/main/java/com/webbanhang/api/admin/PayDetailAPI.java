package com.webbanhang.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webbanhang.dto.PayDetailDTO;
import com.webbanhang.service.IPayDetailService;

@RestController(value = "payDetailAPIOfAdmin")
public class PayDetailAPI {
	
	@Autowired
	private IPayDetailService payDetailService;
	
	@PostMapping("/api/payDetailAmin")
	public PayDetailDTO createPayDetail(@RequestBody PayDetailDTO payDetailDTO) {
		return payDetailService.save(payDetailDTO);
		
	}
	
	@PutMapping("/api/payDetailAmin")
	public PayDetailDTO updatePayDetail(@RequestBody PayDetailDTO payDetailDTO) {
		return payDetailService.save(payDetailDTO);
	}
	
	@DeleteMapping("/api/payDetailAmin")
	public void deleteProductAdd(@RequestBody long[] ids) {
		payDetailService.delete(ids);
	}

}
