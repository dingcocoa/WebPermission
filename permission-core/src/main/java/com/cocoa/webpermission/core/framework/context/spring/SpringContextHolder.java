package com.cocoa.webpermission.core.framework.context.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextHolder implements ApplicationContextAware{
	private static ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextHolder.applicationContext=applicationContext;
	}
	public static ApplicationContext getApplicationContext() {
		check();
		return applicationContext;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name){
		check();
		return (T)applicationContext.getBean(name);
	}
	
	public static <T> T getBean(Class<T> clazz){
		check();
		return (T)applicationContext.getBean(clazz);
	}
	
	public static void cleanApplicationContext(){
		applicationContext=null;
	}
	
	private static void check(){
		if(null==applicationContext){
			throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");
		}
	}
}
