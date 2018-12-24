package com.cocoa.webpermission.core.framework.plugin;

/**
 * 可被异步调用接口
 * 实现此接口的插件，可通过如下url来调用：
 * /plugin/execPlugin?pluginId=pluginId 
 * @author CocoaDing
 * created on 2018年12月21日 下午12:07:55	
 *
 */
public interface AsyncExecuteEnable {
	
	/**
	 * 异步调用时调用此方法 
	 * @return
	 */
	public String execute();
	
}
