package com.cqlj.tv.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "log", urlPatterns = { "/*" })
public class LogFilter implements Filter {
	/**
	 * FilterConfig可用于访问Filter的配置信息
	 */
	private FilterConfig config;

	/**
	 * 实现初始化方法
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}

	/**
	 * 实现销毁方法
	 */
	public void destroy() {
		this.config = null;
	}

	/**
	 * 执行过滤的核心方法
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		ServletContext context = this.config.getServletContext();
		long before = System.currentTimeMillis();
		System.out.println("开始过滤...");
		// 将请求装换成HttpServletRequest请求
		HttpServletRequest hrequest = (HttpServletRequest) request;
		System.out.println("Filter已经截获到用户的请求的地址：" + hrequest.getServletPath());
		// Filter只是链式处理，请求依然放行到目的地址
		chain.doFilter(request, response);
		// -----------下面代码用于对服务器响应执行后处理-------------------
		long after = System.currentTimeMillis();
		System.out.println("过滤结束");
		System.out.println("请求被定为到" + hrequest.getRequestURI() + "所花时间为：" + (after - before));
	}
}
