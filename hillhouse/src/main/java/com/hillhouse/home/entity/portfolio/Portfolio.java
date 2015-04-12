package com.hillhouse.home.entity.portfolio;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.doublev2v.foundation.media.MediaContent;
import com.hillhouse.home.base.LanguagePriorityModel;

@Entity
public class Portfolio extends LanguagePriorityModel {
	private MediaContent media;
	private String name;
	private String link;
	
	/**
	 * @return the media
	 */
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public MediaContent getMedia() {
		return media;
	}
	/**
	 * @param media the media to set
	 */
	public void setMedia(MediaContent media) {
		this.media = media;
	}
	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}
	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return
	 */
	@Transient
	public String getUrl() {
		return media==null?null:media.getUrl();
	}
}
