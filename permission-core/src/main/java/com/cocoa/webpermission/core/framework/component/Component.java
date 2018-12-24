package com.cocoa.webpermission.core.framework.component;
/**
 * 组件接口
 * @author CocoaDing
 * created on 2018年12月21日 下午12:12:23	
 *
 */
public interface Component {
	
	
	/**
	 * 组件被安装时调用此方法
	 */
	public void install();
	
	
	/**
	 * 组件卸载时调用此方法 
	 */
	public void unInstall();
	
}
