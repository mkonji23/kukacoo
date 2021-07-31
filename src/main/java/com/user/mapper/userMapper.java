package com.user.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.Alias;

@Mapper
@Alias("userVO")
public interface userMapper {
	 List<HashMap<String,Object>> getUserList() throws Exception;;
}
