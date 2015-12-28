package com.cqlj.cataTools.patternsInJava.factory.common;

public class MailSender implements Sender {

	@Override
	public void Send() {
		System.out.println("this is mailsender!");
	}

}
