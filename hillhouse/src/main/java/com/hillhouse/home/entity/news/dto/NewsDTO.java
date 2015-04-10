package com.hillhouse.home.entity.news.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.hillhouse.home.base.LanguageModel;

public class NewsDTO extends LanguageModel {
	private MultipartFile media;
	private String title;
	private Date date;
	private String author;
	private String origion;
	private String summary;
	private String link;
	private String linkShorthand;
	private String img;
	private String type;
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the origion
	 */
	public String getOrigion() {
		return origion;
	}
	/**
	 * @param origion the origion to set
	 */
	public void setOrigion(String origion) {
		this.origion = origion;
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
	 * @return the linkShorthand
	 */
	public String getLinkShorthand() {
		return linkShorthand;
	}
	/**
	 * @param linkShorthand the linkShorthand to set
	 */
	public void setLinkShorthand(String linkShorthand) {
		this.linkShorthand = linkShorthand;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
}
