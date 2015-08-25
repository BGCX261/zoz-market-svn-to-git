package com.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


import flex.messaging.FlexSession;

public class CommonUtil {
	

	/** ********************************************
	 * method name   : md5 
	 * description   : MD5
	 * @return       : String
	 * @param        : @param str
	 * @param        : @return
	 * modified      : 2012-11-19  ����12:04:26
	 * @see          : 
	 * ********************************************/
	public static String md5(String str) {
		MessageDigest messageDigest = null;

		try {
			messageDigest = MessageDigest.getInstance("MD5");

			messageDigest.reset();

			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException caught!");
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		byte[] byteArray = messageDigest.digest();

		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}

		return md5StrBuff.toString();
	}
	
	
	/** ********************************************
	 * method name   : getSession 
	 * description   : 通过Map向session里面传值
	 * @return       : FlexSession
	 * @param        : @param map
	 * @param        : @param flexSession
	 * @param        : @return
	 * modified      :  2012-12-1  下午09:54:50
	 * @see          : 
	 * ********************************************/
	public static FlexSession getFlexSession(Map<String,Object> map){
		FlexSession flexSession = getFlexSession();
		Set<String> set = map.keySet();
		for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			flexSession.setAttribute(key, map.get(key));
		}
		return flexSession;
	}
	
	/** ********************************************
	 * method name   : getSession 
	 * description   : 获得session
	 * @return       : FlexSession
	 * @param        : @return
	 * modified      : 2012-12-1  下午09:58:11
	 * @see          : 
	 * ********************************************/
	public static FlexSession getFlexSession(){
		return flex.messaging.FlexContext.getFlexSession();
	}

	
}
