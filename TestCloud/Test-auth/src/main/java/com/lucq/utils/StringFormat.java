package com.lucq.utils;


import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;


public class StringFormat {

	/**
	 * 模仿C#格式化${0}字符串
	 * 
	 * @param template
	 * @param args
	 * @return
	 */
	public static String formats(String template, String... args) {
		for (int i = 0; args != null && i < args.length; i++) {
			template = template.replaceFirst("\\$\\{" + i + "\\}", args[i]);
		}
		return template;
	}

	/**
	 * 模仿C#格式化{0}字符串
	 * 
	 * @param args
	 * @return
	 */
	public static String format(String template, String... args) {
		for (int i = 0; args != null && i < args.length; i++) {
			template = template.replaceFirst("\\{" + i + "\\}", args[i]);
		}
		return template;
	}

	/**
	 * 安全链接字符串
	 * 
	 * @param strs
	 * @return
	 */
	public static String softLink(String... strs) {
		StringBuffer sb = new StringBuffer();
		for (String s : strs) {
			sb.append(StringUtils.isEmpty(s) ? "" : s);
		}
		return sb.toString();
	}

	/**
	 * 安全去首位链接字符串
	 * 
	 * @param strs
	 * @return
	 */
	public static String softTrimLink(String... strs) {
		StringBuffer sb = new StringBuffer();
		for (String s : strs) {
			sb.append(StringUtils.trimToEmpty(s));
		}
		return sb.toString();
	}

	/**
	 * 安全toString
	 * 
	 * @param str
	 * @return
	 */
	public static String toString(Object str) {
		if (str == null || "".equals(str))
			return null;
		return str.toString();
	}

	public static boolean isEmpty(Object obj) {
		if (obj == null || "".equals(obj))
			return true;
		return false;
	}

	/**
	 * 通过","链接List
	 * 
	 * @param strlist
	 * @return
	 */
	public static String formatByComma(Collection<String> strlist) {
		if (CollectionUtils.isEmpty(strlist))
			return "";
		String[] strs = new String[strlist.size()];
		strlist.toArray(strs);
		return StringFormat.formatByComma(strs);
	}

	/**
	 * 将数组轻而易举的转换成用逗号分隔的字符串
	 * 
	 * @param strs
	 * @return
	 */
	public static String formatByComma(String... strs) {
		return StringFormat.formatByComma(true, strs);
	}

	/**
	 * 将数组轻而易举的转换成用逗号分隔的字符串
	 * 
	 * @param strs
	 * @return
	 */
	public static String formatByComma(boolean filterNull, String... strs) {
		if (!filterNull)
			ArrayUtils.removeElement(strs, null);
		String str = ArrayUtils.toString(strs);
		return StringUtils.substring(str, 1, str.length() - 1);
	}

	/**
	 * 在数组每个元素前后追加数据
	 * 
	 * @param array
	 * @param head
	 * @param end
	 * @return
	 */
	public static String[] formatEcho(String head, String end, String... array) {
		if (isEmpty(array))
			return null;
		for (int i = 0; i < array.length; i++) {
			if (isEmpty(array[i]))
				continue;
			array[i] = head + array[i] + end;
		}
		return array;
	}

	/**
	 * 把用","分割的字符串，转换成数组
	 * 
	 * @param str
	 * @return
	 */
	public static String[] splitByComma(String str) {
		return StringUtils.split(str, ",");
	}

	public static void main(String[] args) {
		String[] stringArray = { "Red", "Orange", "Blue", "Brown", "Red" };
		System.out.print(StringFormat.formatByComma(stringArray));
	}

}