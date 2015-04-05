package com.hillhouse.home.service;

import java.io.IOException;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.doublev2v.foundation.entity.MediaContent;
import com.doublev2v.foundation.model.PagedList;
import com.doublev2v.foundation.service.MediaService;
import com.hillhouse.home.entity.story.Story;
import com.hillhouse.home.entity.story.StoryRepository;

public class StoryService {
	@Autowired
	private StoryRepository repository;
	@Autowired
	private MediaService mediaService;
	public void addStory(Story story, MultipartFile img) throws IOException {
		Validate.notNull(story);
		if(img!=null) {
			MediaContent media=mediaService.save(img);
			story.setMedia(media);
		}
		repository.save(story);
	}
	public PagedList<Story> getList(Integer pageNo, Integer pageSize) {
		return repository.getPagedList(pageNo, pageSize);
	}
	public void deleteStory(String id) throws IOException {
		Story story=repository.getItem(id);
		MediaContent media=story.getMedia();
		repository.delete(story);
		mediaService.delete(media);
	}
}
