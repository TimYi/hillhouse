package com.doublev2v.foundation.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "category",
	indexes=@Index(name="type_index",columnList="type")
)
public class Category extends BaseModel {
	private String id;
	private String name;
	@JsonIgnore
	private String remark;
	private Set<CategoryItem> items;
	@JsonIgnore
	private String type;
	@JsonIgnore
	private Category parent;
	private Set<Category> subCategories;

	@JsonIgnore
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

	@OneToMany(mappedBy="category",fetch=FetchType.EAGER)
	@OrderBy("priority")
	public Set<CategoryItem> getItems() {
		return items;
	}

	public void setItems(Set<CategoryItem> items) {
		this.items = items;
	}

	/**
	 * @return the type
	 * 用于根据类别查询
	 */
	@Column(nullable=false,unique=true)
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the parent
	 */
	@ManyToOne
	@JoinColumn(name="parent_id")
	public Category getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(Category parent) {
		this.parent = parent;
	}

	/**
	 * @return the subCategories
	 */
	@OneToMany(mappedBy="parent",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	public Set<Category> getSubCategories() {
		return subCategories;
	}

	/**
	 * @param subCategories the subCategories to set
	 */
	public void setSubCategories(Set<Category> subCategories) {
		this.subCategories = subCategories;
	}	
}
