package com.hillhouse.home.base;

public abstract class LanguagePriorityMediaDTOAdapter
	<D extends LanguagePriorityModel, T extends LanguagePriorityModel>
	extends LanguageMediaDTOAdapter<D, T> {
	@Override
	protected D postProcessDO(T t, D d) {
		d=super.postProcessDO(t, d);
		d.setPriority(t.getPriority());
		return d;
	}
	@Override
	protected T postProcessDTO(D d, T t) {
		t=super.postProcessDTO(d, t);
		t.setPriority(d.getPriority());
		return t;
	}
}
