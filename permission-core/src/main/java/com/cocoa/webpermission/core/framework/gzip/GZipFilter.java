package com.cocoa.webpermission.core.framework.gzip;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 支持Gzip压缩的浏览器，返回压缩网页，节省带宽和文件大小
 * @author CocoaDing
 * created on 2018年12月25日 上午9:42:07	
 *
 */
public class GZipFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if(request instanceof HttpServletRequest) {
			HttpServletRequest req=(HttpServletRequest)request;
			HttpServletResponse resp=(HttpServletResponse)response;
			String acceptCompress=req.getHeader("accept-encoding");
			if(null!=acceptCompress&&acceptCompress.toLowerCase().indexOf("gzip")!=-1) {
				GZipServletResponse gzipResponse=new GZipServletResponse(resp);
				chain.doFilter(req, gzipResponse);
				return;
			}
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
