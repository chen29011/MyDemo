package com.cqlj.cataTools.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Component
public class JsonUtil {

	 /**
     * 从一个JSON 对象字符格式中得到一个java对象
     * @param jsonString json字符串
     * @param pojoCalss java对象的class
     * @return
     */
	public static Object jsonStringToObject(String jsonString,Class pojoClass){
		JSONObject json = JSONObject.fromObject(jsonString);
		Object pojo = JSONObject.toBean(json, pojoClass);
		return pojo;
	}
	
	 /**
     * 
     * 从json对象集合表达式中得到一个java对象列表
     * @param jsonString
     * @param pojoClass
     * @return
     */
	public static List jsonStringToJavaList(String jsonString,Class pojoClass){
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		JSONObject object;
		Object value;
		List list = new ArrayList();
		for(int i=0;i<jsonArray.size();i++){
			object = jsonArray.getJSONObject(i);
			value = object.toBean(object, pojoClass);
			list.add(value);
		}
		return list;
	}
	
	
	
	protected static ObjectMapper mapper = new ObjectMapper();
	
	protected static JsonFactory factory = mapper.getJsonFactory();
	
	protected void writeJSON(HttpServletResponse response, String json) throws IOException {
		response.setContentType("text/html;charset=utf-8");
	    response.getWriter().write(json);
	}

	public void writeJSON(HttpServletResponse response, Object obj) throws IOException {
	    response.setContentType("text/html;charset=utf-8");
	    JsonGenerator responseJsonGenerator = factory.createJsonGenerator(response.getOutputStream(), JsonEncoding.UTF8);
	    responseJsonGenerator.writeObject(obj);
	}
}
