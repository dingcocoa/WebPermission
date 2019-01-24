package com.cocoa.webpermission.core.framework.database;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class BaseJdbcTemplate extends JdbcTemplate {
	@Override
	protected RowMapper<Map<String, Object>> getColumnMapRowMapper() {
		// TODO Auto-generated method stub
		return new MySQLColumnMapRowMapper();
	}
}
