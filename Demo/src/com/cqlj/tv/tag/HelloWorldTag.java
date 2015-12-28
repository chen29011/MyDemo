package com.cqlj.tv.tag;

import java.io.IOException;

import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloWorldTag extends SimpleTagSupport {
	public void doTag() throws IOException {
		getJspContext().getOut().write("Hello World" + new java.util.Date());
	}
}
