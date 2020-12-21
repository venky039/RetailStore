package com.training.models;

import java.util.*;

public class Edible extends Product{
	
	private Date dateOfManufacture;
	private Date dateOfExpiry;
	private String type;
	
	public Edible() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Edible(int itemCode, String name, double unitPrice, int quantity,
			Date dateOfManufacture,Date dateOfExpiry,String type) {
		super(itemCode, name, unitPrice, quantity);
		this.dateOfManufacture=dateOfManufacture;
		this.dateOfExpiry=dateOfExpiry;
		this.type=type;
		// TODO Auto-generated constructor stub
	}
	
	//getters and setters of edible class

	public Date getDateOfManufacture() {
		return dateOfManufacture;
	}
	public void setDateOfManufacture(Date dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}
	public Date getDateOfExpiry() {
		return dateOfExpiry;
	}
	public void setDateOfExpiry(Date dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return super.toString()+"dateOfManufacture=" + dateOfManufacture +
				", dateOfExpiry=" + dateOfExpiry + ", type=" + type;
	}

	
	
	
	
	

}
