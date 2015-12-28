package com.cqlj.text;

import java.lang.reflect.Method;

public class MethodTest {

	public static void main(String[] args) throws Exception {
		Class<?> cla = Class.forName("com.cqlj.model.Student");
		Method[] methods = cla.getMethods();
		
		System.out.println(methods[0].getParameterTypes());
	}
}
