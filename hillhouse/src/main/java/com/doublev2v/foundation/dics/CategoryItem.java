package com.doublev2v.foundation.dics;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.doublev2v.foundation.core.entity.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

//@Entity
@Table(name = "categoryitem")
public class CategoryItem extends BaseModel {
	private String id;
	private String name;
	private String attr;            // 属性，对于颜色，此处显示颜色代码，例如#FFFFFF
	@JsonIgnore
	private String attr2;           // 其他属性信息
	@JsonIgnore
	private String remark; 	        // 描述
	@JsonIgnore
	private Category category;      // 所属分类
	@JsonIgnore
	private Integer priority;

	@ManyToOne(optional=false)
	@JoinColumn(name = "category_id")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Id
	@GenericGenerator(name="idGenerator", strategy="uuid")
	@GeneratedValue(generator = "idGenerator")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getAttr() {
		return attr;
	}

	public void setAttr(String attr) {
		this.attr = attr;
	}
	
	public String getAttr2() {
		return attr2;
	}

	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}
	
	@JsonIgnore
	@Transient
	public String getType() {
		return category.getType();
	}

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
