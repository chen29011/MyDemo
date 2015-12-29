package com.cqlj.cataTools.mail;

import com.cqlj.cataTools.mail.entity.Mail;
import com.cqlj.cataTools.mail.mailUtil.MailUtil;
/**
 * JavaMain测试类，涉及jar包为：activation-2.2.1.jar、commons-email-1.4.jar、mail-1.4.3.jar
 * @author Administrator
 *
 */
public class JavaMailTest {
	public static void main(String[] args) {
		Mail mail = new Mail();
		mail.setHost("smtp.163.com"); // 设置邮件服务器,如果不用163的,自己找找看相关的
		mail.setSender("simplework@163.com");
		mail.setReceiver("simplework@163.com"); // 接收人
		mail.setUsername("simplework@163.com"); // 登录账号,一般都是和邮箱名一样吧
		mail.setPassword("a363373395"); // 发件人邮箱的登录密码
		mail.setSubject("JavaMain测试邮件标题第二个");
		mail.setMessage("测试邮件内容");
		new MailUtil().send(mail);
	}

}
