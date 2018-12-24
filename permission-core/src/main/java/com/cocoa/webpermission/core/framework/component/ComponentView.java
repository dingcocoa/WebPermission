package com.cocoa.webpermission.core.framework.component;

import java.util.ArrayList;
import java.util.List;


public class ComponentView implements Cloneable {

	public ComponentView() {
		pluginList = new ArrayList<PluginView>();

	}
	
	private String name;
	private int id;
	private String componentid;
	private String version;
	private String system_version;
	private String author;
	private String description;

	private Component component;
	
	private List<PluginView> pluginList;


	private int install_state; // 0未安装 1已安装
	private int enable_state; // 0未启动（停止 ） 1已启动 2错误
	private String error_message; // 错误信息

	public void addPlugin(PluginView plugin) {
		this.pluginList.add(plugin);
	}

 
	public void setComponent(Component component) {
		this.component = component;
	}

	public Component getComponent() {
		return component;
	}

	public List<PluginView> getPluginList() {
		return pluginList;
	}

	public void setPluginList(List<PluginView> pluginList) {
		this.pluginList = pluginList;
	}



	public int getInstall_state() {
		return install_state;
	}

	public void setInstall_state(int install_state) {
		this.install_state = install_state;
	}

	public int getEnable_state() {
		return enable_state;
	}

	public void setEnable_state(int enable_state) {
		this.enable_state = enable_state;
	}

	public String getError_message() {
		return error_message;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComponentid() {
		return componentid;
	}

	public void setComponentid(String componentid) {
		this.componentid = componentid;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSystem_version() {
		return system_version;
	}

	public void setSystem_version(String system_version) {
		this.system_version = system_version;
	}


	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public Object clone() {

		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}

	}

}
