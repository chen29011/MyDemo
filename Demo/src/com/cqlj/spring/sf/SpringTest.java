package com.cqlj.spring.sf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cqlj.spring.sf.event.EmailEvent;

public class SpringTest {
	public static void main(String[] args) {
		// 创建Spring的ApplicationContext
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmailEvent ele = new EmailEvent("hello", "baidu@163.com", "this is a test!");
		// 主动触发容器事件
		ctx.publishEvent(ele);

		/*
		 * 如果Bean想发布事件，则Bean必须获得其容器的引用。 如果程序中没有直接获取容器的引用，
		 * 则应该让Bean实现ApplicationContextAware或BeanFactoryAware接口， 从而获得容器的引用.
		 */
	}
}
