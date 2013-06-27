package com.zikool.edu.frame.common;

import java.util.List;
import java.util.Map;

public class PageDTO<T> {

	private long rowSize;
	
	private List<T> data;

	private Map<String,Object> otherData;
	
	private int pageIndex = 1;
	
	private int pageSize = GlobalConfigure.DEFAULT_PAGE_SIZE;
	
	private long start;
	
	private long end;
	
	public PageDTO() {
    }

	public PageDTO(Integer pageIndex, Integer pageSize) {
		if(pageIndex == null || pageIndex <= 0) {
			pageIndex = 1;
		}
		if(pageSize == null || pageSize <= 0) {
			pageSize = GlobalConfigure.DEFAULT_PAGE_SIZE;
		}
		if(GlobalConfigure.MAX_PAGE_SIZE < pageSize.intValue()){
			pageSize = GlobalConfigure.MAX_PAGE_SIZE;
		}
		long first = (pageIndex - 1) * pageSize;
		this.pageIndex = pageIndex.intValue();
		this.pageSize = pageSize.intValue();
		if(first < 0){
			first = 0;
		}
		this.start = first;
		this.end = pageIndex*pageSize;
    }

	public long getRowSize() {
    	return rowSize;
    }

	public void setRowSize(long rowSize) {
    	this.rowSize = rowSize;
    }

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getPageIndex() {
    	return pageIndex;
    }

	public void setPageIndex(int pageIndex) {
    	this.pageIndex = pageIndex;
    }

	public int getPageSize() {
    	return pageSize;
    }

	public void setPageSize(int pageSize) {
    	this.pageSize = pageSize;
    }

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}

	public Map<String, Object> getOtherData() {
		return otherData;
	}

	public void setOtherData(Map<String, Object> otherData) {
		this.otherData = otherData;
	}

}
