package com.training.services;
import com.training.models.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import com.training.ifaces.Calculate;
public class ProductService implements Calculate<Product>{
	Product product;
	List<Product> productList;
	private int totalQuantity;
	private Connection connection;
	Logger log;
	public ProductService(Connection connection) {
		super();
		this.connection=connection;
		log=Logger.getLogger("Product Service");
	}
	
	public void printlist(List<Product> list) {
		//printing the resultant lists of products
		Iterator<Product> itr=list.iterator();
		double sum=0;
		double amount;
		System.out.println("Item Name\t Unit Price\tQuantity\tAmount");
		System.out.println("--------------------------------------------");
		while(itr.hasNext()) {
			product=itr.next();
			amount=product.getUnitPrice()* (double)product.getQuantity();
			sum+=amount;
			//String format = "%-20s%-20s%-20d%-20s%n";
			//System.out.printf(format,product.getName(),product.getUnitPrice(),product.getQuantity(),amount);
			System.out.println(product.getName()+"\t\t"+product.getUnitPrice()+"\t\t"+
			product.getQuantity()+"\t\t"+amount);
		}
		System.out.println("Total Amount: "+sum);
	}

	@Override
	public boolean add(Product t) {
		// add new products to database tables
		if(t instanceof Edible) {
			
		}
		else if(t instanceof Garments) {}
		else if(t instanceof Electronics) {}
		return false;
	}
	
	

	@Override
	public void generateSalesReportbyDate(Product obj,LocalDate d) {
		// method to find total sales of each category on a given day
	
		List<Product> list=new ArrayList<>();
		if(obj instanceof Edible) {
			//if object is instance of Edible
			System.out.println("Edible report for"+ d);
			String sql="select * from retailstore.edibles where dateOfPurchase=?";
			try {
				PreparedStatement pst=connection.prepareStatement(sql);
				pst.setObject(1,d);
				ResultSet result=pst.executeQuery();
				while(result.next()) {
					
					int itemCode=result.getInt(2);
					String name=result.getString(3);
					Double unitPrice=result.getDouble(4);
					int quantity=result.getInt(5);
					Date date1=result.getDate(6);
					Date date2=result.getDate(7);
					String type=result.getString(8);
					
					//double amount=result.getDouble(2)*(double)result.getInt(3);
					
					list.add(new Edible(itemCode,name,unitPrice,quantity,date1,date2,type));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		else if(obj instanceof Garments) {
			//if object is instance of Garments
			System.out.println("Garments report for"+ d);
			String sql="select * from retailstore.garments where dateOfPurchase=?";
			try {
				PreparedStatement pst=connection.prepareStatement(sql);
				pst.setObject(1,d);
				ResultSet result=pst.executeQuery();
				while(result.next()) {
					int itemCode=result.getInt(2);
					String name=result.getString(3);
					Double unitPrice=result.getDouble(4);
					int quantity=result.getInt(5);
					String size=result.getString(6);
					String material=result.getString(7);
					String gender=result.getString(8);
					
					//double amount=result.getDouble(2)*(double)result.getInt(3);
					
					list.add(new Garments(itemCode,name,unitPrice,quantity,size,material,gender));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
		else if(obj instanceof Electronics) {
			//if objects are instance of Electronics
			System.out.println("Electronics report for"+ d);
			String sql="select * from retailstore.electronics where dateOfPurchase=?";
			try {
				PreparedStatement pst=connection.prepareStatement(sql);
				pst.setObject(1,d);
				ResultSet result=pst.executeQuery();
				while(result.next()) {
					int itemCode=result.getInt(2);
					String name=result.getString(3);
					Double unitPrice=result.getDouble(4);
					int quantity=result.getInt(5);
					int warrantyYears=result.getInt(6);
					String wattage=result.getString(7);
					
					
					list.add(new Electronics(itemCode,name,unitPrice,quantity,warrantyYears,wattage));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		printlist(list);
	}

	@Override
	public void findTopProducts(Product obj) {
		// method to find the top 3 products sold on the basis of quantity
		
		
		if(obj instanceof Edible) {
			System.out.println("Top selling edibles for the month of November:");
			System.out.println("Name\t\tQuantity");
			String sql="select name,sum(quantity) from edibles group by itemCode order by sum(quantity) desc limit 3";
			try {
				PreparedStatement pst=connection.prepareStatement(sql);
				ResultSet result=pst.executeQuery();
				totalQuantity=0;
				while(result.next()) {
				
					String name=result.getString(1);
					int quantity=result.getInt(2);
					totalQuantity+=quantity;
					String format = "%-20s%s%n";
					System.out.printf(format,name,quantity);
				}
				System.out.println("Total: "+totalQuantity);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if(obj instanceof Garments) {
			System.out.println("Top selling edibles for the month of November:");
			System.out.println("Name\t\tQuantity");
			String sql="select name,sum(quantity) from garments group by itemCode order by sum(quantity) desc limit 3";
			try {
				PreparedStatement pst=connection.prepareStatement(sql);
				ResultSet result=pst.executeQuery();
				totalQuantity=0;
				while(result.next()) {
				
					String name=result.getString(1);
					int quantity=result.getInt(2);
					totalQuantity+=quantity;
					String format = "%-20s%s%n";
					System.out.printf(format,name,quantity);
				}
				System.out.println("Total: "+totalQuantity);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if(obj instanceof Electronics) {
			System.out.println("Top selling edibles for the month of November:");
			System.out.println("Name\t\tQuantity");
			String sql="select name,sum(quantity) from electronics group by itemCode order by sum(quantity) desc limit 3";
			try {
				PreparedStatement pst=connection.prepareStatement(sql);
				ResultSet result=pst.executeQuery();
				totalQuantity=0;
				while(result.next()) {
				
					String name=result.getString(1);
					int quantity=result.getInt(2);
					totalQuantity+=quantity;
					String format = "%-20s%s%n";
					System.out.printf(format,name,quantity);
				}
				System.out.println("Total: "+totalQuantity);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
