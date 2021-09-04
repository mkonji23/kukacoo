package com.user.vo;

import lombok.Data;

@Data
public class userVO {
	private String userId;
	private String userPassword;
	private String userName;
	private String userDescription;
	private String saltKey;
	private String token;
	
}
