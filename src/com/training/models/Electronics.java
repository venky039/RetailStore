package com.training.models;

public class Electronics extends Product{
	private int warrantyYears;
	private String wattage;
	public Electronics() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Electronics(int itemCode, String name, double unitPrice, int quantity,
						int warrantyYears,String wattage) {
		super(itemCode, name, unitPrice, quantity);
		this.warrantyYears=warrantyYears;
		this.wattage=wattage;
	}
	
	//getters and setters
	public int getWarrantyYears() {
		return warrantyYears;
	}
	public void setWarrantyYears(int warrantyYears) {
		this.warrantyYears = warrantyYears;
	}
	public String getWattage() {
		return wattage;
	}
	public void setWattage(String wattage) {
		this.wattage = wattage;
	}
	@Override
	public String toString() {
		return super.toString() +
				"warrantyYears=" + warrantyYears + ", wattage=" + wattage + ", toString()=";
	}

	
	
	
	

}
