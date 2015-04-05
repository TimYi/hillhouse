package com.hillhouse.home.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.doublev2v.foundation.entity.MediaContent;
import com.doublev2v.foundation.model.PagedList;
import com.doublev2v.foundation.service.MediaService;
import com.hillhouse.home.entity.portfolio.Portfolio;
import com.hillhouse.home.entity.portfolio.PortfolioRepository;

public class PortfolioService {
	@Autowired
	private PortfolioRepository repository;
	@Autowired
	private MediaService mediaService;
	public void addPortfolio(String link, MultipartFile img) throws IOException {
		Portfolio portfolio=new Portfolio();
		portfolio.setLink(link);
		if(img!=null) {
			MediaContent media=mediaService.save(img);
			portfolio.setMedia(media);
		}
		repository.save(portfolio);
	}
	public PagedList<Portfolio> getList(Integer pageNo, Integer pageSize) {
		return repository.getPagedList(pageNo, pageSize);
	}
	public void delete(String id) throws IOException {
		Portfolio portfolio=repository.getItem(id);
		MediaContent media=portfolio.getMedia();
		repository.delete(portfolio);
		mediaService.delete(media);
	}
}
