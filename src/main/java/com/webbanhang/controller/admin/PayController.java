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

import com.webbanhang.dto.PayDTO;
import com.webbanhang.service.IPayService;
import com.webbanhang.service.IUserService;
import com.webbanhang.util.MessageUtil;

@Controller(value = "payControllerOfAdmin")
public class PayController {

	@Autowired
	private IPayService payService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/quan-tri/don-hang/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, 
								 @RequestParam("limit") int limit, HttpServletRequest request) {
		PayDTO payDTO = new PayDTO();
		payDTO.setPage(page);
		payDTO.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/pay/list");
		Pageable pageable = new PageRequest(page - 1, limit);
		payDTO.setListResult(payService.findAll(pageable));
		payDTO.setTotalItem(payService.getTotalItem());
		payDTO.setTotalPage((int) Math.ceil((double) payDTO.getTotalItem() / payDTO.getLimit()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", payDTO);
		return mav;
	}
	
	
	@RequestMapping(value = "/quan-tri/don-hang/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/pay/edit");
		PayDTO payDTO = new PayDTO();
		if (id != null) {
			payDTO = payService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("users", userService.findAll());
		mav.addObject("model", payDTO);
		return mav;
	}
}

/*
package com.webbanhang.controller.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.webbanhang.dto.PayDTO;
import com.webbanhang.service.IPayService;

@RestController
@RequestMapping("/api/admin/don-hang")
public class PayController {

    @Autowired
    private IPayService payService;

    @GetMapping("/danh-sach")
    public PayDTO showList(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        PayDTO payDTO = new PayDTO();
        payDTO.setPage(page);
        payDTO.setLimit(limit);
        Pageable pageable = new PageRequest(page - 1, limit);

   
        payDTO.setListResult(payService.findAll(pageable));
        payDTO.setTotalItem(payService.getTotalItem());
        payDTO.setTotalPage((int) Math.ceil((double) payDTO.getTotalItem() / limit));
        return payDTO;
    }

    @GetMapping("/chi-tiet")
    public PayDTO editNew(@RequestParam(value = "id", required = false) Long id) {
        if (id != null) {
            return payService.findById(id);
        }
        return new PayDTO();
    }
}

*/