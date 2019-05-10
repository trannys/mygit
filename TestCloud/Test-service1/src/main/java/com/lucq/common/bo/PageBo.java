package com.lucq.common.bo;

public class PageBo {

	/**
	 * 每页大小
	 */
	private Integer pageSize = 10;
	
	/**
	 * 第几页
	 */
	private Integer pageNum = 1;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	
	
	
	
}
