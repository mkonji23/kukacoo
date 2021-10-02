package com.user.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.user.vo.userVO;

@Service
public interface userService {
	List<HashMap<String,Object>> getUserList() throws Exception;
	
	int getUserChk(userVO vo) throws Exception;
	
	int insertTestList(userVO vo) throws Exception;
	
	String issueToken(String UserId);
}
