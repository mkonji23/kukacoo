package com.user.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.Alias;

@Mapper
public interface TranactionMapper {
	 int insertTestList(Map<String, Object> map) throws Exception;;
}
