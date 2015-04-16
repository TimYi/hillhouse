package com.hillhouse.home.deploy;

import javax.persistence.Entity;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.doublev2v.foundation.core.entity.UUIDBaseModel;

@Entity
public class DeployConfig extends UUIDBaseModel {
	
	private static DeployConfig config;
	private static Configuration configuration;
	
	public static DeployConfig getConfig() {
		try {
			configuration=new PropertiesConfiguration("deploy.properties");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		if(config==null){
			DeployConfig config=new DeployConfig();
			config.basePath=configuration.getString("basePath");
			config.siteUrl=configuration.getString("siteUrl");
			config.appName=configuration.getString("appName");
			config.newAppName=configuration.getString("newAppName");
		}
		return config;
	}
	private String siteUrl;
	private String basePath;
	private String appName;
	private String newAppName;
	/**
	 * @return the siteUrl
	 */
	public String getSiteUrl() {
		return siteUrl;
	}
	/**
	 * @param siteUrl the siteUrl to set
	 */
	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
		configuration.setProperty("siteUrl", siteUrl);
	}
	/**
	 * @return the baseUrl
	 */
	public String getBasePath() {
		return basePath;
	}
	/**
	 * @param baseUrl the baseUrl to set
	 */
	public void setBasePath(String basePath) {
		this.basePath = basePath;
		configuration.setProperty("basePath", basePath);
	}
	/**
	 * @return the appName
	 */
	public String getAppName() {
		return appName;
	}
	/**
	 * @param appName the appName to set
	 */
	public void setAppName(String appName) {
		this.appName = appName;
		configuration.setProperty("appName", appName);
	}
	/**
	 * @return the newAppName
	 */
	public String getNewAppName() {
		return newAppName;
	}
	/**
	 * @param newAppName the newAppName to set
	 */
	public void setNewAppName(String newAppName) {
		this.newAppName = newAppName;
		configuration.setProperty("newAppName", newAppName);
	}
	
}
