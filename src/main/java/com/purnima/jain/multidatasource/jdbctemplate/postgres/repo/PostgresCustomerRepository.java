package com.purnima.jain.multidatasource.jdbctemplate.postgres.repo;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PostgresCustomerRepository {

	@Autowired
	@Qualifier("postgresJdbcTemplate")
	private NamedParameterJdbcTemplate postgresJdbcTemplate;

	public Integer findCount() {
		String sql = "SELECT COUNT(*) FROM customer_postgres";

		Integer countOfRows = postgresJdbcTemplate.queryForObject(sql, new HashMap<>(), Integer.class);
		return countOfRows;
	}

}
