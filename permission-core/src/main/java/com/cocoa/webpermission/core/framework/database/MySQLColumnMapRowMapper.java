package com.cocoa.webpermission.core.framework.database;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.support.JdbcUtils;
/**
 * 提供MysqlColumnMapRowMapper decimal适配
 * @author CocoaDing
 * created on 2018年12月26日 上午11:12:51	
 *
 */
public class MySQLColumnMapRowMapper extends ColumnMapRowMapper {
	@Override
	public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Map<String, Object> mapOfColValues = createColumnMap(columnCount);
		for (int i = 1; i <= columnCount; i++) {
			String key = getColumnKey(JdbcUtils.lookupColumnName(rsmd, i));
			Object obj = null;
			String type=rsmd.getColumnTypeName(i).toLowerCase();
			if(type.equals("decimal")) {
				obj=rs.getBigDecimal(i);
			}else {
				obj=getColumnValue(rs, i);
			}
			mapOfColValues.put(key, obj);
		}
		return mapOfColValues;
	}
	
}
