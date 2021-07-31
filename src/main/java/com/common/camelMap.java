package com.common;

import java.util.HashMap;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.jdbc.support.JdbcUtils;

@SuppressWarnings("serial")
public class camelMap extends HashMap<String, Object> {
	// StringUtils.lowerCase 로 key값을 소문자로 변경 (USER_NAME => user_name)
	//JdbcUtils.convertUnderscoreNameToPropertyName 로 key값을 camelCase로 변경 (user_name => userName) 
	 @Override
	public Object put(String key, Object value) {
		 return super.put(JdbcUtils.convertUnderscoreNameToPropertyName(StringUtils.lowerCase(key)), value);
	}
}
