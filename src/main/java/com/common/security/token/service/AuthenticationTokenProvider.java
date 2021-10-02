package com.common.security.token.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.common.security.token.vo.AuthenticationToken;

@Service
public interface AuthenticationTokenProvider {
	 /***
     * HTTP 요청에서 토큰 취득
     * @param request HTTP 요청
     * @return 토큰
     */
    String parseTokenString(HttpServletRequest request);
 
    /***
     * 토큰 발급
     * @param userNo 유저 No
     * @return 토큰
     */
    AuthenticationToken issue(String userId);
 
    /***
     * 토큰에서 userNo 취득
     * @param token 토큰
     * @return userNo
     */
    Long getTokenOwnerNo(String token);
 
    /***
     * 토큰 유효성 검사
     * @param token 토큰
     * @return 유효여부
     */
    boolean validateToken(String token);
    
    /***
     * 토큰 만들깅 
     * @param userId 사용자아이디
     * @return 토큰값
     */
    String getIssueTokenById(String userId);
}
