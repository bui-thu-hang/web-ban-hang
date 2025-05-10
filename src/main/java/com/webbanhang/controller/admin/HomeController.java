package com.webbanhang.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webbanhang.dto.HomeAdminDTO;
import com.webbanhang.dto.UserDTO;
import com.webbanhang.service.IProductService;
import com.webbanhang.service.IUserService;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/quan-tri/trang-chu", method = RequestMethod.GET)
	   public ModelAndView homePage() {
	      ModelAndView mav = new ModelAndView("admin/home");	      	      	   	      
	      HomeAdminDTO homeAdminDTO = new HomeAdminDTO();	      
	      List<UserDTO>  userDTOs = userService.findAllAd();
	      long ad = 0;
	      long manager = 0;
	      long staff = 0;
	      long user = 0;
	      long userIncognito = 0;
	      for (UserDTO userDTO : userDTOs) {
			if (userDTO.getRoleCode().equals("ADMIN")) {
				ad = ad + 1;
			}else if (userDTO.getRoleCode().equals("MANAGER")) {
				manager = manager + 1;
			}else if (userDTO.getRoleCode().equals("STAFF")) {
				staff = staff + 1;
			}else if (userDTO.getRoleCode().equals("USER") && userDTO.getStatus() == 1) {
				user = user + 1;
			} else {
				userIncognito = userIncognito + 1;
			}
		  }
	      homeAdminDTO.setUserAdmin(ad);
	      homeAdminDTO.setUserManager(manager);
	      homeAdminDTO.setUserStaff(staff);
	      homeAdminDTO.setUserUser(user);
	      homeAdminDTO.setUserUserIncognito(userIncognito);
	      homeAdminDTO.setProductXuongKhop((long) productService.findAllWeb1().size());
	      homeAdminDTO.setProductDaiTrang((long) productService.findAllWeb2().size());
	      homeAdminDTO.setProductNao((long) productService.findAllWeb3().size());	      	      
		  mav.addObject("model", homeAdminDTO);
	      return mav;
	   }
}
