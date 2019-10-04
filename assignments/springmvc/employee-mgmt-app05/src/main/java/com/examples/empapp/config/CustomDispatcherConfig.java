package com.examples.empapp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.examples.empapp.dao.EmployeeDao;
import com.examples.empapp.model.Employee;
import com.examples.empapp.service.EmployeeService;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.examples.empapp")
public class CustomDispatcherConfig {
	
	@Bean
	public EmployeeService empService() {
		return new EmployeeService();
	}
	
	@Bean
	public EmployeeDao empDao() {
		return new EmployeeDao();
	}
	
	@Bean
	public Employee emp() {
		return new Employee();
	}
	
//	@Bean
//	public MysqlDataSource dataSource() {
//		MysqlDataSource datasource = new MysqlDataSource();
//		datasource.setServerName("localhost");
//		datasource.setDatabaseName("jdbctraining");
//		datasource.setUser("training");
//		datasource.setPassword("training");
//		
//		return datasource;
//	}
	
	@Bean
	public Connection connection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctraining", "training", "training");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
