package com.purnima.jain.multidatasource.jdbctemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import com.purnima.jain.multidatasource.jdbctemplate.mysql.repo.MySqlCustomerRepository;
import com.purnima.jain.multidatasource.jdbctemplate.postgres.repo.PostgresCustomerRepository;

@Configuration
public class MultiDatasourceAndJdbctemplateApplicationRunner implements ApplicationRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(MultiDatasourceAndJdbctemplateApplicationRunner.class);
	
	@Autowired
	private MySqlCustomerRepository mySqlCustomerRepository; 
	
	@Autowired
	private PostgresCustomerRepository postgresCustomerRepository; 

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Integer countOfRowsInMySqlInCustomer = mySqlCustomerRepository.findCount();
		logger.info("Count Of Rows In MySql In Customer :: {}", countOfRowsInMySqlInCustomer);
		
		Integer countOfRowsInPostgresInCustomer = postgresCustomerRepository.findCount();
		logger.info("Count Of Rows In Postgres In Customer :: {}", countOfRowsInPostgresInCustomer);
		
	}

}
