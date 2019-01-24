package com.cocoa.webpermission.core.framework.database.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.cocoa.webpermission.core.framework.database.BaseDao;
import com.cocoa.webpermission.core.framework.util.ReflectUtil;
import com.mysql.jdbc.Statement;

public class BaseDaoImpl implements BaseDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insert(Object t) {
		final String sql=ReflectUtil.getInsertSql(t);
		KeyHolder keyholder=new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				return ps;
			}
		}, keyholder);
		
	}

	@Override
	public <T> T getById(String id, T t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> void update(T t) {
		// TODO Auto-generated method stub
		
	}
	
	

}
