package com.purnima.jain.multidatasource.jdbctemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MultiDatasourceAndJdbctemplateApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(MultiDatasourceAndJdbctemplateApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MultiDatasourceAndJdbctemplateApplication.class, args);
		logger.info("MultiDatasourceAndJdbctemplateApplication Started........");
	}

}
