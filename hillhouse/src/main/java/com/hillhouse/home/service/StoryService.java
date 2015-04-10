package com.hillhouse.home.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doublev2v.foundation.media.MediaContent;
import com.hillhouse.home.base.LanguageDTOService;
import com.hillhouse.home.entity.story.Story;
import com.hillhouse.home.entity.story.dto.StoryDTO;

@Transactional
@Service
public class StoryService extends LanguageDTOService<Story, StoryDTO> {
	@Override
	public void delete(String id) {
		Story story=getRepository().getItem(id);
		if(story==null)return;
		MediaContent media=story.getMedia();
		getRepository().delete(story);
		try {
			mediaService.delete(media);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
