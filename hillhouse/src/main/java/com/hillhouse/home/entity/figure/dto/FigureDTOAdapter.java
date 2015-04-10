package com.hillhouse.home.entity.figure.dto;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.doublev2v.foundation.media.MediaContent;
import com.hillhouse.home.base.LanguageMediaDTOAdapter;
import com.hillhouse.home.entity.figure.Figure;

@Component
public class FigureDTOAdapter extends LanguageMediaDTOAdapter<Figure, FigureDTO> {

	@Override
	protected Figure preCreateDO(FigureDTO t) {
		Figure d=new Figure();
		return preUpdateDO(t, d);
	}

	@Override
	protected FigureDTO preCreateDTO(Figure d) {
		FigureDTO t=new FigureDTO();
		return preUpdateDTO(t, d);
	}

	@Override
	protected Figure preUpdateDO(FigureDTO t, Figure d) {
		d.setFirstname(t.getFirstname());
		d.setFullTitle(t.getFullTitle());
		d.setLastname(t.getLastname());
		d.setPriority(t.getPriority());
		d.setStory(t.getStory());
		d.setSummary(t.getSummary());
		d.setTitle(t.getTitle());
		MultipartFile file=t.getMedia();
		try {
			if(file!=null) {
				MediaContent media=d.getMedia();
				if(media==null) {
					media=getMediaService().save(file);					
				} else {
					media=getMediaService().update(media, file);
				}
				d.setMedia(media);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return d;
	}

	@Override
	protected FigureDTO preUpdateDTO(FigureDTO t, Figure d) {
		t.setId(d.getId());
		t.setFirstname(d.getFirstname());
		t.setFullTitle(d.getFullTitle());
		t.setLastname(d.getLastname());
		t.setPriority(d.getPriority());
		t.setStory(d.getStory());
		t.setSummary(d.getSummary());
		t.setTitle(d.getTitle());
		t.setAvatar(d.getAvatar());
		return t;
	}
}
