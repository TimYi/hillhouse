package com.hillhouse.home.base;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import com.doublev2v.foundation.core.entity.UUIDBaseModel;

@MappedSuperclass
public class LanguageModel extends UUIDBaseModel {
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
