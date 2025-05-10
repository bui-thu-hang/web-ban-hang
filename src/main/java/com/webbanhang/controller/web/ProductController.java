package com.webbanhang.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webbanhang.service.IProductService;

@Controller(value = "productControllerOfWeb")
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@RequestMapping(value = "/san-pham", method = RequestMethod.GET)
	public ModelAndView productPage(@RequestParam(value = "category", required = false) String category,
			                        @RequestParam(value = "up", required = false) Long up,
			                        @RequestParam(value = "down", required = false) Long down,			
			                        @RequestParam(value = "name", required = false) String name) {		
		ModelAndView mav = new ModelAndView("web/product");	
		if (name != null) {	
			mav.addObject("model", productService.Search(name));
			category = productService.Search(name).get(0).getCategoryCode();
		}else if (category.equals("sp-xuong-khop")) {
			if (up != null && down != null && up > down) {
				mav.addObject("model", productService.findAllWebUD(category ,up ,down));
			}else {
				mav.addObject("model", productService.findAllWeb1());	
			}			
		}else if(category.equals("sp-dai-trang")) {
			if (up != null && down != null && up > down) {
				mav.addObject("model", productService.findAllWebUD(category ,up ,down));
			}else {
				mav.addObject("model", productService.findAllWeb2());	
			}				
		}else if(category.equals("sp-nao")) {
			if (up != null && down != null && up > down) {
				mav.addObject("model", productService.findAllWebUD(category ,up ,down));
			}else {
				mav.addObject("model", productService.findAllWeb3());	
			}				
		}	
		mav.addObject("category", category);
	    return mav;			
		
	}
}
