package com.hillhouse.home.entity.story;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.doublev2v.foundation.entity.BaseModel;
import com.doublev2v.foundation.entity.MediaContent;

@Entity
public class Story extends BaseModel {
	private String id;
	private MediaContent media;
	private String title;
	private String summary;
	private String content;
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
	 * @return the summary
	 */
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
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg() {
		return media.getUrl();
	}
}
