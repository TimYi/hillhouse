package com.doublev2v.foundation.core.repository;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

import com.doublev2v.foundation.core.entity.BaseModel;

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
	/**
	 * 默认按时间倒序排列
	 */
	@Override
	protected Criteria addOrder(Criteria criteria) {
		criteria.addOrder(Order.desc("updateTime"));
		return criteria;
	}
}
