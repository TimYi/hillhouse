package com.doublev2v.foundation.updatable;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.foundation.core.repository.BaseRepository;
import com.doublev2v.foundation.core.service.BaseService;

public abstract class UpdatableService<PK extends Serializable, D extends IdentifiedUpdatable<PK,D>>
	implements BaseService<PK, D>  {
	
	private BaseRepository<D, PK> repository;
	@Override
	public D add(D d) {
		getRepository().save(d);
		return d;
	}

	@Override
	public D update(D d) {
		PK id=d.getId();
		D origion=getRepository().getItem(id);
		origion=d.update(origion);
		getRepository().update(origion);
		return origion;
	}

	@Override
	public PagedList<D> getPagedList(Integer pageNo, Integer pageSize) {
		return getRepository().getPagedList(pageNo, pageSize);
	}

	@Override
	public D get(PK id) {
		return getRepository().getItem(id);
	}

	@Override
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
}
