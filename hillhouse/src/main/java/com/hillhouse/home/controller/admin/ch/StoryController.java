package com.hillhouse.home.controller.admin.ch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hillhouse.home.base.LanguageModel.Language;
import com.hillhouse.home.controller.admin.CommonController;
import com.hillhouse.home.entity.story.Story;
import com.hillhouse.home.entity.story.dto.StoryDTO;

@RequestMapping("/admin/ch/story")
@Controller(value="chStoryController")
public class StoryController extends CommonController<Story, StoryDTO> {

	@Override
	protected Language getLanguage() {
		return Language.CH;
	}

	@Override
	protected String getBasePath() {
		return "/admin/story";
	}
}
