package com.beans;

public class CustomerOrder {
	private int orderId;
	private String orderName;
	
	public CustomerOrder(int orderId, String orderName) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	@Override
	public String toString() {
		return "CustomerOrder [orderId=" + orderId + ", orderName=" + orderName + "]";
	}
	
	
}
