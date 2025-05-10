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

import com.webbanhang.dto.UserDTO;
import com.webbanhang.service.IRoleService;
import com.webbanhang.service.IUserService;
import com.webbanhang.util.MessageUtil;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller(value = "userControllerOfAdmin")
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/quan-tri/user/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, 
								 @RequestParam("limit") int limit,
								 HttpServletRequest request) {
		UserDTO userDTO = new UserDTO();
		userDTO.setPage(page);
		userDTO.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/user/list");
		Pageable pageable = new PageRequest(page - 1, limit);	
		userDTO.setListResult(userService.findAll(pageable));		
		userDTO.setTotalItem(userService.getTotalItem());
		userDTO.setTotalPage((int) Math.ceil((double) userDTO.getTotalItem() / userDTO.getLimit()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", userDTO);
		return mav;
	}
	@RequestMapping(value = "/quan-tri/user/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/user/edit");
		UserDTO userDTO = new UserDTO();
		if (id != null) {
			userDTO = userService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("roles", roleService.findAll());
		mav.addObject("model", userDTO);
		return mav;
	}
}
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.webbanhang.dto.UserDTO;
import com.webbanhang.service.IUserService;

@RestController
@RequestMapping("/api/admin/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    public UserDTO getAllUsers(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        UserDTO userDTO = new UserDTO();
        userDTO.setPage(page);
        userDTO.setLimit(limit);
        Pageable pageable = new PageRequest(page - 1, limit);
        userDTO.setListResult(userService.findAll(pageable));
        userDTO.setTotalItem(userService.getTotalItem());
        userDTO.setTotalPage((int) Math.ceil((double) userDTO.getTotalItem() / userDTO.getLimit()));

        return userDTO;
    }
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }
}

*/