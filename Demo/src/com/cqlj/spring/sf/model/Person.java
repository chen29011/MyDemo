package com.cqlj.spring.sf.model;

public class Person {
	// Person类的name属性。
	private String name;

	// name属性的setter方法
	public void setName(String name) {
		this.name = name;
	}

	// 测试Person类的info方法
	public void info() {
		System.out.println("此人名为：" + name);
	}
}
