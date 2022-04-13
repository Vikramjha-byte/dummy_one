package com.gaur.Foodies_Rest;

public class Restaurant {
	private int orderid;
	private String ordername;
	public Restaurant(int orderid, String ordername) {
		super();
		this.orderid = orderid;
		this.ordername = ordername;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getOrdername() {
		return ordername;
	}
	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}
	@Override
	public String toString() {
		return "Restaurant [orderid=" + orderid + ", ordername=" + ordername + "]";
	}
	
	
}
