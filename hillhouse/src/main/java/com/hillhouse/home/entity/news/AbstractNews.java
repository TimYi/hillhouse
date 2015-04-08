package com.hillhouse.home.entity.news;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.doublev2v.foundation.entity.BaseModel;
import com.doublev2v.foundation.entity.MediaContent;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
public class AbstractNews extends BaseModel {
	private String id;
	private MediaContent media;
	private String title;
	private Date date;
	private String author;
	private String origion;
	private String summary;
	private String link;
	private String linkShorthand;
	private String type;
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
	 * @return
	 */
	@Transient
	public String getImg() {
		return this.media.getUrl();
	}
	/**
	 * @return the type
	 */
	@Column(name="type",updatable=false,insertable=false)
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */	
	public void setType(String type) {
		this.type = type;
	}
	
	public <T extends AbstractNews> T update(T news) {
		news.setAuthor(author);
		news.setDate(date);
		news.setTitle(title);
		news.setLink(link);
		news.setLinkShorthand(linkShorthand);
		news.setOrigion(origion);
		news.setSummary(summary);
		return news;
	}
}
