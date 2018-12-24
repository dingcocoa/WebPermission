package com.cocoa.webpermission.core.framework.util;

import java.io.IOException;
import java.io.InputStream;

public class FileUtil {
	public static InputStream getResourceAsStream(String path)throws IOException {
		if(path.startsWith("/")) {
			path=path.substring(1);
		}
		InputStream inputStream=Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
		return inputStream;
	}
}
