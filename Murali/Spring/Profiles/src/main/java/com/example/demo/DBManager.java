package com.example.demo;

import java.sql.SQLException;

import javax.sql.DataSource;

public class DBManager {
	
	private DataSource dataSource;
			
	DBManager(DataSource dataSource){
		this.dataSource = dataSource;
	}

	public void getConnection() {
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
