package com.hillhouse.home.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hillhouse.home.base.LanguageModel.Language;
import com.hillhouse.home.deploy.StaticWebsiteGenerator;

@Controller
@RequestMapping("/admin")
public class HomeController {
	@RequestMapping("")
	public ModelAndView en() {
		ModelAndView view=new ModelAndView("admin/index");
		view.addObject("lang", Language.EN);
		return view;
	}
	@RequestMapping("ch")
	public ModelAndView ch() {
		ModelAndView view=new ModelAndView("admin/index");
		view.addObject("lang", Language.CH);
		return view;
	}
	
	@RequestMapping("deploy")
	public @ResponseBody String deploy() {
		StaticWebsiteGenerator.deploy();
		return "发布成功";
	}
}
