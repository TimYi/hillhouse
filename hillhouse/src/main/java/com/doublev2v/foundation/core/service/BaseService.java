package com.doublev2v.foundation.core.service;

import java.io.Serializable;
import java.util.List;

import com.doublev2v.foundation.core.model.Identified;
import com.doublev2v.foundation.core.model.PagedList;

public interface BaseService<PK extends Serializable,T extends Identified<PK>> {
	/**
	 * 添加新实体，并将添加后的实体返回
	 * @param t
	 * @return
	 */
	T add(T t);
	/**
	 * 更新实体
	 * @param t
	 * @return
	 */
	T update(T t);
	/**
	 * 获取实体列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	PagedList<T> getPagedList(Integer pageNo, Integer pageSize);
	/**
	 * 根据id获取实体
	 * @param id
	 * @return
	 */
	T get(PK id);
	/**
	 * 根据id删除实体
	 * @param id
	 */
	void delete(PK id);
	/**
	 * 获取全部实体
	 * @return
	 */
	List<T> getAll();
}
