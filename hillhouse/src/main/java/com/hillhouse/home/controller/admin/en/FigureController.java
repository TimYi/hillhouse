package com.hillhouse.home.controller.admin.en;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hillhouse.home.base.LanguageModel.Language;
import com.hillhouse.home.controller.admin.CommonController;
import com.hillhouse.home.entity.figure.Figure;
import com.hillhouse.home.entity.figure.dto.FigureDTO;

@Controller
@RequestMapping("/admin/figure")
public class FigureController extends CommonController<Figure, FigureDTO> {

	@Override
	protected Language getLanguage() {
		return Language.EN;
	}

	@Override
	protected String getBasePath() {
		return "/admin/en/figure";
	}
}
