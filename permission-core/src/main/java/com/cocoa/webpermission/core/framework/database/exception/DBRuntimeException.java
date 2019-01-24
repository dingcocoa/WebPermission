package com.cocoa.webpermission.core.framework.database.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DBRuntimeException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4418671322501596633L;
	private static final Log logger=LogFactory.getLog(DBRuntimeException.class);
	public DBRuntimeException(String msg,String sql) {
		super(msg);
		if(logger.isErrorEnabled()){
			logger.error("数据库运行出错，sql+"+ sql);
		}
	}
	public DBRuntimeException(Exception e,String sql) {
		super(e);
		if(logger.isErrorEnabled()){
			logger.error("数据库运行出错，sql+"+ sql);
		}
	}
	public DBRuntimeException(String msg) {
		super(msg);
	}
}
