package com.training.models;


public class Garments extends Product{
	private String size;
	private String material;
	private String gender;
	public Garments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Garments(int itemCode, String name, double unitPrice, int quantity,
			String size,String material,String gender) {
		super(itemCode, name, unitPrice, quantity);
		this.size=size;
		this.material=material;
		this.gender=gender;
	}
	//adding getters and setters
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return super.toString()+
				"size=" + size + ", material=" + material + ", gender=" + gender + ", toString()=";
	}
	
	
	
	
	

}
