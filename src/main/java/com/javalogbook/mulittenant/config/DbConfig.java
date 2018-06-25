package com.javalogbook.mulittenant.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.javalogbook.mulittenant.routing.TenantRouting;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.javalogbook")
public class DbConfig {
	@Autowired
	TenantBaseConfiguration tenantBaseConfig;

	@Bean
	public DataSource dataSource() {
		AbstractRoutingDataSource dataSource = new TenantRouting();
		Map<Object, Object> targetDataSources = new HashMap<>();
		tenantBaseConfig.getTenantIds().forEach(tenantId -> {
			targetDataSources.put(tenantId, tenantDataSource(tenantId));
		});
		
		//targetDataSources.put("amity", tenantDataSource("amity"));
		//targetDataSources.put("khaitan", tenantDataSource("khaitan"));
		//targetDataSources.put("school", tenantDataSource("school"));
		dataSource.setTargetDataSources(targetDataSources);
		dataSource.afterPropertiesSet();
		return dataSource;
	}

	private DataSource tenantDataSource(String tenantName) {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setInitializationFailTimeout(0);
		dataSource.setMaximumPoolSize(5);
		dataSource.setDataSourceClassName("org.apache.commons.dbcp2.BasicDataSource");
		dataSource.addDataSourceProperty("username", "root");
		dataSource.addDataSourceProperty("password", "root");
		dataSource.addDataSourceProperty("url", "jdbc:mysql://localhost:3306/" + tenantName);
		return dataSource;
	}
}
