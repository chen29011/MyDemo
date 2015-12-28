package com.cqlj.cataTools.patternsInJava.abstFact;

public class MailSender implements Sender {
	@Override
	public void Send() {
		System.out.println("this is mailsender!");
	}
}
