package com.doublev2v.foundation.model.dto;

/**
 * 使用DO对象初始化自身
 * @author pc
 *
 * @param <T>
 */
public interface DTOInit<T> {
	void init(T t);
}
