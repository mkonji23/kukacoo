package com.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.mapper.TranactionMapper;
import com.user.mapper.userMapper;
import com.user.service.userService;
import com.user.vo.userVO;

@Service
public class userServiceImpl implements userService {
	
    private userMapper userMapper;
    private TranactionMapper tMapper;
	 
    // 생성자 주입 ㄱ;
	@Autowired
	public userServiceImpl(userMapper userMapper,TranactionMapper tMapper) {
		this.userMapper = userMapper;
		this.tMapper = tMapper;
	}
	
	@Override
	public List<HashMap<String, Object>> getUserList() throws Exception {
		return userMapper.getUserList();
	}

	@Override
	public int insertTestList(Map<String, Object> map) throws Exception {
		int result = tMapper.insertTestList(map);
		return result;
		
	}

}
