package com.doublev2v.foundation.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * Hibernate存储基本模型
 * @author pc
 *
 */
@MappedSuperclass
public abstract class BaseModel {
	private Date createTime;
	private Date updateTime;
	private Integer version;
	public BaseModel() {
		createTime=new Date();
		updateTime=new Date();
		version=0;
	}
	/**
	 * @return the createTime
	 */
	@Column(updatable=false)
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the modifyTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param modifyTime the modifyTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 详情请见Hibernate乐观锁，用于控制并发访问。
	 * @return the version
	 */
	@Version
	public Integer getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
}
