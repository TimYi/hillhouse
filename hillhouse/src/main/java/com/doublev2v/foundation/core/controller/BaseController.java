package com.doublev2v.foundation.core.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.doublev2v.foundation.core.model.Identified;
import com.doublev2v.foundation.core.service.BaseService;

/**
 * Controller基类
 * @author pc
 *
 */
public abstract class BaseController<PK extends Serializable,T extends Identified<PK>> {
	
	private BaseService<PK, T> baseService;	
	
	/**
	 * @return the baseService
	 */
	public BaseService<PK, T> getBaseService() {
		return baseService;
	}
	/**
	 * @param baseService the baseService to set
	 */
	@Autowired
	public void setBaseService(BaseService<PK, T> baseService) {
		this.baseService = baseService;
	}	
}
