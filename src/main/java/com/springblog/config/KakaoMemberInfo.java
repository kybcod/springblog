package com.springblog.config;

import com.springblog.domain.OAuth2MemberInfo;

import java.util.Map;


public class KakaoMemberInfo implements OAuth2MemberInfo {
    private Map<String, Object> attributes;
    private final Map<String, Object> profileAttributes;

    public KakaoMemberInfo(Map<String, Object> attributes) {
        this.attributes = (Map<String, Object>) attributes.get("kakao_account");
        this.profileAttributes = (Map<String, Object>) this.attributes.get("profile");
    }

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
        return (String) profileAttributes.get("nickname");
    }
}
