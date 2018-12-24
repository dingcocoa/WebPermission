package com.cocoa.webpermission.core.framework.util;

public class StringUtils {

	public static boolean isEmpty(String str) {
		if(null==str) {
			return true;
		}
		if(str.length()==0||str.trim().length()==0) {
			return true;
		}
		return false;
	}
}
