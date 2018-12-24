package com.cocoa.webpermission.core.framework.util;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLUtil {
	private XMLUtil() {}
	public static Element getChildByTagName(Node node,String tagName) {
		Element child=null;
		if(node.getNodeType()!=Node.ELEMENT_NODE) {
			throw new RuntimeException(node.getNodeName()+"节点非Element类型");
		}
		NodeList nodes= ((Element)node).getElementsByTagName(tagName);
		if(null!=nodes&&nodes.getLength()>0) {
			child=(Element)nodes.item(0);
		}
		return child;
	}
}
