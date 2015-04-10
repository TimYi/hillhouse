package com.hillhouse.home.entity.portfolio.dto;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.doublev2v.foundation.media.MediaContent;
import com.hillhouse.home.base.LanguageMediaDTOAdapter;
import com.hillhouse.home.entity.portfolio.Portfolio;

@Component
public class PortfolioDTOAdapter extends LanguageMediaDTOAdapter<Portfolio, PortfolioDTO> {

	@Override
	protected Portfolio preCreateDO(PortfolioDTO t) {
		Portfolio portfolio=new Portfolio();
		return preUpdateDO(t, portfolio);
	}

	@Override
	protected PortfolioDTO preCreateDTO(Portfolio d) {
		PortfolioDTO t=new PortfolioDTO();
		return preUpdateDTO(t, d);
	}

	@Override
	protected Portfolio preUpdateDO(PortfolioDTO t, Portfolio d) {
		d.setLink(t.getLink());
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
	protected PortfolioDTO preUpdateDTO(PortfolioDTO t, Portfolio d) {
		t.setId(d.getId());
		t.setLink(d.getLink());
		t.setUrl(d.getUrl());
		return t;
	}
}
