package com.cqlj.spring.sf.content;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BuildContextUtil implements ApplicationContextAware {

	private ApplicationContext ctx;

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		// TODO Auto-generated method stub
		this.ctx = ctx;
	}

	public ApplicationContext getContext() {
		return ctx;
	}
	
	
}
