
 package com.webbanhang.controller.web;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webbanhang.dto.ProductAddDTO;
import com.webbanhang.service.IProductAddService;
import com.webbanhang.util.MessageUtil;
import com.webbanhang.util.SecurityUtils;

@Controller(value = "cartControllerOfWeb")
public class CartController {
	
	@Autowired
	private IProductAddService productAddService;	

	@RequestMapping(value = "/gio-hang", method = RequestMethod.GET)
	public ModelAndView cartPage(@RequestParam(value = "id", required = false) Long productId) {
		ProductAddDTO productAddDTO = new ProductAddDTO();
		ModelAndView mav = new ModelAndView("web/cart");		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();	
		if (authentication.getName().equals("anonymousUser")) {					
			return new ModelAndView("redirect:/dang-nhap?login=dangNhap");									
		}else {	
			
			
		
			
			
			if (productId != null) {
				productAddService.save(productId, SecurityUtils.getPrincipal().getId());				
			}
			productAddDTO.setListResult(productAddService.findAll(SecurityUtils.getPrincipal().getId()));
			mav.addObject("model",productAddDTO );	
			return mav;	
		}
		
	}
}


