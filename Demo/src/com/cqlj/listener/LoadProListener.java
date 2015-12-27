package com.cqlj.listener;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Lifecycle Listener implementation class LoadProListener
 *
 */
@WebListener
public class LoadProListener implements ServletContextListener {
	private final Logger logger = LoggerFactory.getLogger(LoadProListener.class);

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		Properties props = new Properties(); 
        InputStream inputStream = null; 
        try { 
            inputStream = getClass().getResourceAsStream("/log4j.properties"); 
            props.load(inputStream); 
            String tempPath = (String) props.get("path"); 
            System.out.println("日志文件加载成功");
    		logger.debug("日志文件加载成功");

        } catch (IOException ex) { 
            ex.printStackTrace(); 
        } 

	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

}
