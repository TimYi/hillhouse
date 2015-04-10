package com.hillhouse.home.entity.news.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.doublev2v.foundation.core.model.GenericClassCreator;
import com.doublev2v.foundation.media.MediaContent;
import com.hillhouse.home.base.LanguageMediaDTOAdapter;
import com.hillhouse.home.entity.news.AbstractNews;

public abstract class AbstractNewsDTOAdapter<D extends AbstractNews> extends 
	LanguageMediaDTOAdapter<D, NewsDTO> {
	
	@Autowired
	private GenericClassCreator<D> newsCreator;
	@Override
	protected D preCreateDO(NewsDTO t) {
		D d=newsCreator.create();
		return preUpdateDO(t, d);
	}
	@Override
	protected NewsDTO preCreateDTO(D d) {
		NewsDTO t=new NewsDTO();
		return preUpdateDTO(t, d);
	}
	@Override
	protected D preUpdateDO(NewsDTO t, D d) {
		d.setAuthor(t.getAuthor());
		d.setDate(t.getDate());
		d.setLink(t.getLink());
		d.setLinkShorthand(t.getLinkShorthand());
		d.setOrigion(t.getOrigion());
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
	protected NewsDTO preUpdateDTO(NewsDTO t, D d) {
		t.setId(d.getId());
		t.setAuthor(d.getAuthor());
		t.setDate(d.getDate());
		t.setLink(d.getLink());
		t.setLinkShorthand(d.getLinkShorthand());
		t.setOrigion(d.getOrigion());
		t.setSummary(d.getSummary());
		t.setTitle(d.getTitle());
		t.setImg(d.getImg());
		return t;
	}
}
