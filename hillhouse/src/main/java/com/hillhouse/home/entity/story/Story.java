package com.hillhouse.home.entity.story;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import com.doublev2v.foundation.media.MediaContent;
import com.hillhouse.home.base.LanguagePriorityModel;

@Entity
public class Story extends LanguagePriorityModel {
	private MediaContent media;
	private String title;
	private String introduction;
	private String summary;
	private String content;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the introduction
	 */
	@Column(length=2000)
	public String getIntroduction() {
		return introduction;
	}
	/**
	 * @param introduction the introduction to set
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	/**
	 * @return the summary
	 */
	@Column(length=2000)
	public String getSummary() {
		return summary;
	}
	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/**
	 * @return the content
	 */
	@Type(type="text")
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return
	 */
	@Transient
	public String getImg() {
		if(media==null)return null;
		return media.getUrl();
	}
}
