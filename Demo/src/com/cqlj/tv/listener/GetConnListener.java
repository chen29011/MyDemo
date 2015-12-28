package com.cqlj.tv.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class GetConnListener implements ServletContextListener {
	/**
	 * 启动应用时，该方法被调用
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		// 取得该应用的ServletContext实例
		ServletContext application = arg0.getServletContext();
		List<String> list = new ArrayList<String>();
		System.out.println("测试Listener开始");
		list.add("测试Listener结束 ");
		application.setAttribute("list", list);
	}

	/**
	 * 应用关闭时，该方法被调用
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		ServletContext application = arg0.getServletContext();
		List<String> list = (ArrayList) application.getAttribute("list");
		System.out.println(list.get(0));
	}
}
