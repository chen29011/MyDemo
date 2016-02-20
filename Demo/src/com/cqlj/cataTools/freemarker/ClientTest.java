package com.cqlj.cataTools.freemarker;

import java.util.HashMap;
import java.util.Map;

public class ClientTest {
	public static void main(String[] args) {
		User user = new User();
		user.setUserName("张三");
		user.setUserPassword("123");

		Map<String, Object> root = new HashMap<String, Object>();
		root.put("user", user);
		root.put("student", user);
		String templatesPath = "D:/ftl";
		String templateFile = "/user.ftl";
		String htmlFile = templatesPath + "/user.txt";
		FreeMarkertUtil.analysisTemplate(templatesPath, templateFile, htmlFile, root);
	}
}
