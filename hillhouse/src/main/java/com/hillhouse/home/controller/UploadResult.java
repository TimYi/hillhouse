package com.hillhouse.home.controller;

import com.doublev2v.foundation.core.util.JsonSerializer;

public class UploadResult {
	private Integer error;
	private String url;
	private String message;
	/**
	 * @return the error
	 */
	public Integer getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(Integer error) {
		this.error = error;
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
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	private UploadResult(){}
	public static UploadResult failResult(String message) {
		UploadResult result=new UploadResult();
		result.setError(1);
		result.setMessage(message);
		return result;
	}
	
	public static UploadResult successResult(String url) {
		UploadResult result=new UploadResult();
		result.setError(0);
		result.setUrl(url);
		return result;
	}
	
	public String toJson() {
		try {
			return JsonSerializer.Serialize(this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
	}
}
