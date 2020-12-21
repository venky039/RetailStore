package com.training.ifaces;
import java.time.LocalDate;


public interface Calculate<T> {
	public boolean add(T t);
	public void generateSalesReportbyDate(T obj,LocalDate d);
	public void findTopProducts(T obj);
	
}

