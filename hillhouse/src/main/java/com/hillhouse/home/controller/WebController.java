package com.hillhouse.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.doublev2v.foundation.core.model.PagedList;
import com.hillhouse.home.base.LanguageModel.Language;
import com.hillhouse.home.entity.contact.Contact;
import com.hillhouse.home.entity.figure.dto.FigureDTO;
import com.hillhouse.home.entity.news.dto.NewsDTO;
import com.hillhouse.home.entity.portfolio.dto.PortfolioDTO;
import com.hillhouse.home.entity.story.dto.StoryDTO;
import com.hillhouse.home.service.ContactService;
import com.hillhouse.home.service.FigureService;
import com.hillhouse.home.service.NewsService;
import com.hillhouse.home.service.PortfolioNewsService;
import com.hillhouse.home.service.PortfolioService;
import com.hillhouse.home.service.StoryService;

@Controller
public class WebController {
	@Autowired
	private ContactService contactService;
	@Autowired
	private FigureService figureService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private PortfolioNewsService portfolioNewsService;
	@Autowired
	private PortfolioService portfolioService;
	@Autowired
	private StoryService storyService;
	
	protected Language language=Language.EN;
	
	protected String basePath="";
	
	@RequestMapping("/")
	public ModelAndView aboutUs() {
		List<FigureDTO> figures=figureService.getAll(language);
		String viewPath=basePath+"index";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("figures", figures);
		return view;
	}
	
	@RequestMapping("/storys")
	public ModelAndView storys() {
		List<StoryDTO> storys=storyService.getAll(language);
		String viewPath=basePath+"storys";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("storys", storys);
		return view;
	}
	
	@RequestMapping("portfolios")
	public ModelAndView portfolios() {
		String viewPath=basePath+"portfolios";
		List<PortfolioDTO> portfolios=portfolioService.getAll(language);
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("portfolios", portfolios);
		return view;
	}
	
	@RequestMapping("portfolionews")
	public ModelAndView portfolionews(Integer pageNo, Integer pageSize) {
		String viewPath=basePath+"portfolionews";
		PagedList<NewsDTO> news=portfolioNewsService.getPagedList(pageNo, pageSize, language);
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("portfolionews", news);
		return view;
	}
	
	@RequestMapping("news")
	public ModelAndView news(Integer pageNo, Integer pageSize) {
		String viewPath=basePath+"portfolionews";
		PagedList<NewsDTO> news=newsService.getPagedList(pageNo, pageSize, language);
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("news", news);
		return view;
	}
	
	@RequestMapping("figure/{id}")
	public ModelAndView figure(@PathVariable String id) {
		FigureDTO figure=figureService.get(id);
		String viewPath=basePath+"figure";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("figure", figure);
		return view;
	}
	
	@RequestMapping("story/{id}")
	public ModelAndView story(@PathVariable String id) {
		StoryDTO story=storyService.get(id);
		String viewPath=basePath+"story";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("story", story);
		return view;
	}
	
	@RequestMapping("contact")
	public @ResponseBody String contact(Contact contact) {
		contactService.add(contact);
		return "success";
	}
}
