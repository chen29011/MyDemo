package com.cqlj.spring.sf.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class EmailNotifier implements ApplicationListener<ApplicationEvent> {

	@Override
	public void onApplicationEvent(ApplicationEvent evt) {
		// TODO Auto-generated method stub
		if (evt instanceof EmailEvent) {
			EmailEvent emailEvent = (EmailEvent) evt;
			System.out.println("邮件地址是：" + emailEvent.getAddress());
			System.out.println("邮件内容是：" + emailEvent.getText());
		} else {
			System.out.println("容器本身的事件：" + evt);
		}
	}

}
