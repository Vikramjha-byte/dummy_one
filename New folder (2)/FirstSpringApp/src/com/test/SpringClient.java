package com.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.beans.Customer;
import com.beans.CustomerOrder;

public class SpringClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Customer c = new Customer();
		//BeanFactory factory = new XmlBeanFactory(new ClassPathResource("application.xml"));
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		Customer cust = (Customer) context.getBean("cust");
		System.out.println(cust.getCustOrder());
		System.out.println(cust.getName());
		System.out.println(cust.getPlacesVisit());
	}

}
