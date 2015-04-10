package com.hillhouse.home.base;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

public class LanguagePriorityModelRepository<T extends LanguagePriorityModel>
	extends LanguageModelRepository<T> {
	@Override
	protected Criteria addOrder(Criteria criteria) {
		criteria.addOrder(Order.asc("priority"));
		return super.addOrder(criteria);
	}
}
