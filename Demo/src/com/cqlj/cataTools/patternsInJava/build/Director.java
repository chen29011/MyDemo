package com.cqlj.cataTools.patternsInJava.build;

public class Director {
	public Director(Builder builder) {
		builder.buildHead();
		builder.buildBody();
		builder.buildHand();
		builder.buildFeet();
	}
}
