package com.example.demo;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class Config {

	
	@Bean
	public DBManager dbManager(DataSource dataSource) {
		return new DBManager(dataSource);
	}
	
	@Bean
	@Profile({"development","default"})
	public DataSource sql() {
		return new DataSourceMySQLImpl();
	}
	
	@Bean
	@Profile("production")
	public DataSource post() {
		return new DataSourcePostgresImpl();
	}
	
}
