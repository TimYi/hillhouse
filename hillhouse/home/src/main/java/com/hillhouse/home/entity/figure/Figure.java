package com.hillhouse.home.entity.figure;

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
public class Figure extends BaseModel {
	private String id;
	private Integer priority;
	private MediaContent media;
	private String firstname;
	private String lastname;
	private String title;
	private String fullTitle;
	private String summary;
	private String story;
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
	 * @return the priority
	 */
	public Integer getPriority() {
		return priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	/**
	 * @return the avatar
	 */
	@OneToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	public MediaContent getMedia() {
		return media;
	}
	/**
	 * @param avatar the avatar to set
	 */
	public void setMedia(MediaContent media) {
		this.media = media;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	 * @return the fullTitle
	 */
	public String getFullTitle() {
		return fullTitle;
	}
	/**
	 * @param fullTitle the fullTitle to set
	 */
	public void setFullTitle(String fullTitle) {
		this.fullTitle = fullTitle;
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
	 * @return the story
	 */
	public String getStory() {
		return story;
	}
	/**
	 * @param story the story to set
	 */
	public void setStory(String story) {
		this.story = story;
	}
	/**
	 * 直接获取头像
	 * @return
	 */
	public String getAvatar() {
		return this.media.getUrl();
	}
}
