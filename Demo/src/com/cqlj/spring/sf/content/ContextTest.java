package com.cqlj.spring.sf.content;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		BuildContextUtil p = ctx.getBean("buildContextUtil", BuildContextUtil.class);
		System.out.println(p.getContext());
		System.out.println(ctx == p.getContext());
	}

}
