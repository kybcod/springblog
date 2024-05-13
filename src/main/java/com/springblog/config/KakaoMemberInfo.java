package com.springblog.config;

import com.springblog.domain.OAuth2MemberInfo;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class KakaoMemberInfo implements OAuth2MemberInfo {
    private Map<String, Object> attributes;

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String getProvider() {
        return "kakao";
    }

    @Override
    public String getProviderId() {
        return (String) attributes.get("id");
    }

    @Override
    public String getNickName() {
        return (String) attributes.get("nickname");
    }
}
