package com.springblog.config;

import com.springblog.domain.OAuth2MemberInfo;

import java.util.Map;

public class KakaoMemberInfo implements OAuth2MemberInfo {
    public KakaoMemberInfo(Map response) {
    }

    @Override
    public String getEmail() {
        return "";
    }

    @Override
    public String getProvider() {
        return "";
    }

    @Override
    public String getProviderId() {
        return "";
    }

    @Override
    public String getNickName() {
        return "";
    }
}
