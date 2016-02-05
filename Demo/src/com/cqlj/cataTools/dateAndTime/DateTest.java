package com.cqlj.cataTools.dateAndTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) throws Exception {
		Date d = new Date();
		System.out.println(d);
		Calendar c = Calendar.getInstance();
		//将Date对象转换成Calendar对象
		c.setTime(d);
		//强Calendar对象转换成Date对象
		Date d2 = c.getTime();
		
		
		//格式化工具
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		//将日期转换成字符串
		String st1 = df.format(d);
		//将字符串转换成日期
		Date d3 = df.parse("2015-12-12");
		System.out.println(d3);
		
	}

}
