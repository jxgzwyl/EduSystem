package com.zikool.edu.auth.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static final String YMD = "yyyy-MM-dd";
    public static final String YMD_HMS = "yyyy-MM-dd HH:mm:ss";
    public static final String YMD_HM = "yyyy-MM-dd HH:mm";

	public static String formatDate(long date, String pattern) {
		SimpleDateFormat s = new SimpleDateFormat(pattern);
		return s.format(date);
	}

	public static String formatDate(Date date, String pattern) {
        if (date == null) return "";
		return formatDate(date.getTime(), pattern);
	}

	public static String formatDate(long date) {
		return formatDate(date, YMD_HMS);
	}

	public static String formatDate(Date date) {
        if (date == null) return "";
		return formatDate(date.getTime());
	}

	public static String getToday() {
		return formatDate(System.currentTimeMillis(), YMD_HMS);
	}

	public static Date parseDate(String date, String pattern) {

		if (date == null || date.length() == 0) return null;

		SimpleDateFormat s = new SimpleDateFormat(pattern);
		try {
			return s.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
