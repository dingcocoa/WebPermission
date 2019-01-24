package com.cocoa.webpermission.core.framework.database.annotation;
/**
 * 标识为数据库字段
 * @author CocoaDing
 * created on 2018年12月26日 下午2:51:23	
 *
 */
public @interface DbField {
	public String value() default "";
	public String type();
}
