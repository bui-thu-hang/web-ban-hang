package com.webbanhang.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webbanhang.dto.ProductDTO;
import com.webbanhang.service.ICommentService;
import com.webbanhang.service.IProductService;

@Controller(value = "detailControllerOfWeb")
public class DetailController {

	@Autowired
	private IProductService productService;
	
	@Autowired
	private ICommentService commentService;
	
	@RequestMapping(value = "/chi-tiet", method = RequestMethod.GET)
	public ModelAndView detailPage(@RequestParam(value = "id", required = false) Long id) {
		ModelAndView mav = new ModelAndView("web/detail");
		ProductDTO productDTO = new ProductDTO();		
		if (id != null) {
			productDTO = productService.findById(id);		
		}		
		mav.addObject("comments", commentService.findAllByProductId(productDTO.getId()));
		mav.addObject("model", productDTO);
		return mav;
	}
	
}