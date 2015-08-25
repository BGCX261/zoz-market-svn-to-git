package com.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtil {
	StringUtil() {
		super();
	}

	/** ********************************************
	 * method name   : isEmpty 
	 * description   : �ж��Ƿ�Ϊnull ����""
	 * @return       : boolean
	 * @param        : @param cs
	 * @param        : @return
	 * modified      :     ,  2012-11-19  ����12:03:33
	 * @see          : 
	 * ********************************************/
	public static boolean isEmpty(CharSequence cs) {
		return cs == null || cs.length() == 0;
	}

	/** ********************************************
	 * method name   : isBlank 
	 * description   : �ж��Ƿ�Ϊnull���߿��ַ�
	 * @return       : boolean
	 * @param        : @param cs
	 * @param        : @return
	 * modified      :     ,  2012-11-19  ����12:03:56
	 * @see          : 
	 * ********************************************/
	public static boolean isBlank(CharSequence cs) {
		int strLen;
		if (cs == null || (strLen = cs.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (Character.isWhitespace(cs.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	/** ********************************************
	 * method name   : trim 
	 * description   : ȥ��հ��ַ�
	 * @return       : String
	 * @param        : @param str
	 * @param        : @return
	 * modified      : chen ,  2012-11-19  ����12:04:14
	 * @see          : 
	 * ********************************************/
	public static String trim(String str) {
		return str == null ? null : str.trim();
	}

}
