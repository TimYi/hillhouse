package com.doublev2v.foundation.model.dto;

import java.io.Serializable;

/**
 * 更新Session层DO对象
 * @author pc
 *
 * @param <T>
 */
public interface DTOUpdate<T,PK extends Serializable> {
	PK getId();
	T update(T t);
}
