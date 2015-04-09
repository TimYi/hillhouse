package com.hillhouse.home.entity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import com.doublev2v.foundation.entity.BaseModel;

@MappedSuperclass
public class LanguageModel extends BaseModel {
	private Language language;
	
	/**
	 * @return the language
	 */
	@Enumerated(value=EnumType.STRING)
	@Column(nullable=false,updatable=false)
	public Language getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}

	public static enum Language {
		EN,CH
	}
}
