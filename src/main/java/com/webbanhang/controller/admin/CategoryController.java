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

import com.webbanhang.dto.CategoryDTO;
import com.webbanhang.service.ICategoryService;
import com.webbanhang.util.MessageUtil;

@Controller(value = "categoryControllerOfAdmin")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/quan-tri/the-loai/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, 
			                     @RequestParam("limit") int limit, HttpServletRequest request) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setPage(page);
		categoryDTO.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/category/list");
		Pageable pageable = new PageRequest(page - 1, limit);
		categoryDTO.setListResult(categoryService.findAll(pageable));
		categoryDTO.setTotalItem(categoryService.getTotalItem());
		categoryDTO.setTotalPage((int) Math.ceil((double) categoryDTO.getTotalItem() / categoryDTO.getLimit()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", categoryDTO);
		return mav;
	}	
	
	@RequestMapping(value = "/quan-tri/the-loai/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/category/edit");
		CategoryDTO categoryDTO = new CategoryDTO();
		if (id != null) {
			categoryDTO = categoryService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}		
		mav.addObject("model", categoryDTO);
		return mav;
	}
}

/*package com.webbanhang.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.webbanhang.dto.CategoryDTO;
import com.webbanhang.service.ICategoryService;

@RestController // ✅ Đổi từ @Controller sang @RestController để trả JSON
@RequestMapping("/api/admin/category") // ✅ Dùng đường dẫn rõ ràng
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public CategoryDTO getCategoryList(@RequestParam("page") int page, 
                                       @RequestParam("limit") int limit) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setPage(page);
        categoryDTO.setLimit(limit);
        Pageable pageable = new PageRequest(page - 1, limit); // cách cũ (deprecated nhưng hoạt động)

        categoryDTO.setListResult(categoryService.findAll(pageable));
        categoryDTO.setTotalItem(categoryService.getTotalItem());
        categoryDTO.setTotalPage((int) Math.ceil((double) categoryDTO.getTotalItem() / categoryDTO.getLimit()));

        return categoryDTO;
    }

    @GetMapping("/edit")
    public CategoryDTO editCategory(@RequestParam(value = "id", required = false) Long id) {
        if (id != null) {
            return categoryService.findById(id);
        } else {
            return new CategoryDTO(); // Trả về object rỗng nếu không có id
        }
    }
}
*/
