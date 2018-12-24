package com.cocoa.webpermission.core.framework.plugin;

/**
 * 插件接口<br/> 实现此接口的插件可被注册至通过PluginBundle桩化的业务类中。<br/> 推荐插件注册的实现方法：<br/>
 * 插件实现体构造函数为：<br/> public Constructor(PluginBundle pluginBundle){<br />
 * pluginAble.registerPlugin(this); <br /> }
 * 
 * 
 * 利用如此的构造函数可实现插件本身的注册, 如果通过Spring IoC 方式注入则配置如下：<br/>
 * 
 * &lt;bean id=&quot;plugin&quot; class=&quot;package.PluginClass&quot;
 * lazy-init=&quot;false&quot;&gt;<br />
 * &lt;constructor-arg&gt;<br />
 * &lt;ref bean=&quot;plugin&quot;/&gt;<br />
 * &lt;/constructor-arg&gt; <br />
 * &lt;/bean&gt;
 * @author CocoaDing
 * created on 2018年12月20日 下午5:57:49	
 *
 */
public interface Plugin {

 
	

}
