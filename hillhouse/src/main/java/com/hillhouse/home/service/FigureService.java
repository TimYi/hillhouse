package com.hillhouse.home.service;

import java.io.IOException;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.doublev2v.foundation.entity.MediaContent;
import com.doublev2v.foundation.model.PagedList;
import com.doublev2v.foundation.model.dto.DTOUpdate;
import com.doublev2v.foundation.service.MediaService;
import com.hillhouse.home.entity.LanguageModel.Language;
import com.hillhouse.home.entity.figure.Figure;
import com.hillhouse.home.entity.figure.FigureRepository;

@Service
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
	
	public PagedList<Figure> getList(Integer pageNo, Integer pageSize, Language language) {
		return repository.getPagedList(pageNo, pageSize, language);
	}
	
	public Figure getFigure(String id) {
		return repository.getItem(id);
	}
	
	public void updateFigure(DTOUpdate<Figure, String> figure, MultipartFile avatar) throws IOException {
		Figure origion=repository.getItem(figure.getId());
		if(origion==null)return;		
		if(avatar!=null) {
			MediaContent media=origion.getMedia();
			if(media==null) {
				media=mediaService.save(avatar);				
			} else {
				media=mediaService.update(media, avatar);				
			}
			origion.setMedia(media);
		}
		figure.update(origion);
		repository.update(origion);
	}
	
	public void deleteFigure(String id) throws IOException {
		Figure figure=repository.getItem(id);
		if(figure==null)return;
		MediaContent media=figure.getMedia();
		repository.delete(figure);
		mediaService.delete(media);
	}
}
