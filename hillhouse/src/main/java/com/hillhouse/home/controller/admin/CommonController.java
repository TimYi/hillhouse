package com.hillhouse.home.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hillhouse.home.base.LanguageDTOService;
import com.hillhouse.home.base.LanguageModel;
import com.hillhouse.home.base.LanguageModel.Language;

/**
 * 封装统一的后端访问行为
 * @author ytm
 *
 * @param <D>
 * @param <T>
 */
public abstract class CommonController
	<D extends LanguageModel, T extends LanguageModel>  {
	
	@Autowired
	protected LanguageDTOService<D, T> service;
	
	/**
	 * 语言设置
	 * @return
	 */
	abstract protected Language getLanguage();
	/**
	 * jsp文件基础路径
	 * @return
	 */
	abstract protected String getBasePath();

	/**
	 * 列表
	 * @return
	 */
	@RequestMapping("")
	public ModelAndView list() {
		List<T> ts=service.getAll(getLanguage());
		String viewPath=getBasePath()+"/list";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("ts", ts);
		return view;
	}
	
	/**
	 * 查看详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public ModelAndView info(@PathVariable String id) {
		T t=service.get(id);
		String viewPath=getBasePath()+"/info";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("t", t);
		return view;
	}

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value="{id}",method=RequestMethod.POST)
	public @ResponseBody String delete(@PathVariable String id) {
		service.delete(id);
		return "删除成功";
	}

	/**
	 * 编辑页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value="{id}/edit",method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable String id) {
		T t=service.get(id);
		String viewPath=getBasePath()+"/edit";
		ModelAndView view=new ModelAndView(viewPath);
		view.addObject("t", t);
		return view;
	}

	/**
	 * 编辑
	 * @param id
	 * @param t
	 * @return
	 */
	@RequestMapping(value="{id}/edit",method=RequestMethod.POST)
	public ModelAndView edit(@PathVariable String id,T t) {
		t.setId(id);
		t.setLanguage(getLanguage());
		service.update(t);
		return list();
	}

	/**
	 * 添加页面
	 * @return
	 */
	@RequestMapping(value="add",method=RequestMethod.GET)
	public ModelAndView add() {
		String viewPath=getBasePath()+"/add";
		return new ModelAndView(viewPath);
	}

	/**
	 * 添加
	 * @param t
	 * @return
	 */
	@RequestMapping(value="add",method=RequestMethod.POST)
	public ModelAndView add(T t) {
		t.setLanguage(getLanguage());
		service.add(t);
		return list();
	}
}
