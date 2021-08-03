package com.mysql.spring.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;

/**
 * Class to declare beans and to tell Spring container to generate 
 * bean definitions,service requests for declared beans at runtime.
 * 
 * Class declares {@link DataSource} {@link JdbcTemplate} to be made 
 * available at runtime.
 * 
 * @author metanoia
 * @version 1.0
 * 
 * */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = {"com.mysql.spring"})
public class ApplicationConfiguration {

	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/";
	private static final String DATABASE_NAME = "institute";
	private static final String DATABASE_USERNAME = "root";
	private static final String DATABASE_PASSWORD = "mysql123";
	private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

	/**
	 * {@link BasicDataSource} - a 'one stop shopping solution' to configure
	 * basic needs to connect to relational database. Bean configures mysql
	 * database connect properties required for database communication.
	 */
	@Bean
	public DataSource mysqlDataSource() {

		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName(DRIVER_CLASS_NAME);
		dataSource.setUrl(DATABASE_URL.concat(DATABASE_NAME));
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);

		return dataSource;

	}

	/**
	 * {@link JdbcTemplate} executes core JDBC workflow (SQL queries or
	 * updates,Iterate ResultSets,Catching generic Jdbc Exceptions and transform
	 * to information exception hierarchy )
	 */
	@Bean
	public JdbcTemplate jdbctemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}

}
