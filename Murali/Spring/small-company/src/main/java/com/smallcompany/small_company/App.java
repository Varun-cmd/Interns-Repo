package com.smallcompany.small_company;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
    	
    	ServerConnection s = (ServerConnection) context.getBean("serverConnection");
    	s.storeData();
    	s.getClass();
    	s.disconnect();
    }
}
