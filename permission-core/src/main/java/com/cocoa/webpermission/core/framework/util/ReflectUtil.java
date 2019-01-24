package com.cocoa.webpermission.core.framework.util;

import java.lang.reflect.Field;

import com.cocoa.webpermission.core.framework.database.annotation.DbField;
import com.cocoa.webpermission.core.framework.database.annotation.PrimaryKey;
import com.cocoa.webpermission.core.framework.database.annotation.Table;

public class ReflectUtil {

	public static String getInsertSql(Object t) {
		StringBuffer buffer=new StringBuffer("insert into ");
		Class clazz=t.getClass();
		if(!clazz.isAnnotationPresent(Table.class)) {
			throw null;
		}
		Field [] fields=clazz.getDeclaredFields();
		for (Field field : fields) {
			PrimaryKey primarykey=	field.getAnnotation(PrimaryKey.class);
			if(null==primarykey) {
				DbField dbField=field.getAnnotation(DbField.class);
				if(null==dbField) {
					continue;
				}else {
					dbField.value();
					field.isAccessible();
				}
			}
		}
		return null;
	}

}
