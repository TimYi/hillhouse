package com.hillhouse.home.controller.admin.en;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hillhouse.home.base.LanguageModel.Language;
import com.hillhouse.home.controller.admin.CommonController;
import com.hillhouse.home.entity.news.PortfolioNews;
import com.hillhouse.home.entity.news.dto.NewsDTO;

@RequestMapping("/admin/portfolionews")
@Controller
public class PortfolioNewsController extends CommonController<PortfolioNews,NewsDTO> {

	@Override
	protected Language getLanguage() {
		return Language.EN;
	}

	@Override
	protected String getBasePath() {
		return "/admin/en/portfolionews";
	}
	
}
