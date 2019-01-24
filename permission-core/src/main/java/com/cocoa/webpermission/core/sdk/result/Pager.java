package com.cocoa.webpermission.core.sdk.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 通用返回分页结果
 * @author CocoaDing
 * created on 2018年12月26日 上午10:30:17	
 *
 */
public class Pager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2812076673210379718L;

	/**
	 * 每页条数
	 */
	private int pageSize=defaultPageSize;
	private static int defaultPageSize=20;
	/**
	 * 数据集合
	 */
	private List<Object> data;
	/**
	 * 总条数
	 */
	private long totalCount;
	/**
	 * 当前页
	 */
	private int nowPage;
	
	public Pager() {
		this(defaultPageSize,new ArrayList<Object>(),0,0);
	}
	public void setParams(int pageSize, List<Object> data, long totalCount, int nowPage) {
		this.pageSize = pageSize;
		this.data = data;
		this.totalCount = totalCount;
		this.nowPage = nowPage;
	}
	
	public Pager(int pageSize, List<Object> data, long totalCount, int nowPage) {
		setParams(pageSize,data,totalCount,nowPage);
	}


	public long getTotalPageNum() {
		if(totalCount%pageSize==0) {
			return totalCount/pageSize;
		}else {
			return totalCount/pageSize+1;
		}
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<Object> getData() {
		return data;
	}
	public void setData(List<Object> data) {
		this.data = data;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	
	
	

}
