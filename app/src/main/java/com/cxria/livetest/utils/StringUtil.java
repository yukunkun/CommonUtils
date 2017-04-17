package com.cxria.livetest.utils;

import android.content.Context;
import android.net.Uri;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

public class StringUtil {
	private static StringUtil sMStringUtil;
	private StringBuilder mFormatBuilder;
	private Formatter mFormatter;

	private StringUtil() {

		// 转换成字符串的时间
		mFormatBuilder = new StringBuilder();
		mFormatter = new Formatter(mFormatBuilder, Locale.getDefault());

	}

	public static StringUtil getInstance() {
		if (sMStringUtil == null) {
			sMStringUtil = new StringUtil();
		}
		return sMStringUtil;
	}

	public boolean isNetUri(Uri uri) {
		String uriStr = uri.toString().toLowerCase();
		if (uriStr.startsWith("http") || uriStr.startsWith("mms") || uriStr.startsWith("rtsp")) {
			return true;
		}

		return false;
	}

	/**
	 * 获取系统当前时间
	 *
	 * @return
	 */
	public String getCurrentSystemTime() {
		SimpleDateFormat format = new SimpleDateFormat();

		return format.format(new Date());
	}

	/**
	 * 把毫秒转换成：1:20:30这里形式
	 *
	 * @param timeMs 时间戳
	 * @return
	 */
	public String stringForTime(int timeMs) {
		int totalSeconds = timeMs / 1000;
		int seconds = totalSeconds % 60;

		int minutes = (totalSeconds / 60) % 60;

		int hours = totalSeconds / 3600;

		mFormatBuilder.setLength(0);
		if (hours > 0) {
			return mFormatter.format("%d:%02d:%02d", hours, minutes, seconds)
					.toString();
		} else {
			return mFormatter.format("%02d:%02d", minutes, seconds).toString();
		}
	}

	public String stringForCount(int times) {
		String tempStr = times + "";
		if (times >= 1000) {
			times = times / 1000;
			tempStr = times + "k次播放";
		}
		if (times >= 10000) {
			times = times / 10;
			tempStr = times + "万次播放";
		}

		if (times < 1000) {
			tempStr = times + "次播放";
		}

		return tempStr;
	}

	public String stringForDate(long timeMs) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String format = sdf.format(new Date(timeMs));
		return format;
	}

	public String stringForSize(float size) {
		DecimalFormat decimalFormat = new DecimalFormat("###");
		String sizeStr = String.valueOf(size) + "B";
		if (size > 1024) {
			size = size / 1024;

			sizeStr = String.valueOf(size) + "KB";
		}

		if (size > 1024) {
			size = size / 1024;
			sizeStr = String.valueOf(size) + "MB";
		}

		if (size > 1024) {
			size = size / 1024;
			sizeStr = String.valueOf(size) + "GB";
		}

		//将sizeStr转化成基本类型
		int end = sizeStr.length() - 2;
		String tempSizeStr = sizeStr.substring(0, end);
		String unit = sizeStr.substring(end);
		size = Float.parseFloat(tempSizeStr);

		//格式化成指定格式
		return decimalFormat.format(size) + unit;

	}

	/**
	 * 判断当前语言是否是汉语
	 *
	 * @return
	 */
	public boolean isZh(Context context) {
		Locale locale = context.getResources().getConfiguration().locale;
		String language = locale.getLanguage();
		LogUtil.i(StringUtil.class, "language", language.toString());
		if (language.endsWith("zh")) {
			return true;
		} else {
			return false;
		}
	}

	public String stringForLeare(int times) {
		String tempStr = times + "";
		if (times < 1000) {
			tempStr = times + "人学习";
		}
		if (times >= 1000) {
			times = times / 1000;
			tempStr = times + "人学习";
		}
		if (times >= 10000) {
			times = times / 10;
			tempStr = times + "人学习";
		}
		return tempStr;
	}

	public String switchLookTimes(int num) {
		if (num < 1000) {
			return num + "";
		} else {
			return num / 1000 + "K";
		}
	}
}