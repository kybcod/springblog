package com.springblog.config;

import com.springblog.domain.OAuth2MemberInfo;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class NaverMemberInfo implements OAuth2MemberInfo {

    private Map<String, Object> attributes;

    // naver OAuth2로부터 받은 사용자 정보 추출
    @Override
    public String getProviderId() {
        return (String) attributes.get("id");
    }

    @Override
    public String getNickName() {
        return (String) attributes.get("nickname");
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String getProvider() {
        return "naver";
    }
}
