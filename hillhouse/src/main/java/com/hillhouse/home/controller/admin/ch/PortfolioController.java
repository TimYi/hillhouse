package com.hillhouse.home.controller.admin.ch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hillhouse.home.base.LanguageModel.Language;
import com.hillhouse.home.controller.admin.CommonController;
import com.hillhouse.home.entity.portfolio.Portfolio;
import com.hillhouse.home.entity.portfolio.dto.PortfolioDTO;

@RequestMapping("/admin/ch/portfolio")
@Controller(value="chPortfolioController")
public class PortfolioController extends CommonController<Portfolio, PortfolioDTO> {

	@Override
	protected Language getLanguage() {
		return Language.CH;
	}

	@Override
	protected String getBasePath() {
		return "/admin/ch/portfolio";
	}

}
