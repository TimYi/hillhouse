package com.hillhouse.home.controller.admin.en;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hillhouse.home.base.LanguageModel.Language;
import com.hillhouse.home.controller.admin.CommonController;
import com.hillhouse.home.entity.story.Story;
import com.hillhouse.home.entity.story.dto.StoryDTO;

@RequestMapping("/admin/story")
@Controller
public class StoryController extends CommonController<Story, StoryDTO> {

	@Override
	protected Language getLanguage() {
		return Language.EN;
	}

	@Override
	protected String getBasePath() {
		return "/admin/en/story";
	}
}
