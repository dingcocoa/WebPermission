package com.cocoa.webpermission.core.framework.plugin;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 自动注册插件桩
 * @author CocoaDing
 * created on 2018年12月21日 下午12:08:27	
 *
 */
public abstract class AutoRegisterPluginsBundle implements PluginBundle {
	
	protected static final Log loger = LogFactory.getLog(AutoRegisterPluginsBundle.class);
	private List<Plugin> plugins;

	/**
	 * 获取此插件列表
	 * @return
	 */
	public synchronized List<Plugin> getPlugins() {
		return plugins;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.enation.framework.plugin.IPluginBundle#registerPlugin(com.enation.framework.plugin.IPlugin)
	 */
	@Override
	public synchronized void registerPlugin(Plugin plugin) {
		this.registerPlugin1(plugin);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.enation.framework.plugin.IPluginBundle#unRegisterPlugin(com.enation.framework.plugin.IPlugin)
	 */
	@Override
	public synchronized void unRegisterPlugin(Plugin _plugin) {

		if (plugins != null) {
			plugins.remove(_plugin);
		}
			
	}
	/**
	 * 注册插件，将某插件插到某桩下
	 * @param plugin 插件
	 */
	private void registerPlugin1(Plugin plugin) {
		
		if (plugins == null) {
			plugins = new ArrayList<Plugin>();
		}
		
		// 判断插件是否已经插入插件桩
		if (!plugins.contains(plugin)) {
			plugins.add(plugin);
		}

		if (loger.isDebugEnabled()) {
			loger.debug("为插件桩" + getName() + "注册插件：" + plugin.getClass());
		}
	}
	abstract public String getName();

}
