package com.hillhouse.home.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doublev2v.foundation.media.MediaContent;
import com.hillhouse.home.base.LanguageDTOService;
import com.hillhouse.home.entity.news.PortfolioNews;
import com.hillhouse.home.entity.news.dto.NewsDTO;

@Transactional
@Service
public class PortfolioNewsService extends LanguageDTOService<PortfolioNews, NewsDTO> {
	@Override
	public void delete(String id) {
		PortfolioNews news=getRepository().getItem(id);
		if(news==null)return;
		MediaContent media=news.getMedia();
		getRepository().delete(news);
		try {
			mediaService.delete(media);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
