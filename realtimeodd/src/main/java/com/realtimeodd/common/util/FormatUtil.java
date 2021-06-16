package com.realtimeodd.common.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * Provides methods for formatting the current date and odds response displayed
 * with two decimal values.
 *
 */
public class FormatUtil {

	/**
	 * This method format the current date.
	 * 
	 * @return returns the current date in the format "yyyy-MM-dd HH:mm:ss".
	 */
	public static String getLocalTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		return formatter.format(date);
	}

	/**
	 * This method format the odds response value given as a input parameter.
	 * 
	 * @param value an odds response value as an argument.
	 * @return the odds response value in the format "#.00".
	 */
	public static String getDecimalValue(Double value) {
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		return decimalFormat.format(value);
	}
}
