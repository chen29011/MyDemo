package com.cqlj.cataTools.dateAndTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

public class DateTest2 {
	public static Date parseBirthdayDate(Date birthdayDate) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(birthdayDate);
		cal.add(Calendar.WEEK_OF_MONTH, -2);// 提前两周
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);// 调整为当前星期的周六
		return cal.getTime();
	}
	
	@Test
	public void birthdayDateClock() throws ParseException{
		String birthday = "2016-3-15";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date birthdayDate = df.parse(birthday);
		Date d = DateTest2.parseBirthdayDate(birthdayDate);
		System.out.println(df.format(d));
		
	}
}
