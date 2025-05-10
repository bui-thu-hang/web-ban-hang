package com.webbanhang.controller.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webbanhang.dto.PayDTO;
import com.webbanhang.dto.ProductAddDTO;
import com.webbanhang.service.IPayDetailService;
import com.webbanhang.service.IPayService;
import com.webbanhang.service.IProductAddService;
import com.webbanhang.service.IUserService;
import com.webbanhang.util.SecurityUtils;

@Controller(value = "payControllerOfWeb")
public class PayController {
	
	@Autowired
	private IPayService payService;	

	@Autowired
	private IPayDetailService payDetailService;
	
	@Autowired
	private IProductAddService productAddService;	
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/buying", method = RequestMethod.GET)
	public ModelAndView buyPage(HttpServletRequest request) {	
		ModelAndView mav = new ModelAndView("web/bill");		
	    mav.addObject("models",productAddService.findAll(SecurityUtils.getPrincipal().getId()));
	    mav.addObject("userDTO", userService.findById(SecurityUtils.getPrincipal().getId()));
		return mav;	
		}	
	
	
	@RequestMapping(value = "/thanh-toan", method = RequestMethod.GET)
	public ModelAndView payPage(@RequestParam(value = "name", required = false) String name, 
			                    @RequestParam(value = "phone", required = false) Long phone,
			                    @RequestParam(value = "address", required = false) String address) {		
		ModelAndView mav = new ModelAndView("web/pay");	
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();	
		if (authentication.getName().equals("anonymousUser")) {					
			return new ModelAndView("redirect:/dang-nhap?login=hoaDon");									
		}else {
			if (name != null && phone != null && address != null) {				
				List<ProductAddDTO> productAddDTOs = new ArrayList<>();
				productAddDTOs = productAddService.findAll(SecurityUtils.getPrincipal().getId());
				if (productAddDTOs.size() != 0) {
					Long total = (long)0;
					for (ProductAddDTO productAddDTO : productAddDTOs) {
						total =  productAddDTO.getNumberAdd() * productAddDTO.getProductPrice();
					}
					PayDTO payDTO = new PayDTO();
					payDTO.setTotalPrice(total);
					payDTO.setName(name);
					payDTO.setPhone(phone);
					payDTO.setAddress(address);		
					payDTO = payService.save(payDTO, SecurityUtils.getPrincipal().getId()) ;			
					payDetailService.save(payDTO);
					
					long[] ids = new long [productAddDTOs.size()];
					for (int i = 0; i < ids.length; i++) {
						ids[i] = productAddDTOs.get(i).getId();						
				    } 	
					productAddService.delete(ids);
				}
				
			}							
			mav.addObject("models",payService.findAllWeb(SecurityUtils.getPrincipal().getId()));			
			return mav;	
		}	
	}

}
