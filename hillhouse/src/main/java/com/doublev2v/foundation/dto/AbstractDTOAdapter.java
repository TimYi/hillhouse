package com.doublev2v.foundation.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.doublev2v.foundation.core.model.Identified;
import com.doublev2v.foundation.core.model.PagedList;

public abstract class AbstractDTOAdapter<PK extends Serializable,D,T extends Identified<PK>>
	implements DTOAdapter<PK, D, T> {
	
	/**
	 * 用于继承链中处理共性操作
	 * @param t
	 * @param d
	 * @return
	 */
	protected D postProcessDO(T t, D d){
		return d;
	}
	/**
	 * 用于继承链中处理共性操作
	 * @param d
	 * @param t
	 * @return
	 */
	protected T postProcessDTO(D d, T t){
		return t;
	}
	
	@Override
	public PagedList<T> convertPagedList(PagedList<D> dList) {
		Integer totalCount=dList.getTotalCount();
		Integer pageNo=dList.getPageNo();
		Integer pageSize=dList.getPageSize();
		PagedList<T> tList=new PagedList<T>(totalCount, pageNo, pageSize);
		List<D> data=dList.getResult();
		List<T> result;
		if(data==null) {
			result=null;
		} else {
			result=new ArrayList<T>();
			for (D d : data) {
				T t=createDTO(d);
				result.add(t);
			}
		}
		tList.setResult(result);
		return tList;
	}
	
	@Override
	public final D createDO(T t) {
		D d=preCreateDO(t);
		return postProcessDO(t, d);
	}
	/**
	 * 实际的生成实现
	 * @param t
	 * @return
	 */
	protected abstract D preCreateDO(T t);
	
	@Override
	public final T createDTO(D d) {
		T t=preCreateDTO(d);
		return postProcessDTO(d, t);
	}
	/**
	 * 实际更新实现
	 * @param d
	 * @return
	 */
	protected abstract T preCreateDTO(D d);
	
	@Override
	public final D updateDO(T t, D d) {
		d=preUpdateDO(t, d);
		return postProcessDO(t, d);
	}
	/**
	 * 实际生成实现
	 * @param t
	 * @param d
	 * @return
	 */
	protected  abstract D preUpdateDO(T t, D d);
	@Override
	public final T updateDTO(T t, D d) {
		t=preUpdateDTO(t, d);
		return postProcessDTO(d, t);
	}
	/**
	 * 实际更新实现
	 */
	protected abstract T preUpdateDTO(T t, D d);
}
