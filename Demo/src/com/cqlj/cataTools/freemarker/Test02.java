package com.cqlj.cataTools.freemarker;

import java.io.File;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class Test02 {
	private Configuration cfg; // 模版配置对象

	public void init() throws Exception {
		// 初始化FreeMarker配置
		// 创建一个Configuration实例
		cfg = new Configuration();
		// 设置FreeMarker的模版文件夹位置
		cfg.setDirectoryForTemplateLoading(new File("D:/freemarker/"));
	}

	public void process() throws Exception {
		// 构造填充数据的Map
		Map map = new HashMap();
		map.put("user", "lavasoft");
		map.put("url", "http://www.baidu.com/");
		map.put("name", "百度");
		// 创建模版对象
		String filepath = Test.class.getResource("/").getPath() + "test.ftl";
		filepath = filepath.substring(1).replaceAll("%20", " ");
		System.out.println(filepath);
		Template t = cfg.getTemplate("D:/freemarker/test.ftl");
		// 在模版上执行插值操作，并输出到制定的输出流中
		t.process(map, new OutputStreamWriter(System.out));
	}

	public static void main(String[] args) throws Exception {
		Test02 hf = new Test02();
		hf.init();
		hf.process();
	}
}
