package com.hillhouse.home.entity.story.dto;

import org.springframework.web.multipart.MultipartFile;

import com.hillhouse.home.base.LanguageModel;

public class StoryDTO extends LanguageModel {
	private String title;
	private String summary;
	private String content;
	private String img;
	private MultipartFile media;
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
	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}
	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * @return the media
	 */
	public MultipartFile getMedia() {
		return media;
	}
	/**
	 * @param media the media to set
	 */
	public void setMedia(MultipartFile media) {
		this.media = media;
	}
}
