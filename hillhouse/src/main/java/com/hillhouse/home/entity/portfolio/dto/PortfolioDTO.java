package com.hillhouse.home.entity.portfolio.dto;

import org.springframework.web.multipart.MultipartFile;

import com.hillhouse.home.base.LanguageModel;

public class PortfolioDTO extends LanguageModel {
	private String id;
	private String url;
	private String link;
	private MultipartFile media;
	/**
	 * @return the id
	 */
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
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
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
	 * @return the meida
	 */
	public MultipartFile getMedia() {
		return media;
	}
	public void setMedia(MultipartFile media) {
		this.media = media;
	}
}
