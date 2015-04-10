package com.hillhouse.home.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.doublev2v.foundation.core.model.Identified;
import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.foundation.dto.DTOService;
import com.doublev2v.foundation.media.MediaService;
import com.hillhouse.home.base.LanguageModel.Language;

@Transactional
public class LanguageDTOService<D extends LanguageModel, T extends Identified<String>> extends DTOService<String, D, T> {
	@Autowired
	protected MediaService mediaService;
	@Autowired
	public void setLanguageRepository(LanguageModelRepository<D> repository) {
		setRepository(repository);
	}
	@Override
	public LanguageModelRepository<D> getRepository() {
		return (LanguageModelRepository<D>)super.getRepository();
	}

	public PagedList<T> getPagedList(Integer pageNo, Integer pageSize, Language language) {
		PagedList<D> dList=getRepository().getPagedList(pageNo, pageSize, language);
		PagedList<T> tList=getAdapter().convertPagedList(dList);
		return tList;
	}
}
