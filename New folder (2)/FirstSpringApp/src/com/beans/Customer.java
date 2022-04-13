package com.beans;

import java.util.List;

public class Customer {
	private int id;
	private String name;
	private List<CustomerOrder> custOrder;
	private List<String> placesVisit;
	
	public Customer(int id, String name, List<CustomerOrder> custOrder,List<String> placesVisit) {
		super();
		this.id = id;
		this.name = name;
		this.custOrder = custOrder;
		this.placesVisit=placesVisit;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public List<CustomerOrder> getCustOrder() {
		return custOrder;
	}
	
	public List<String> getPlacesVisit() {
		return placesVisit;
	}
}
