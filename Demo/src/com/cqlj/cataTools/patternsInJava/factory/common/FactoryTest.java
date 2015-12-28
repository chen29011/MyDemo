package com.cqlj.cataTools.patternsInJava.factory.common;

public class FactoryTest {
	public static void main(String[] args) {
		Sender sender = SendFactory.produce("sms");
		sender.Send();
	}
}
