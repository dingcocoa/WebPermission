package com.cocoa.webpermission.core.framework.component;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.cocoa.webpermission.core.framework.component.context.ComponentContext;
import com.cocoa.webpermission.core.framework.plugin.AutoRegisterPlugin;
import com.cocoa.webpermission.core.framework.plugin.PluginBundle;


public class ComponentLoader implements BeanPostProcessor {

	
	public Object postProcessAfterInitialization(Object bean, String arg1)
			throws BeansException {
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		if(bean instanceof AutoRegisterPlugin){
			AutoRegisterPlugin plugin =  (AutoRegisterPlugin)bean;
			if(plugin.getBundleList()==null){
			}else{
				//plugin.register();
				List<PluginBundle> pluginBundelList = plugin.getBundleList();
				for( PluginBundle bundle :pluginBundelList){
					bundle.registerPlugin(plugin);
				}
			}
		}
		
		if(bean instanceof Component){
		 
			Component component = (Component)bean;
			ComponentView componentView = new ComponentView();
			componentView.setComponent(component);
			componentView.setComponentid( beanName );
			ComponentContext.registerComponent(componentView);
		}
		
		return bean;
	}

}
