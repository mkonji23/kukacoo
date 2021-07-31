package com.user.web;


import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.user.service.userService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@Api(value = "user Controller", description = "HomeController 테스트입니다.") // Controller에 대한 Swagger 설명
@RequestMapping("/user")
public class userController{
	private userService userService;
	
	public userController(userService service) {
		this.userService = service;
	}
	 @ApiOperation(  // API에 대한 Swagger 설명
	            value="유저리스트",
	            notes = "사용자 정보를 출력한다.",
	            httpMethod = "POST",
	            consumes = "application/json",
	            produces = "application/json",
	            protocols = "http",
	            responseHeaders = {
	                    //headers
	            })
	    @ApiResponses({  // Response Message에 대한 Swagger 설명
	            @ApiResponse(code = 200, message = "OK"),
	            @ApiResponse(code = 404, message = "No params")
	    })
	@PostMapping(value = "/test")
	public ResponseEntity<?> insertTest() throws Exception {
		return ResponseEntity.ok(userService.getUserList());
	}
	 
	 @ApiOperation(  // API에 대한 Swagger 설명
	            value="유저 정보저장",
	            notes = "사용자 유저정보를 저장한다.",
	            httpMethod = "POST",
	            consumes = "application/json",
	            produces = "application/json",
	            protocols = "http",
	            responseHeaders = {
	                    //headers
	            })
	    @ApiResponses({  // Response Message에 대한 Swagger 설명
	            @ApiResponse(code = 200, message = "OK"),
	            @ApiResponse(code = 404, message = "No params")
	    })
	 
	@PostMapping(value = "/save")
	public ResponseEntity<?> userList(
			@ApiParam("MAP 객체") 
			@RequestBody Map<String,Object> map) throws Exception {
		return ResponseEntity.ok(userService.insertTestList(map));
	}
	 
	 @GetMapping(value = "/long")
		public ResponseEntity<?> longMsgList(
				@ApiParam("메시지를 날려랑") 
				@RequestParam String msg) throws Exception {
		 String defaultMsg = "글자수테스트글자수테스트글자수테스트글자수테스트글자수테스트글자수테스트글자수테스트글자수테스트글자수테스트글자수테스트글자수테스트";
		 	log.info(defaultMsg);
			return ResponseEntity.ok(msg);
	}

}
