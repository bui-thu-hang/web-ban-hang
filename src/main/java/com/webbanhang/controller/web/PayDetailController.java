package com.webbanhang.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webbanhang.service.IPayDetailService;

@Controller(value = "payDetailControllerOfWeb")
public class PayDetailController {
	
	@Autowired
	private IPayDetailService payDetailService;	

	@RequestMapping(value = "/hoa-don-detail", method = RequestMethod.GET)
	public ModelAndView payPage(@RequestParam(value = "id", required = false) Long id) {		
		ModelAndView mav = new ModelAndView("web/payDetail");			
		if (id != null) {
			mav.addObject("models",payDetailService.findAllByPay(id) );
		}					
			return mav;		
	}
}
