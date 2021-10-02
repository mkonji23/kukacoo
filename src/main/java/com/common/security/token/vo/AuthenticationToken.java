package com.common.security.token.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

@Getter
@NoArgsConstructor
public class AuthenticationToken {

    @Id
    private String token;

    public AuthenticationToken updateValue(String token) {
        this.token = token;
        return this;
    }

    @Builder
    public AuthenticationToken(String token) {
        this.token = token;
    }
}