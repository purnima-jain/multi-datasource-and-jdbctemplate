package com.purnima.jain.multidatasource.jdbctemplate.mysql.repo;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MySqlCustomerRepository {

	@Autowired
	@Qualifier("mySqlJdbcTemplate")
	private NamedParameterJdbcTemplate mySqlJdbcTemplate;

	public Integer findCount() {
		String sql = "SELECT COUNT(*) FROM customer_mysql";

		Integer countOfRows = mySqlJdbcTemplate.queryForObject(sql, new HashMap<>(), Integer.class);
		return countOfRows;
	}

}
