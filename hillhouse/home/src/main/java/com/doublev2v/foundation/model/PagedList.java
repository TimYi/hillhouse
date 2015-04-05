package com.doublev2v.foundation.model;

import java.util.List;

/**
 * 分页器，
 * @author pc
 *
 * @param <T>
 */
public class PagedList<T> {
	private int totalCount;
	private int totalPages;
	private int pageNo;
	private int pageSize;
	private List<T> result;
	
	/**
	 * 初始化时判断总页数totalPages，实际当前页pageNo
	 * @param totalCount
	 * @param pageNo
	 * @param pageSize
	 */
	public PagedList(Integer totalCount, Integer pageNo, Integer pageSize) {
		if(totalCount==null) {
			totalCount=0;
		}
		if(pageNo==null || pageNo<=0) {
			pageNo=1;
		}
		if(pageSize==null || pageSize<=0) {
			pageSize=1;
		}
		this.totalCount=totalCount;
		this.pageSize=pageSize;
		int pages=totalCount/pageSize;
		int remain=totalCount%pageSize;
		if(remain>0) {
			this.totalPages=pages+1;				
		} else {
			this.totalPages=pages;
		}
		if(totalCount<=(pageNo-1)*pageSize) {
			this.pageNo=totalPages;
		}else {
			this.pageNo=pageNo;
		}
	}
	/**
	 * 获取开始的数据位置（包括）
	 * @return
	 */
	public int getStartNumber() {
		if(this.pageNo<=1) {
			return 0;
		}
		return (this.pageNo-1)*this.pageSize+1;
	}
	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}
	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	/**
	 * @return the totalPages
	 */
	public long getTotalPages() {
		return totalPages;
	}
	/**
	 * @param totalPages the totalPages to set
	 */
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	/**
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}
	/**
	 * @param pageNo the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * @return the result
	 */
	public List<T> getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(List<T> result) {
		this.result = result;
	}
	
}
