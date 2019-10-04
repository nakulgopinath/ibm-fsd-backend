package com.examples.empapp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.examples.empapp.dao.EmployeeDao;
import com.examples.empapp.model.Employee;
import com.examples.empapp.service.EmployeeService;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.examples.empapp")
public class CustomDispatcherConfig {

	@Lazy
	@Bean
	public EmployeeService empService() {
		return new EmployeeService();
	}
	
	@Lazy
	@Bean
	public EmployeeDao empDao() {
			return new EmployeeDao();
	}
	
	@Bean
	public Employee emoloyee() {
			return new Employee();
	}
	
	@Bean
	public Connection connection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctraining", "training", "training");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
