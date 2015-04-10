package com.hillhouse.home.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doublev2v.foundation.media.MediaContent;
import com.hillhouse.home.base.LanguageDTOService;
import com.hillhouse.home.entity.figure.Figure;
import com.hillhouse.home.entity.figure.dto.FigureDTO;

@Transactional
@Service
public class FigureService extends LanguageDTOService<Figure, FigureDTO> {
	@Override
	public void delete(String id) {
		Figure figure=getRepository().getItem(id);
		if(figure==null)return;
		MediaContent media=figure.getMedia();
		getRepository().delete(figure);
		try {
			mediaService.delete(media);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
