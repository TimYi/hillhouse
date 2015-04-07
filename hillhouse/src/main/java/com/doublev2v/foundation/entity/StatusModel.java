package com.doublev2v.foundation.entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import com.doublev2v.foundation.model.YesOrNoStatus;

/**
 * 经常有不需要在物理数据库删除的model，采用此模型标记为Delete
 * @author pc
 *
 */
@MappedSuperclass
public class StatusModel extends BaseModel {
	
	private YesOrNoStatus isDeleted;
	
	public StatusModel() {
		this.isDeleted=YesOrNoStatus.NO;
	}

	/**
	 * @return the deleteStatus
	 */
	@Enumerated(value=EnumType.STRING)
	public YesOrNoStatus getDeleteStatus() {
		return isDeleted;
	}

	/**
	 * @param deleteStatus the deleteStatus to set
	 */
	public void setDeleteStatus(YesOrNoStatus deleteStatus) {
		this.isDeleted = deleteStatus;
	}
	
	
}
