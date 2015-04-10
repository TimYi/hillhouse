package com.doublev2v.foundation.dto;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.doublev2v.foundation.core.model.Identified;
import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.foundation.core.repository.BaseRepository;
import com.doublev2v.foundation.core.service.BaseService;

@Transactional
public abstract class DTOService<PK extends Serializable,D,T extends Identified<PK>>
	implements BaseService<PK, T> {
	private BaseRepository<D, PK> repository;
	private DTOAdapter<PK, D, T> adapter;
	
	public T add(T t) {
		D d=adapter.createDO(t);	
		getRepository().save(d);
		t=adapter.updateDTO(t, d);
		return t;
	}
	public T update(T t) {
		PK id=t.getId();
		D d=getRepository().getItem(id);
		d=adapter.updateDO(t, d);	
		getRepository().update(d);
		t=adapter.updateDTO(t, d);
		return t;
	}
	public T get(PK id) {
		D d=getRepository().getItem(id);
		T t=adapter.createDTO(d);
		return t;
	}
	public PagedList<T> getPagedList(Integer pageNo, Integer pageSize) {
		PagedList<D> dList=getRepository().getPagedList(pageNo, pageSize);
		PagedList<T> list=adapter.convertPagedList(dList);
		return list;
	}
	/**
	 * 涉及到媒体操作时需要释放磁盘资源，因此经常需要重写delete方法
	 * @param id
	 */
	public void delete(PK id) {
		getRepository().delete(id);
	}
	
	/**
	 * @return the repository
	 */
	public BaseRepository<D, PK> getRepository() {
		return repository;
	}
	/**
	 * @param repository the repository to set
	 */
	@Autowired
	public void setRepository(BaseRepository<D, PK> repository) {
		this.repository = repository;
	}
	/**
	 * @return the adapter
	 */
	public DTOAdapter<PK, D, T> getAdapter() {
		return adapter;
	}
	/**
	 * @param adapter the adapter to set
	 */
	@Autowired
	public void setAdapter(DTOAdapter<PK, D, T> adapter) {
		this.adapter = adapter;
	}
}
