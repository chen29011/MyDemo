package com.cqlj.spring.sf.event;

import org.springframework.context.ApplicationEvent;

public class EmailEvent extends ApplicationEvent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String address;
	private String text;
	
	public EmailEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	/*
	 * 定义一个有参数的构造方法
	 */
	public EmailEvent(Object source, String address, String text){
		super(source);
		this.address = address;
		this.text = text;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}