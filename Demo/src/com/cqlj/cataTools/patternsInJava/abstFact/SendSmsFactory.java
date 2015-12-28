package com.cqlj.cataTools.patternsInJava.abstFact;

public class SendSmsFactory implements Provider {

	@Override
	public Sender produce() {
		return new SmsSender();
	}

}
