package com.common.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
 
	   private static final String[] AUTH_WHITELIST = {
	            // -- Swagger UI v2
	            "/v2/api-docs",
	            "/swagger-resources",
	            "/swagger-resources/**",
	            "/configuration/ui",
	            "/configuration/security",
	            "/swagger-ui.html",
	            "/webjars/**",
	            // -- Swagger UI v3 (OpenAPI)
	            "/v3/api-docs/**",
	            "/swagger-ui/**"
	            // other public endpoints of your API may be appended to this array
	            ,"/api/v1/**"
	    };
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // 개발 편의성을 위해 CSRF 프로텍션을 비활성화
            .csrf()
                .disable()
            // HTTP 기본 인증 비활성화
            .httpBasic()
                .disable()
            // 폼 기반 인증 비활성화  
            .formLogin()
                .disable()
            // stateless한 세션 정책 설정  
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
            // 리소스 별 허용 범위 설정  
            .authorizeRequests()      
                .antMatchers(AUTH_WHITELIST)
                    .permitAll()
                .anyRequest()
                    .authenticated()
                .and()
            // 인증 오류 발생 시 처리를 위한 핸들러 추가  
            .exceptionHandling()
                .authenticationEntryPoint(new RestAuthenticationEntryPoint())
        ;
    }
}