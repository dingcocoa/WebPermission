package com.cocoa.webpermission.core.framework.gzip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;

public class GzipServletOutputStream extends ServletOutputStream{
	private HttpServletResponse response;
	private GZIPOutputStream outPutStream;
	private ByteArrayOutputStream out;
	private boolean closed=false;
	private ServletOutputStream output;
	public GzipServletOutputStream(HttpServletResponse response) throws IOException {
		this.response=response;
		this.closed=false;
		this.output=response.getOutputStream();
		this.out=new ByteArrayOutputStream();
		this.outPutStream=new GZIPOutputStream(out);
	}
	
	
	@Override
	public void close() throws IOException {
		if(closed) {
			throw new IllegalStateException("this output stream has already been closed");
		}
		outPutStream.finish();
		byte[]  bytes=out.toByteArray();
		response.setHeader("Content-Encoding", "gzip");
		response.setHeader("Content-Length", bytes.length+"");
		output.flush();
		output.close();
		closed=true;
	}
	@Override
	public void flush() throws IOException {
		// TODO Auto-generated method stub
		super.flush();
	}
	
	@Override
	public void write(byte[] b) throws IOException {
		// TODO Auto-generated method stub
		write(b,0,b.length);
	}
	
	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		if(closed) {
			return ;
		}
		outPutStream.write(b, off, len);
	}
	@Override
	public void write(int b) throws IOException {
		if(closed) {
			return ;
		}
		outPutStream.write(b);
		
	}
	public boolean isClosed() {
		return closed;
	}


	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void setWriteListener(WriteListener writeListener) {
		// TODO Auto-generated method stub
		
	}
	
}
