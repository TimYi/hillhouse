package com.doublev2v.foundation.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.doublev2v.foundation.entity.BaseModel;
import com.doublev2v.foundation.entity.Category;

/**
 * 在更新时，确保将updateTime更新
 * @author pc
 *
 * @param <T>
 * @param <PK>
 */
public class BaseModelRepository<T extends BaseModel, PK extends Serializable>
	extends HibernateRepository<T, PK> {
	@Override
	public void saveOrUpdate(T t) {
		t.setUpdateTime(new Date());
		super.saveOrUpdate(t);
	}
	@Override
	public void update(T t) {
		t.setUpdateTime(new Date());
		super.update(t);
	}
}
