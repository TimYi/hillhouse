package com.hillhouse.home.service;

import java.io.IOException;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.doublev2v.foundation.entity.MediaContent;
import com.doublev2v.foundation.model.PagedList;
import com.doublev2v.foundation.repository.BaseModelRepository;
import com.doublev2v.foundation.service.MediaService;
import com.hillhouse.home.entity.news.AbstractNews;

public class AbstractNewsService<T extends AbstractNews> {
	@Autowired
	private BaseModelRepository<T, String> repository;
	@Autowired
	private MediaService mediaService;
	
	public void addNews(T news, MultipartFile img) throws IOException {
		Validate.notNull(news);
		if(img!=null) {
			MediaContent media=mediaService.save(img);
			news.setMedia(media);
		}
		repository.save(news);
	}
	public PagedList<T> getNews(Integer pageNo, Integer pageSize) {
		return repository.getPagedList(pageNo, pageSize);
	}
	public void updateNews(T news) {
		Validate.notNull(news);
		T origion=repository.getItem(news.getId());
		news.setMedia(origion.getMedia());
		repository.saveOrUpdate(news);
	}
	public void deleteNews(String id) throws IOException {
		T news=repository.getItem(id);
		MediaContent media=news.getMedia();
		repository.delete(news);
		mediaService.delete(media);
	}
}
