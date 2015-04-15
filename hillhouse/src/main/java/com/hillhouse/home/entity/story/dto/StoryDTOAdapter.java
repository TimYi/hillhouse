package com.hillhouse.home.entity.story.dto;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.doublev2v.foundation.media.MediaContent;
import com.hillhouse.home.base.LanguageMediaDTOAdapter;
import com.hillhouse.home.entity.story.Story;

@Component
public class StoryDTOAdapter extends LanguageMediaDTOAdapter<Story, StoryDTO> {

	@Override
	protected Story preCreateDO(StoryDTO t) {
		Story d=new Story();
		return preUpdateDO(t, d);
	}

	@Override
	protected StoryDTO preCreateDTO(Story d) {
		StoryDTO t=new StoryDTO();
		return preUpdateDTO(t, d);
	}

	@Override
	protected Story preUpdateDO(StoryDTO t, Story d) {
		d.setContent(t.getContent());
		d.setSummary(t.getSummary());
		d.setTitle(t.getTitle());
		d.setIntroduction(t.getIntroduction());
		d.setPriority(t.getPriority());
		MultipartFile file=t.getMedia();
		try {
			if(file!=null && !file.isEmpty()) {
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
	protected StoryDTO preUpdateDTO(StoryDTO t, Story d) {
		t.setId(d.getId());
		t.setContent(d.getContent());
		t.setSummary(d.getSummary());
		t.setIntroduction(d.getIntroduction());
		t.setTitle(d.getTitle());
		t.setPriority(d.getPriority());
		t.setImg(d.getImg());
		return t;
	}
}
