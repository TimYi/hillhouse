package com.hillhouse.home.service;

import java.io.IOException;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.doublev2v.foundation.entity.MediaContent;
import com.doublev2v.foundation.model.PagedList;
import com.doublev2v.foundation.service.MediaService;
import com.hillhouse.home.entity.portfolio.Portfolio;
import com.hillhouse.home.entity.portfolio.PortfolioRepository;

@Service
public class PortfolioService {
	@Autowired
	private PortfolioRepository repository;
	@Autowired
	private MediaService mediaService;
	public void addPortfolio(Portfolio portfolio, MultipartFile img) throws IOException {
		Validate.notNull(portfolio);
		if(img!=null) {
			MediaContent media=mediaService.save(img);
			portfolio.setMedia(media);
		}
		repository.save(portfolio);
	}
	public void updatePortfolio(Portfolio portfolio, MultipartFile url) throws IOException {
		Portfolio origion=repository.getItem(portfolio.getId());
		if(origion==null)return;
		if(url!=null) {
			MediaContent media=origion.getMedia();
			if(media==null) {
				media=mediaService.save(url);
			}else {
				media=mediaService.update(media, url);
			}
			origion.setMedia(media);
		}
		portfolio.update(origion);
		repository.update(origion);
	}
	public PagedList<Portfolio> getList(Integer pageNo, Integer pageSize) {
		return repository.getPagedList(pageNo, pageSize);
	}
	public Portfolio getPortfolio(String id) {
		return repository.getItem(id);
	}
	public void delete(String id) throws IOException {
		Portfolio portfolio=repository.getItem(id);
		MediaContent media=portfolio.getMedia();
		repository.delete(portfolio);
		mediaService.delete(media);
	}
}
