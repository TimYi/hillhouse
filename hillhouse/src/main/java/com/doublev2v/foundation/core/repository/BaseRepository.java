package com.doublev2v.foundation.core.repository;

import java.io.Serializable;
import java.util.List;

import com.doublev2v.foundation.core.model.PagedList;

/**
 * 基础数据仓库，为某种类型的数据提供基础持久化服务。
 * @author pc
 *
 * @param <T>
 */
public interface BaseRepository<T,PK extends Serializable> {
	Integer getSize();
	T getItem(PK id);
	void save(T t);
	void update(T t);
	void merge(T t);
	void delete(T t);
	void delete(PK id);
	void saveOrUpdate(T t);
	List<T> getAll();
	List<T> getList(int startNumber, int size);
	PagedList<T> getPagedList(Integer pageNo, Integer pageSize);
}
