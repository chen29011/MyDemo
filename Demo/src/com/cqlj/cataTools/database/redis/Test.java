package com.cqlj.cataTools.database.redis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class Test {
	public static void main(String[] args) {
		Jedis jedis = RedisUtil.getJedis();
		jedis.set("name", "xinxin");
		jedis.append("name", " is my lover"); // 拼接
		
		System.out.println(jedis.del("xxxx")+"dddd");
		System.out.println(jedis.get("name"));
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("smdc", "16");
		map.put("yhmd", "18");
		jedis.hmset("16_toBeConfirmOrder", map);
		jedis.hincrBy("16_toBeConfirmOrder", "smdc", -1);
		jedis.hincrBy("16_toBeConfirmOrder", "smdc", 1);
		List<String> list = jedis.hmget("16_toBeConfirmOrder", "smdc","yhmd");
		System.out.println(list);
		System.out.println(jedis.hincrBy("16_hash1", "zzzz", 6));
		System.out.println(jedis.hgetAll("16_hash"));
		

	}
}
