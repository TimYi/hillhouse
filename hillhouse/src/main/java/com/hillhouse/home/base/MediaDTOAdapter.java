package com.hillhouse.home.base;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.doublev2v.foundation.core.model.Identified;
import com.doublev2v.foundation.dto.AbstractDTOAdapter;
import com.doublev2v.foundation.media.MediaService;

public abstract class MediaDTOAdapter<PK extends Serializable,D,T extends Identified<PK>>
	extends AbstractDTOAdapter<PK, D, T> {
	private MediaService mediaService;

	/**
	 * @return the mediaService
	 */
	public MediaService getMediaService() {
		return mediaService;
	}

	/**
	 * @param mediaService the mediaService to set
	 */
	@Autowired
	public void setMediaService(MediaService mediaService) {
		this.mediaService = mediaService;
	}
}
