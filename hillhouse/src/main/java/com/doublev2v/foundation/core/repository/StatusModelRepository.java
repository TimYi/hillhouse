package com.doublev2v.foundation.core.repository;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.doublev2v.foundation.core.entity.StatusModel;
import com.doublev2v.foundation.core.enums.YesOrNoStatus;

/**
 * 在查询时，只显示未删除的数据。
 * 需要进一步定制，以确保在查询时区分显示未删除数据、已删除数据和全部数据，并提供相应接口。
 */
public class StatusModelRepository<T extends StatusModel, PK extends Serializable>
	extends BaseModelRepository<T, PK> {	
	
	@Override
	public void delete(T t) {
		t.setDeleteStatus(YesOrNoStatus.YES);
		super.update(t);
	}
	
	@Override
	public void delete(PK id) {
		T t=getItem(id);
		delete(t);
	}
	
	/**
	 * 彻底删除数据库中数据
	 * @param t
	 */
	public void remove(T t) {
		super.delete(t);
	}
	
	@Override
	protected Criteria getCriteria() {
		return getCriteria(false);
	}
	
	protected Criteria getCriteria(boolean all) {
		Criteria criteria=super.getCriteria();
		if(!all) {
			criteria.add(Restrictions.eq("isDeleted", YesOrNoStatus.NO));
		}
		return criteria;
	}
}
