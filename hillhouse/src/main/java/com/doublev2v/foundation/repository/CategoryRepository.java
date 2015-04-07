package com.doublev2v.foundation.repository;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.doublev2v.foundation.entity.Category;
import com.doublev2v.foundation.entity.CategoryItem;

@Repository
public class CategoryRepository extends BaseModelRepository<Category, String> {
	
	public Category getCategory(String type) {
		Criteria criteria=getCriteria();
		criteria.add(Restrictions.eq("type", type));
		Category category=(Category)criteria.uniqueResult();
		return category;
	}
	
	public List<Category> getCategories() {
		Criteria criteria=getCriteria();
		criteria.add(Restrictions.isNull("parent"));
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}
	
	public void deleteCategory(String type) {
		Category category=getCategory(type);
		delete(category);
	}
	
	public CategoryItem getCategoryItem(String id) {
		Object object=getSession().get(CategoryItem.class, id);
		return (CategoryItem)object;
	}
	
	public Set<CategoryItem> getCategoryItems(String type) {
		Category category=getCategory(type);
		Validate.notNull(category);
		return category.getItems();
	}
	
	public void saveCategoryItem(String type, CategoryItem item) {
		Category category=getCategory(type);
		if(category==null) {
			throw new IllegalArgumentException("type "+type+" is not found");
		}
		item.setCategory(category);
		getSession().saveOrUpdate(item);
	}
	
	public void updateCategoryItem(CategoryItem item) {
		getSession().update(item);
	}
	
	public void deleteCategoryItem(String id) {
		CategoryItem item=getCategoryItem(id);
		getSession().delete(item);
	}
	
	public void addSubCategory(String parentId, Category son) {
		Category parent=getItem(parentId);
		addSubCategory(parent, son);
	}
	
	public void addSubCategory(Category parent, Category son) {
		son.setParent(parent);
		saveOrUpdate(son);
	}
}
