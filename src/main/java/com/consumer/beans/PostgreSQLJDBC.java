package com.consumer.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sdl.umang.ConnectionDataSource;

public class PostgreSQLJDBC {
	public static void main(String args[]) {
		Connection c = null;
		Statement stmt = null;
		
		try {

			System.getProperties().put("proxySet", "true");
			System.getProperties().put("socksProxyHost", "127.0.0.1");
			System.getProperties().put("socksProxyPort", "1337");

//			Class.forName("org.postgresql.Driver");
//			//c = DriverManager.getConnection("jdbc:postgresql://10.247.74.112:5433/umang", "postgres", "Postgres$321");
//			c = DriverManager.getConnection("jdbc:postgresql://10.247.74.112:5433/umang", "exec_dev", "vdHQZW3g9BhaFhyWEEXYdycBn4DXa2W1gx6Vp/O0b/Ou4oyN/PnZ8As0WaNaa1wZ9f/edYROc6Ley7HpA4AP3Q==");
//
//			stmt = c.createStatement();
//	        String sql = "select * from bbps.t_payu_biller_details where ﻿blr_id ='BAID00000NATWG'";
//	        
//	        ResultSet rs = stmt.executeQuery(sql);
//	        
//	        while(rs.next()) {
//	        	
//	        	System.out.println(rs.getString("blr_name"));
//	        	
//	        }
//	        
//	        
//	        stmt.close();
//			System.out.println("success");
			
			
			
			Class.forName("org.postgresql.Driver");
			ConnectionDataSource objConnectionDataSource = new ConnectionDataSource();
			Connection objConnection = objConnectionDataSource.getConnection("BBPS API", "123456789",
					Integer.valueOf("10000"),
					Integer.valueOf("10000"), "jdbc/postgres112");
			
			
			System.out.println(objConnection);
		
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}
}