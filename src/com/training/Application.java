package com.training;
import com.training.models.*;
import java.time.LocalDate;  
import java.sql.Connection;

import java.util.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.training.services.*;
import com.training.utils.*;
public class Application {

	public static void main(String[] args) {
		
		
		
		Connection connection=ConnectionUtils.getMySqlConnection();
		ProductService service=new ProductService(connection);
		Logger log=Logger.getRootLogger();
		Integer choice1;
		BasicConfigurator.configure();	
		

		
		Scanner sc= new Scanner(System.in);
		while(true) {
			System.out.println("Menu:");
			System.out.println("1.Display daily sales report for each category");
			System.out.println("2.Display top 3 products sold on basis of quantity");
			 
			//System.in is a standard input stream.
			System.out.print("Enter your choice(1/2): ");
			Integer choice= Integer.parseInt(sc.nextLine());
			log.info("Inside main menu");
			if(choice==1) {
				System.out.println("Enter the category of product to display:");
				System.out.println("1.Edibles");
				System.out.println("2.Garments");
				System.out.println("3.Electronics");
				System.out.print("Enter your choice(1/2/3): ");
				choice1= Integer.parseInt(sc.nextLine());
				
				switch(choice1) {
				case 1:
					System.out.println("Enter date of format:yyyy-MM-d:");
					String d1=sc.nextLine();
					LocalDate localDate1 = LocalDate.parse(d1);					
					service.generateSalesReportbyDate(new Edible(), localDate1);
					break;
				case 2:
					System.out.println("Enter date of format:yyyy-MM-d:");
					String d2=sc.nextLine();
					LocalDate localDate2 = LocalDate.parse(d2);					
					service.generateSalesReportbyDate(new Garments(), localDate2);
					break;
				case 3:
					System.out.println("Enter date of format:yyyy-MM-d:");
					String d3=sc.nextLine();
					LocalDate localDate3 = LocalDate.parse(d3);					
					service.generateSalesReportbyDate(new Electronics(), localDate3);
					break;
				}
			}
			else if(choice==2) {
				System.out.println("Enter category of product to display:");
				System.out.println("1.Edibles");
				System.out.println("2.Garments");
				System.out.println("3.Electronics");
				System.out.print("Enter your choice(1/2/3): ");
				choice1= Integer.parseInt(sc.nextLine());
				
				switch(choice1) {
				case 1:
					log.info("Finding top products of Edible class");
					service.findTopProducts(new Edible());
					break;
				case 2:
					log.info("Finding top products of Garments");
					service.findTopProducts(new Garments());
					break;
				case 3:
					log.info("Finding top products of Electronics");
					service.findTopProducts(new Electronics());
					break;
				default:
					System.out.println("Entered invalid option...Exiting");
					break;
				}	
			}
				
			else {
				System.out.println("Entered Invalid option");
				break;
			}		
		}
		sc.close();
		
	}

}
