package com.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface userService {
	List<HashMap<String,Object>> getUserList() throws Exception;
	int insertTestList(Map<String, Object> map) throws Exception;
}
