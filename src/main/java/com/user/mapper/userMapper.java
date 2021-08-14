package com.user.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.Alias;

import com.user.vo.userVO;

@Mapper
@Alias("userVO")
public interface userMapper {
	 List<HashMap<String,Object>> getUserList() throws Exception;
	 Map<String,Object> getUserList2(userVO vo) throws Exception;
	 int insertTestList(userVO vo) throws Exception;
	 int insertTestListSid(userVO vo) throws Exception;
}
