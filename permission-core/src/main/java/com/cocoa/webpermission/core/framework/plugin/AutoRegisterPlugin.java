package com.cocoa.webpermission.core.framework.plugin;

import java.util.List;

import org.apache.log4j.Logger;
/**
 * 自动注册插件
 * @author CocoaDing
 * created on 2018年12月21日 下午12:08:10	
 *
 */
public abstract class AutoRegisterPlugin implements Plugin {
	
	protected final Logger logger = Logger.getLogger(getClass());
	protected List<PluginBundle> bundleList;
	private boolean isEnable =false;
	
	public List<PluginBundle> getBundleList() {
		return bundleList;
	}

	public void setBundleList(List<PluginBundle> bundleList) {
		this.bundleList = bundleList;
	} 
	
	public void disable(){
		this.isEnable=false;
	}
	
	public void enable(){
		this.isEnable =true;
	}
	
	public boolean getIsEnable(){
		return this.isEnable;
	}
	 
}
