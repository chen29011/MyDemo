package com.cqlj.cataTools.patternsInJava.build;

public interface Builder {
	public void buildHead();
	public void buildBody();
	public void buildHand();
	public void buildFeet();
	public Product getResult();
}
