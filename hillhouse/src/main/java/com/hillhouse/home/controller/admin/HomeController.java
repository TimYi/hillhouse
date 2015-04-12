package com.hillhouse.home.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class HomeController {
	@RequestMapping("")
	public ModelAndView en() {
		return new ModelAndView("admin/index");
	}
	@RequestMapping("ch")
	public ModelAndView ch() {
		return new ModelAndView("admin/ch/index");
	}
}
