package com.cocoa.webpermission.core.sdk.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.cocoa.webpermission.core.context.SystemConfig;
import com.cocoa.webpermission.core.context.SystemSettings;
import com.cocoa.webpermission.core.context.SystemSite;
import com.cocoa.webpermission.core.framework.component.ComponentManager;
import com.cocoa.webpermission.core.framework.context.spring.SpringContextHolder;

public class ContextLoaderListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		if(SystemConfig.INTSALLED) {
			SystemSettings.load();
			SystemSite.load();
			//启动组件
			ComponentManager componentManager=SpringContextHolder.getBean("componentManager");
			componentManager.startComponents();
		}
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
