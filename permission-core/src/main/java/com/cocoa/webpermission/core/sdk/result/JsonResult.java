package com.cocoa.webpermission.core.sdk.result;

import java.util.List;
/**
 * 通用json返回结果
 * @author CocoaDing
 * created on 2018年12月26日 上午10:29:52	
 *
 */
public class JsonResult {
	public final static int SUCCESS=0x1;
	public final static int FAILED=0x0;
	
	private int result;
	private Object obj;
	private List<Object> datas;
	private String errMsg;
	public boolean isSuccess(){
		return result==1;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public List<Object> getDatas() {
		return datas;
	}
	public void setDatas(List<Object> datas) {
		this.datas = datas;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	
}
