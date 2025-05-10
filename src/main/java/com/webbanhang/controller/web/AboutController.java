package com.webbanhang.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "aboutControllerOfWeb")
public class AboutController {

	@RequestMapping(value = "/gioi-thieu", method = RequestMethod.GET)
	public ModelAndView aboutPage() {
		ModelAndView mav = new ModelAndView("web/about");
		return mav;
	}
}
