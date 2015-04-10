package com.hillhouse.home.base;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.foundation.core.repository.BaseModelRepository;
import com.hillhouse.home.base.LanguageModel.Language;

public class LanguageModelRepository<T extends LanguageModel> extends BaseModelRepository<T, String> {
	public PagedList<T> getPagedList(Integer pageNo, Integer pageSize, Language language) {
		Criteria criteria=getCriteria();
		restrictLanguage(criteria, language);
		addOrder(criteria);
		return getPagedList(criteria, pageNo, pageSize);
	}
	protected Criteria restrictLanguage(Criteria criteria, Language language) {
		criteria.add(Restrictions.eq("language", language));
		return criteria;
	}
}
