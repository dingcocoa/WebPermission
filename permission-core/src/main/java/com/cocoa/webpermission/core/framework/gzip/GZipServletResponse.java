package com.cocoa.webpermission.core.framework.gzip;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class GZipServletResponse extends HttpServletResponseWrapper {
	private HttpServletResponse baseResponse;
	private ServletOutputStream stream;
	private PrintWriter writer;
	public GZipServletResponse(HttpServletResponse response) {
		super(response);
		this.baseResponse=response;
	}

	private ServletOutputStream createServletOutputStream() throws IOException {
		return (new GzipServletOutputStream(baseResponse));
	}
	
	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		if(null!=writer) {
			throw new IllegalStateException("getWriter() has already been called for this response");
		}
		if(stream==null) {
			stream=createServletOutputStream();
		}
		return stream;
	}
	
	@Override
	public void flushBuffer() throws IOException {
		// TODO Auto-generated method stub
		stream.flush();
	}
	
	@Override
	public PrintWriter getWriter() throws IOException {
		// TODO Auto-generated method stub
		if(writer!=null) {
			return writer;
		}
		if(stream!=null) {
			throw new IllegalStateException("getOutputStream() has  already been called for this response");
		}
		stream=createServletOutputStream();
		writer=new PrintWriter(new OutputStreamWriter(stream,"utf-8"));
		return writer;
	}
	
	

}
