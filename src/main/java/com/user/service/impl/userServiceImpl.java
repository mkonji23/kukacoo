package com.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.security.token.service.AuthenticationTokenProvider;
import com.common.security.token.vo.AuthenticationToken;
import com.common.utill.KeyGenerateUtil;
import com.common.utill.MessageDigestHelper;
import com.user.mapper.userMapper;
import com.user.service.userService;
import com.user.vo.userVO;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class userServiceImpl implements userService {
	
    private userMapper userMapper;
//    @Autowired
//    private AuthenticationToken authenticationToken;
    @Autowired
    private AuthenticationTokenProvider authenticationTokenProvider;
	 
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
		String saltKey = KeyGenerateUtil.getSalt();
		vo.setUserPassword(MessageDigestHelper.getSHA256AsBase64(vo.getUserPassword(), saltKey, 2));
		vo.setSaltKey(saltKey);
		int result = userMapper.insertTestList(vo);
		return result;
		
	}

	@Override
	public int getUserChk(userVO vo) throws Exception {
		// TODO Auto-generated method stub
		 Map<String,Object> map = userMapper.getUserList2(vo);
		 String encryPassword = (String) map.get("userpassword");
		 String saltKey = (String) map.get("saltkey");
		 String textPassword =  MessageDigestHelper.getSHA256AsBase64(vo.getUserPassword(), saltKey, 2);
		 
		 log.info("encryPassword: {}",encryPassword);
		 log.info("textPassword: {}",textPassword);
		 
		 if(encryPassword.equals(textPassword)) {
			 return 1;
		 }
		
		return 0;
	}

	@Override
	public String issueToken(String User) {
//		authenticationTokenProvider.issue(User);
//		log.info(authenticationToken.getToken());
		return authenticationTokenProvider.getIssueTokenById(User);
	}


}
