package com.util;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8946879068874078344L;
	
	
	private List<Object> list;
	private Object msg;
	private Map<String, Object> sessionMap;
	
	
	
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}


	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	public void setMsg(Object msg) {
		this.msg = msg;
	}

	public Object getMsg() {
		return msg;
	}
}
