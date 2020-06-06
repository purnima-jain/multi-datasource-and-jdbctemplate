package com.purnima.jain.multidatasource.jdbctemplate.postgres.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
public class PostgresConfig {
	
	@Bean(name = "postgresDataSource")
	@ConfigurationProperties(prefix = "spring.postgres.datasource")
	public DataSource dataSource()
	{
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "postgresJdbcTemplate")
	public NamedParameterJdbcTemplate mySqlJdbcTemplate(@Qualifier("postgresDataSource") DataSource postgresDataSource)
	{
		return new NamedParameterJdbcTemplate(postgresDataSource);
	}
	
	@Bean
	public DataSourceInitializer postgresDataSourceInitializer(@Qualifier("postgresDataSource") DataSource postgresDataSource) {
		ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
		resourceDatabasePopulator.addScript(new ClassPathResource("postgres/schema-postgres.sql"));
		resourceDatabasePopulator.addScript(new ClassPathResource("postgres/data-postgres.sql"));

		DataSourceInitializer postgresDataSourceInitializer = new DataSourceInitializer();
		postgresDataSourceInitializer.setDataSource(postgresDataSource);
		postgresDataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
		return postgresDataSourceInitializer;
	}

}
