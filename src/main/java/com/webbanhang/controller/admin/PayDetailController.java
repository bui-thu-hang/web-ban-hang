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

import com.webbanhang.dto.PayDetailDTO;
import com.webbanhang.service.IPayDetailService;
import com.webbanhang.service.IPayService;
import com.webbanhang.util.MessageUtil;

@Controller(value = "payDetailControllerOfAdmin")
public class PayDetailController {

	@Autowired
	private IPayService payService;

	@Autowired
	private IPayDetailService payDetailService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/quan-tri/chi-tiet-don-hang/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, 
								 @RequestParam("limit") int limit, HttpServletRequest request) {
		PayDetailDTO payDetailDTO = new PayDetailDTO();
		payDetailDTO.setPage(page);
		payDetailDTO.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/payDetail/list");
		Pageable pageable = new PageRequest(page - 1, limit);
		payDetailDTO.setListResult(payDetailService.findAll(pageable));
		payDetailDTO.setTotalItem(payDetailService.getTotalItem());
		payDetailDTO.setTotalPage((int) Math.ceil((double) payDetailDTO.getTotalItem() / payDetailDTO.getLimit()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", payDetailDTO);
		return mav;
	}
	
	
	@RequestMapping(value = "/quan-tri/chi-tiet-don-hang/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/payDetail/edit");
		PayDetailDTO payDetailDTO = new PayDetailDTO();
		if (id != null) {
			payDetailDTO = payDetailService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("pays", payService.findAll());
		mav.addObject("model", payDetailDTO);
		return mav;
	}
}

/*package com.webbanhang.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webbanhang.dto.PayDetailDTO;
import com.webbanhang.service.IPayDetailService;

@RestController
@RequestMapping("/api/admin/pay-detail")
public class PayDetailController {

    @Autowired
    private IPayDetailService payDetailService;

    @GetMapping("/list")
    public PayDetailDTO showList(@RequestParam("page") int page,
                                 @RequestParam("limit") int limit) {
        PayDetailDTO payDetailDTO = new PayDetailDTO();
        payDetailDTO.setPage(page);
        payDetailDTO.setLimit(limit);

        Pageable pageable = new PageRequest(page - 1, limit); // Deprecated nhưng chạy được nếu Spring cũ

        payDetailDTO.setListResult(payDetailService.findAll(pageable));
        payDetailDTO.setTotalItem(payDetailService.getTotalItem());
        payDetailDTO.setTotalPage((int) Math.ceil((double) payDetailDTO.getTotalItem() / payDetailDTO.getLimit()));
        return payDetailDTO;
    }
    @GetMapping("/detail")
    public PayDetailDTO getPayDetailById(@RequestParam("id") Long id) {
        return payDetailService.findById(id);
    }

}
*/
