package com.util;

import java.util.HashMap;
import java.util.Map;

public final class Constant {
	public final static String AUTH = "auth";	//session中权限字段的标识符
	public final static String SUCCESS = "success"; 
	public final static String ERROR = "error";
	public final static Map<String,String> BigkindsMap = new HashMap<String, String>();
	
	static{
		BigkindsMap.put("0001", "Vegetables");
		BigkindsMap.put("0002", "Fruits");
		BigkindsMap.put("0003", "Grain");
		BigkindsMap.put("0004", "Bean Products");
		BigkindsMap.put("0005", "Wheat");
		BigkindsMap.put("0006", "Meat");
	}
}
