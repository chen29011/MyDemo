package com.cqlj.text;

public class BwTest {
	public static void main(String[] args) {
		String s = "13333.0";
		
		System.out.println(Integer.parseInt(s.substring(0, s.length()-2)));
	}
}
