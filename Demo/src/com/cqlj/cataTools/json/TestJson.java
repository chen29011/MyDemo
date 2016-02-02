package com.cqlj.cataTools.json;

import org.junit.Test;

import net.sf.json.JSONObject;

/*
 * 使用net.sf.json.JSONObject依赖jar包
 * commons-logging-1.0.4.jar  
 * commons-lang-2.3.jar  
 * commons-collections-3.2.jar  
 * commons-beanutils-1.7.0.jar  
 * json-lib-2.2.1-jdk15.jar  
 * ezmorph-1.0.4.jar
 */
public class TestJson {
	@Test
	public void testJ() {
		String str = "{\"id\":10000032,\"orderFoodRemark\":\"不咋看见\",\"orderPrice\":223.0}";
		JSONObject content = JSONObject.fromObject(str);
		System.out.println(content.get("id"));
		System.out.println(content.get("orderFoodRemark"));
		System.out.println(content.get("orderPrice"));

	}

}
