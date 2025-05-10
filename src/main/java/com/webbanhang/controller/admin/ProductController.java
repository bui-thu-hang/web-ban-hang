package com.webbanhang.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webbanhang.dto.ProductDTO;
import com.webbanhang.service.ICategoryService;
import com.webbanhang.service.IProductService;
import com.webbanhang.util.MessageUtil;

@Controller(value = "productControllerOfAdmin")
public class ProductController {
	
	@Autowired
	private IProductService productService;

	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/quan-tri/san-pham/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, 
								 @RequestParam("limit") int limit, HttpServletRequest request) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setPage(page);
		productDTO.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/product/list");
		Pageable pageable = new PageRequest(page - 1, limit);
		productDTO.setListResult(productService.findAll(pageable));
		productDTO.setTotalItem(productService.getTotalItem());
		productDTO.setTotalPage((int) Math.ceil((double) productDTO.getTotalItem() / productDTO.getLimit()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", productDTO);
		return mav;
	}
	
	
	@RequestMapping(value = "/quan-tri/san-pham/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/product/edit");
		ProductDTO productDTO = new ProductDTO();
		if (id != null) {
			productDTO = productService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("categories", categoryService.findAll());
		mav.addObject("model", productDTO);
		return mav;
	}
}

/*package com.webbanhang.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.webbanhang.dto.ProductDTO;
import com.webbanhang.service.IProductService;

@RestController
@RequestMapping("/api/admin/product")
public class   ProductController{

    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    public ProductDTO getAllProducts(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        ProductDTO result = new ProductDTO();
        result.setPage(page);
        result.setLimit(limit);
        Pageable pageable = new PageRequest(page - 1, limit);

        result.setListResult(productService.findAll(pageable));
        result.setTotalItem(productService.getTotalItem());
        result.setTotalPage((int) Math.ceil((double) result.getTotalItem() / result.getLimit()));
        return result;
    }
    @GetMapping("/detail")
    public ProductDTO getProductById(@RequestParam("id") Long id) {
        return productService.findById(id);
    }

}
*/