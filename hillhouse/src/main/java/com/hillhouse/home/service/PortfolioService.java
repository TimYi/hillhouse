package com.hillhouse.home.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doublev2v.foundation.dto.DTOService;
import com.doublev2v.foundation.media.MediaContent;
import com.doublev2v.foundation.media.MediaService;
import com.hillhouse.home.entity.portfolio.Portfolio;
import com.hillhouse.home.entity.portfolio.dto.PortfolioDTO;

@Transactional
@Service
public class PortfolioService extends DTOService<String, Portfolio, PortfolioDTO> {
	@Autowired
	private MediaService mediaService;
	@Override
	public void delete(String id) {
		Portfolio portfolio=getRepository().getItem(id);
		if(portfolio==null)return;
		MediaContent media=portfolio.getMedia();
		getRepository().delete(portfolio);
		try {
			mediaService.delete(media);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
