package com.user.web;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.user.service.userService;
import com.user.vo.userVO;

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
				@RequestBody userVO vo) throws Exception {
			return ResponseEntity.ok(userService.getUserChk(vo));
		}
	 
	 
	 
	 
	 @ApiOperation(  // API에 대한 Swagger 설명
	            value="유저 사용자 일치",
	            notes = "사용자가 ID/PW가 일치한는지 확인.",
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
		@PostMapping(value = "/chk")
		public ResponseEntity<?> matchUser(@RequestBody userVO vo) throws Exception {
			return ResponseEntity.ok(userService.insertTestList(vo));
		}
		 
	 

}
