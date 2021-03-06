package com.hillhouse.home.base;

import javax.persistence.MappedSuperclass;

/**
 * 增加排序字段，方便人工排序
 * @author pc
 *
 */
@MappedSuperclass
public class LanguagePriorityModel extends LanguageModel {
	private Integer priority;

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
	
}
