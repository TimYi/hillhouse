package com.doublev2v.foundation.dto;

import java.io.Serializable;

import com.doublev2v.foundation.core.model.Identified;
import com.doublev2v.foundation.core.model.PagedList;

public interface DTOAdapter<PK extends Serializable, D, T extends Identified<PK>> {
	T createDTO(D d);
	T updateDTO(T t, D d);
	D createDO(T t);
	D updateDO(T t, D d);
	PagedList<T> convertPagedList(PagedList<D> dList);
}
