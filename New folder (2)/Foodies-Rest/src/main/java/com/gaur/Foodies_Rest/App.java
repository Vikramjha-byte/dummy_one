package com.gaur.Foodies_Rest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;




public class App 
{
    public static void main( String[] args )
    {
    	BeanFactory context = new XmlBeanFactory(new ClassPathResource("annotation.xml"));
		Foodies f = (Foodies) context.getBean("f");
		System.out.println(f.getRes());
		System.out.println(f.getBranches());
    }
}
