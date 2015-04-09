package com.hillhouse.home.entity.portfolio;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.doublev2v.foundation.entity.MediaContent;
import com.doublev2v.foundation.model.dto.DTOUpdate;
import com.hillhouse.home.entity.LanguageModel;

@Entity
public class Portfolio extends LanguageModel implements DTOUpdate<Portfolio,String> {
	
	private String id;
	private MediaContent media;
	private String link;
	
	/**
	 * @return the id
	 */
	@Id
	@GenericGenerator(name="idGenerator",strategy="uuid")
	@GeneratedValue(generator="idGenerator")
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
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
	/**
	 * @return
	 */
	@Transient
	public String getUrl() {
		return media.getUrl();
	}
	
	@Override
	public Portfolio update(Portfolio portfolio) {
		portfolio.setLink(link);
		return portfolio;
	}
}
