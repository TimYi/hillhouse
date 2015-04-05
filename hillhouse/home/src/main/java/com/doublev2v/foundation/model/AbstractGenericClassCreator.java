package com.doublev2v.foundation.model;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class AbstractGenericClassCreator<T> implements GenericClassCreator<T> {
	protected Class<T> getTClass() {
		Type[] types=((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments();
		Class<T> classT=(Class<T>)types[0];
		return classT;
	}
	@Override
	public T create() {
		try {
			return getTClass().newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
	}
}
