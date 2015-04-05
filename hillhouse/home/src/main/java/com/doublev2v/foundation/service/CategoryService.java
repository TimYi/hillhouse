package com.doublev2v.foundation.service;

import java.util.List;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.entity.Category;
import com.doublev2v.foundation.entity.CategoryItem;
import com.doublev2v.foundation.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repository;
	public Category addCategory(String name, String type, String remark) throws IllegalArgumentException {
		Category category=new Category();
		category.setName(name);
		category.setType(type);
		category.setRemark(remark);
		repository.save(category);
		return category;
	}
	public Category addSubCategory(String type, String name, String subType, String remark) throws IllegalArgumentException {
		Category parent=repository.getCategory(type);
		Validate.notNull(parent);
		Category son=new Category();
		son.setName(name);
		son.setType(subType);
		son.setRemark(remark);
		son.setParent(parent);
		repository.save(son);
		return son;
	}
	public Category updateCategory(String type, String name, String subType, String remark) throws IllegalArgumentException {
		Category category=repository.getCategory(type);
		Validate.notNull(category);
		category.setName(name);
		category.setType(subType);
		category.setRemark(remark);
		repository.update(category);
		return category;
	}
	public List<Category> getAll() {
		return repository.getCategories();
	}
	public Category getCategory(String type) {
		return repository.getCategory(type);
	}
	public void deleteCategory(String type) {
		repository.deleteCategory(type);
	}
	public CategoryItem addCategoryItem(String type, String name, String attr, String remark, Integer priority) {
		CategoryItem item=new CategoryItem();
		item.setName(name);
		item.setAttr(attr);
		item.setRemark(remark);
		item.setPriority(priority);
		repository.saveCategoryItem(type, item);
		return item;
	}
	public CategoryItem updateCategoryItem(String id, String name, String attr, String remark, Integer priority) {
		CategoryItem item=repository.getCategoryItem(id);
		Validate.notNull(item);
		item.setName(name);
		item.setAttr(attr);
		item.setRemark(remark);
		item.setPriority(priority);
		repository.updateCategoryItem(item);
		return item;
	}
	public CategoryItem getCategoryItem(String id) {
		return repository.getCategoryItem(id);
	}
	public void deleteCategoryItem(String id) {
		repository.deleteCategoryItem(id);
	}
}
