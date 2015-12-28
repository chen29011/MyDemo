package com.cqlj.cataTools.patternsInJava.build;

public class ThinPersonBuilder implements Builder {
	Product product = new Product();

	@Override
	public void buildHead() {
		product.add("瘦人头");
	}

	@Override
	public void buildBody() {
		product.add("瘦人身体");
	}

	@Override
	public void buildHand() {
		product.add("瘦人手");
	}

	@Override
	public void buildFeet() {
		product.add("瘦人脚");
	}

	@Override
	public Product getResult() {
		return product;
	}

}
