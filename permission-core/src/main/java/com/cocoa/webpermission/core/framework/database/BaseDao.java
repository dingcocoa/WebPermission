package com.cocoa.webpermission.core.framework.database;

public interface BaseDao {
	public void insert(Object t);
	public <T> T getById(String id,T t);
	public <T> void update(T t);
}
