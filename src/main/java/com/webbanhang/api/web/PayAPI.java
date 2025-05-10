package com.webbanhang.api.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webbanhang.dto.PayDTO;
import com.webbanhang.dto.ProductAddDTO;
import com.webbanhang.service.IPayDetailService;
import com.webbanhang.service.IPayService;
import com.webbanhang.service.IProductAddService;
import com.webbanhang.util.SecurityUtils;

@RestController(value = "payAPIOfWeb")
public class PayAPI {

	@Autowired
	private IProductAddService productAddService;	
	
	@Autowired
	private IPayService payService;
	
	@Autowired
	private IPayDetailService payDetailService;
	
	@PostMapping("/api/pay")
	public PayDTO createPay(@RequestBody PayDTO payDTO) {		
		
		List<ProductAddDTO> productAddDTOs = new ArrayList<>();
		productAddDTOs = productAddService.findAll(SecurityUtils.getPrincipal().getId());
		Long total = (long)0;
		for (ProductAddDTO productAddDTO : productAddDTOs) {
			total =  productAddDTO.getNumberAdd() * productAddDTO.getProductPrice();
		}
		payDTO.setTotalPrice(total);
		payDTO = payService.save(payDTO, SecurityUtils.getPrincipal().getId()) ;			
		payDetailService.save(payDTO);
		
		long[] ids = new long [productAddDTOs.size()];
		for (int i = 0; i < ids.length; i++) {
			ids[i] = productAddDTOs.get(i).getId();
		}
		productAddService.delete(ids);
		//return null;
		return payDTO;  
	}
}
//SecurityUtils.getPrincipal().getId(): nhớ thêm vào findAll dòng

/*
package com.webbanhang.api.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webbanhang.dto.PayDTO;
import com.webbanhang.dto.ProductAddDTO;
import com.webbanhang.service.IPayDetailService;
import com.webbanhang.service.IPayService;
import com.webbanhang.service.IProductAddService;

@RestController(value = "payAPIOfWeb")
public class PayAPI {

    @Autowired
    private IProductAddService productAddService;  

    @Autowired
    private IPayService payService;

    @Autowired
    private IPayDetailService payDetailService;

    @PostMapping("/api/pay")
    public PayDTO createPay(@RequestBody PayDTO payDTO) {

        // Lấy userId từ payDTO (nếu có)
        Long userId = payDTO.getUserId();
        if (userId == null) {
            throw new RuntimeException("Thiếu userId trong request.");
        }

        // Lấy danh sách sản phẩm trong giỏ hàng
        List<ProductAddDTO> productAddDTOs = productAddService.findAll(userId);

        // Tính tổng tiền
        long total = 0L;
        for (ProductAddDTO productAddDTO : productAddDTOs) {
            total += productAddDTO.getNumberAdd() * productAddDTO.getProductPrice();
        }

        // Gán tổng tiền và lưu đơn hàng
        payDTO.setTotalPrice(total);
        payDTO = payService.save(payDTO, userId);
        payDetailService.save(payDTO);

        // Xoá giỏ hàng sau khi thanh toán
        long[] ids = new long[productAddDTOs.size()];
        for (int i = 0; i < productAddDTOs.size(); i++) {
            ids[i] = productAddDTOs.get(i).getId();
        }
        productAddService.delete(ids);

        return payDTO;
    }
}
*/

