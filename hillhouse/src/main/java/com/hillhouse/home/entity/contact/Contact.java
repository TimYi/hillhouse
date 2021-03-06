package com.hillhouse.home.entity.contact;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.doublev2v.foundation.core.entity.UUIDBaseModel;
import com.doublev2v.foundation.updatable.IdentifiedUpdatable;

@Entity
public class Contact extends UUIDBaseModel implements IdentifiedUpdatable<String, Contact> {
	private String name;
	private String email;
	private String subject;
	private String message;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return the message
	 */
	@Column(length=1000)
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public Contact update(Contact d) {
		d.setEmail(email);
		d.setMessage(message);
		d.setName(name);
		d.setSubject(subject);
		return d;
	}
}
