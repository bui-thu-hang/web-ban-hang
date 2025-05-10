package com.webbanhang.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webbanhang.dto.PayDTO;
import com.webbanhang.service.IPayService;


@RestController(value = "payAPIOfAdmin")
public class PayAPI {
	
	@Autowired
	private IPayService payService;
	
	@PostMapping("/api/payAmin")
	public PayDTO createPay(@RequestBody PayDTO payDTO) {
		return payService.save(payDTO);		
	}
	
	@PutMapping("/api/payAmin")
	public PayDTO updatePay(@RequestBody PayDTO payDTO) {
		return payService.save(payDTO);
	}
	
	@PutMapping("/api/payAdmin/{id}")
	public PayDTO updatePay(@PathVariable Long id, @RequestBody PayDTO payDTO) {
	    payDTO.setId(id); // Gán id từ URL vào DTO
	    return payService.save(payDTO);
	}


	@DeleteMapping("/api/payAmin")
	public void deletePay(@RequestBody long[] ids) {
		payService.delete(ids);
	}

}
