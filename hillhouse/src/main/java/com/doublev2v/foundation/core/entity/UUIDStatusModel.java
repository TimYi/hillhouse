package com.doublev2v.foundation.core.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import com.doublev2v.foundation.core.model.Identified;

@MappedSuperclass
public abstract class UUIDStatusModel extends StatusModel implements Identified<String> {
	private String id;

	/**
	 * @return the id
	 */
	@Override
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
}
