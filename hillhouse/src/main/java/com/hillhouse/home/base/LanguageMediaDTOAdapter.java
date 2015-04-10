package com.hillhouse.home.base;

public abstract class LanguageMediaDTOAdapter<D extends LanguageModel, T extends LanguageModel>
	extends MediaDTOAdapter<String, D, T> {
	@Override
	protected D postProcessDO(T t, D d) {
		d.setLanguage(t.getLanguage());
		return d;
	}
	
	@Override
	protected T postProcessDTO(D d, T t) {
		t.setLanguage(d.getLanguage());
		return t;
	}
}
