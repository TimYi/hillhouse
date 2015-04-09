package com.hillhouse.home.entity;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.doublev2v.foundation.model.PagedList;
import com.doublev2v.foundation.repository.BaseModelRepository;
import com.hillhouse.home.entity.LanguageModel.Language;

public class LanguageModelRepository<T extends LanguageModel,PK extends Serializable> extends BaseModelRepository<T, PK> {
	public PagedList<T> getPagedList(Integer pageNo, Integer pageSize, Language language) {
		Criteria criteria=getCriteria();
		criteria.add(Restrictions.eq("language", language));
		return getPagedList(criteria, pageNo, pageSize);
	}
}
