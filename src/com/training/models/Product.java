package com.training.models;

public class Product {
	private int itemCode;
	private String name;
	private double unitPrice;
	private int quantity;
	
	
	public Product() {
		super();
	}


	public Product(int itemCode, String name, double unitPrice, int quantity) {
		super();
		this.itemCode = itemCode;
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	//All getters and setters 
	public int getItemCode() {
		return itemCode;
	}


	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "Product:"+ itemCode + ", name=" + name + ", unitPrice=" + unitPrice + ", quantity="
				+ quantity;
	}
	
		
}
