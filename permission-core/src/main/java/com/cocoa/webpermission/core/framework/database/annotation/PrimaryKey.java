package com.cocoa.webpermission.core.framework.database.annotation;
/**
 * 标识为主键
 * @author CocoaDing
 * created on 2018年12月26日 下午2:48:20	
 *
 */
public @interface PrimaryKey {
	/**
	 * 当属性名和数据库名称不一样时需要value
	 * @return
	 */
	public String value() default "";
}
