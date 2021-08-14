package com.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.utill.KeyGenerateUtil;
import com.common.utill.MessageDigestHelper;
import com.user.mapper.userMapper;
import com.user.service.userService;
import com.user.vo.userVO;

@Service
@Transactional
public class userServiceImpl implements userService {
	
    private userMapper userMapper;
	 
    // 생성자 주입 ㄱ;
	@Autowired
	public userServiceImpl(userMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	@Override
	public List<HashMap<String, Object>> getUserList() throws Exception {
		return userMapper.getUserList();
	}
	
	@Description("데이터 저장")
	@Override
	public int insertTestList(userVO vo) throws Exception {
		vo.setUserPassword(MessageDigestHelper.getSHA256AsBase64(vo.getUserPassword(), KeyGenerateUtil.getSalt(), 2));
		int result = userMapper.insertTestList(vo);
		return result;
		
	}

	@Override
	public int getUserChk(userVO vo) throws Exception {
		// TODO Auto-generated method stub
		 Map<String,Object> map = userMapper.getUserList2(vo);
		 String encryPassword = (String) map.get("userpassword");
		 String textPassword =  MessageDigestHelper.getSHA256AsBase64(vo.getUserPassword(), KeyGenerateUtil.getSalt(), 2);
		 if(encryPassword.equals(textPassword)) {
			 return 1;
		 }
		
		return 0;
	}


}
