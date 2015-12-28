package com.cqlj.cataTools.database.redis;

import redis.clients.jedis.Jedis;

public class Test {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.set("name", "xinxin");
		jedis.append("name", " is my lover"); // 拼接
		System.out.println(jedis.get("name"));
	}
}
