package com.cqlj.cataTools.patternsInJava.build;

public class Test {
	public static void main(String[] args) {
		Builder b1 = new FatPersonBuilder();
		Director d = new Director(b1);
		Product p = b1.getResult();
		p.show();
	}
	
}
