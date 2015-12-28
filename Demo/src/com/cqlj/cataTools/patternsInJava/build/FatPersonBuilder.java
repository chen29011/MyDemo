package com.cqlj.cataTools.patternsInJava.build;

public class FatPersonBuilder implements Builder {
	Product product = new Product();

	@Override
	public void buildHead() {
		product.add("胖人头");
	}

	@Override
	public void buildBody() {
		product.add("胖人身体");
	}

	@Override
	public void buildHand() {
		product.add("胖人手");
	}

	@Override
	public void buildFeet() {
		product.add("胖人脚");
	}

	@Override
	public Product getResult() {
		return product;
	}

}
