package com.training.utils;
import java.util.*;
import java.io.*;
import java.sql.*;


public class ConnectionUtils{
	
	public static Connection getMySqlConnection() {
		Connection con=null;
		
		try {
		
		String filename="resources/DBConnection.properties";
		
		InputStream stream = ConnectionUtils.class.getClassLoader().getResourceAsStream(filename);
	
		//getClass Loader to load class from /resources given in filename;
		//file of type property get converted into Stream
		Properties prop=new Properties();
		prop.load(stream);
		//prop splits input stream into Key and values;
		String url=prop.getProperty("database.url");
		String password=prop.getProperty("database.password");
		String username=prop.getProperty("database.userName");
		
		con=DriverManager.getConnection(url,username,password);
		System.out.println("Connection Setup");
		
		}
		catch(IOException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}


}
