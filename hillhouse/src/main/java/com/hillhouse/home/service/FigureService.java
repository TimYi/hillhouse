package com.hillhouse.home.service;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.doublev2v.foundation.entity.MediaContent;
import com.doublev2v.foundation.model.PagedList;
import com.doublev2v.foundation.service.MediaService;
import com.hillhouse.home.entity.figure.Figure;
import com.hillhouse.home.entity.figure.FigureRepository;

public class FigureService {
	@Autowired
	private FigureRepository repository;
	@Autowired
	private MediaService mediaService;
	
	public void addFigure(Figure figure, MultipartFile avatar) throws IOException {
		Validate.notNull(figure);
		if(avatar!=null) {
			MediaContent media=mediaService.save(avatar);
			figure.setMedia(media);
		}
		repository.save(figure);
	}
	
	public PagedList<Figure> getList(Integer pageNo, Integer pageSize) {
		return repository.getPagedList(pageNo, pageSize);
	}
	
	public void updateFigure(Figure figure) throws IOException {
		Figure origion=repository.getItem(figure.getId());
		if(origion==null)return;
		figure.setMedia(origion.getMedia());
		repository.saveOrUpdate(figure);
	}
	
	public void deleteFigure(String id) throws IOException {
		Figure figure=repository.getItem(id);
		if(figure==null)return;
		MediaContent media=figure.getMedia();
		repository.delete(figure);
		mediaService.delete(media);
	}
}
